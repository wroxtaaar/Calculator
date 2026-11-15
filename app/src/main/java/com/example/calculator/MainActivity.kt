package com.example.calculator

import android.content.Context
import android.graphics.Color as AndroidColor
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Backspace
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.json.JSONArray
import org.json.JSONObject
import java.math.BigDecimal
import java.math.MathContext

private val VivoBlue = Color(0xFF579CF8)
private val White = Color(0xFFFFFFFF)
private val NumberKey = Color(0xFFF7F7F7)
private val SpecialKey = Color(0xFFF1F4FF)
private val MainText = Color(0xFF111111)
private val Grey = Color(0xFF666666)
private val EqualYellow = Color(0xFFFFC335)
private val Line = Color(0xFFECECEC)

private data class HistoryEntry(val expression: String, val result: String, val time: Long)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(White.toArgb(), AndroidColor.BLACK),
            navigationBarStyle = SystemBarStyle.light(White.toArgb(), AndroidColor.BLACK)
        )
        setContent { CalculatorApp() }
    }
}

private class CalculatorState(context: Context) {
    private val prefs = context.getSharedPreferences("vivo_calculator", Context.MODE_PRIVATE)
    var expression by mutableStateOf("")
        private set
    var error by mutableStateOf(false)
        private set
    var completed by mutableStateOf(false)
        private set
    val history = mutableStateListOf<HistoryEntry>()

    init {
        runCatching {
            val data = JSONArray(prefs.getString("history", "[]"))
            for (i in 0 until data.length()) {
                val item = data.getJSONObject(i)
                history.add(HistoryEntry(item.getString("expression"), item.getString("result"), item.optLong("time")))
            }
        }
    }

    fun clear() { expression = ""; error = false; completed = false }
    fun delete() {
        error = false
        if (completed) clear() else expression = expression.dropLast(1)
    }

    fun press(key: String) {
        error = false
        val last = expression.lastOrNull()
        when {
            key.length == 1 && key[0].isDigit() -> {
                if (completed) clear()
                if (expression.lastOrNull() == '%') return
                val number = Regex("(?:\\d+\\.?\\d*|\\.\\d+)$").find(expression)?.value
                if (number == "0") expression = expression.dropLast(1)
                expression += key
            }
            key == "." -> {
                if (completed) clear()
                val number = Regex("(?:\\d+\\.?\\d*|\\.\\d+)$").find(expression)?.value.orEmpty()
                if (!number.contains('.')) expression += if (number.isEmpty()) "0." else "."
            }
            key in listOf("+", "−", "×", "÷") -> {
                completed = false
                val op = when (key) { "−" -> "-"; "×" -> "*"; "÷" -> "/"; else -> key }
                if (expression.isEmpty()) { if (op == "-") expression = "-"; return }
                if (last in listOf('+', '-', '*', '/')) {
                    if (expression.length == 1 && last == '-') return
                    expression = expression.dropLast(1)
                }
                expression += op
            }
            key == "%" -> if (!completed && (last?.isDigit() == true || last == '.')) expression += "%"
            key == "±" -> toggleSign()
            key == "AC" -> clear()
            key == "DEL" -> delete()
            key == "=" -> calculate()
        }
    }

    private fun toggleSign() {
        if (expression.isEmpty() || completed) return
        val match = Regex("(?:\\d+\\.?\\d*|\\.\\d+)%?$").find(expression) ?: return
        val start = match.range.first
        val before = expression.getOrNull(start - 1)
        expression = when {
            before == '-' && (start == 1 || expression.getOrNull(start - 2) in listOf('+', '-', '*', '/')) -> expression.removeRange(start - 1, start)
            start == 0 -> "-$expression"
            before == '+' -> expression.replaceRange(start - 1, start, "-")
            before == '-' -> expression.replaceRange(start - 1, start, "+")
            else -> expression.substring(0, start) + "-" + expression.substring(start)
        }
    }

    fun calculate() {
        val input = expression.trimEnd('+', '-', '*', '/', '.')
        if (input.isBlank()) return
        val result = runCatching { Parser(input).parse() }.getOrNull()
        if (result == null || !result.isFinite()) { error = true; return }
        val formatted = format(result)
        history.add(0, HistoryEntry(input, formatted, System.currentTimeMillis()))
        if (history.size > 100) history.removeAt(history.lastIndex)
        saveHistory()
        expression = formatted
        completed = true
    }

    fun restore(entry: HistoryEntry) { expression = entry.result; error = false; completed = true }
    fun clearHistory() { history.clear(); saveHistory() }

    private fun saveHistory() {
        val array = JSONArray()
        history.forEach { array.put(JSONObject().put("expression", it.expression).put("result", it.result).put("time", it.time)) }
        prefs.edit().putString("history", array.toString()).apply()
    }
}

private class Parser(private val input: String) {
    private var pos = 0
    fun parse(): Double {
        val value = expression()
        spaces()
        require(pos == input.length)
        return value
    }
    private fun expression(): Double {
        var value = term()
        while (true) {
            spaces()
            value = when { take('+') -> value + term(); take('-') -> value - term(); else -> return value }
        }
    }
    private fun term(): Double {
        var value = unary()
        while (true) {
            spaces()
            value = when {
                take('*') -> value * unary()
                take('/') -> { val divisor = unary(); require(divisor != 0.0); value / divisor }
                else -> return value
            }
        }
    }
    private fun unary(): Double {
        spaces()
        return when { take('+') -> unary(); take('-') -> -unary(); else -> postfix() }
    }
    private fun postfix(): Double {
        var value = primary()
        while (true) { spaces(); if (take('%')) value /= 100.0 else return value }
    }
    private fun primary(): Double {
        spaces()
        if (take('(')) { val v = expression(); spaces(); require(take(')')); return v }
        val start = pos
        var dots = 0
        while (pos < input.length && (input[pos].isDigit() || input[pos] == '.')) {
            if (input[pos] == '.') dots++
            pos++
        }
        require(pos > start && dots <= 1)
        return input.substring(start, pos).toDouble()
    }
    private fun take(c: Char): Boolean {
        if (pos < input.length && input[pos] == c) { pos++; return true }
        return false
    }
    private fun spaces() { while (pos < input.length && input[pos].isWhitespace()) pos++ }
}

private fun format(value: Double): String =
    if (value == 0.0) "0" else BigDecimal(value.toString()).round(MathContext(12)).stripTrailingZeros().toPlainString()

private fun pretty(value: String) = value.replace('*', '×').replace('/', '÷').replace('-', '−')

@Composable
private fun CalculatorApp() {
    val context = androidx.compose.ui.platform.LocalContext.current
    val calc = remember { CalculatorState(context) }
    var historyVisible by remember { mutableStateOf(false) }
    var settingsVisible by remember { mutableStateOf(false) }

    Column(Modifier.fillMaxSize().background(White).statusBarsPadding().navigationBarsPadding().padding(bottom = 8.dp)) {
        Row(
            Modifier.fillMaxWidth().height(76.dp).padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(Modifier.size(44.dp).clip(CircleShape).clickable { settingsVisible = true }, contentAlignment = Alignment.Center) {
                Icon(Icons.Outlined.Settings, "Settings", tint = MainText, modifier = Modifier.size(24.dp))
            }
            Text("Calculator", color = Grey, fontSize = 16.sp, fontWeight = FontWeight.Medium)
            Box(Modifier.size(44.dp).clip(CircleShape).clickable { calc.clear() }, contentAlignment = Alignment.Center) {
                Icon(Icons.AutoMirrored.Outlined.Backspace, "Clear input", tint = MainText, modifier = Modifier.size(23.dp))
            }
        }

        Column(
            Modifier.weight(1f).fillMaxWidth().padding(horizontal = 24.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {
            if (calc.expression.isBlank()) {
                Text("0", color = MainText, fontSize = 58.sp, fontWeight = FontWeight.Light)
            } else {
                Text(
                    if (calc.error) "Error" else pretty(calc.expression),
                    color = if (calc.error) Color(0xFFE34B4B) else MainText,
                    fontSize = expressionSize(calc.expression).sp,
                    fontWeight = FontWeight.Light,
                    maxLines = 1,
                    softWrap = false,
                    overflow = TextOverflow.Clip,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )
                val preview = runCatching {
                    val s = calc.expression.trimEnd('+', '-', '*', '/', '.')
                    if (!calc.error && !calc.completed && s.isNotBlank()) format(Parser(s).parse()) else ""
                }.getOrDefault("")
                if (preview.isNotBlank() && preview != calc.expression) {
                    Text(preview, color = Grey, fontSize = 28.sp, modifier = Modifier.padding(top = 12.dp))
                }
            }
        }

        Row(
            Modifier.fillMaxWidth().height(54.dp).padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    Modifier.size(42.dp).clip(CircleShape)
                        .background(if (historyVisible) SpecialKey else Color.Transparent)
                        .clickable { historyVisible = !historyVisible },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Outlined.History, "History", tint = VivoBlue, modifier = Modifier.size(25.dp))
                }
                Text(if (historyVisible) "History" else "Recent calculations", color = Grey, fontSize = 13.sp, modifier = Modifier.padding(start = 8.dp))
            }
            if (historyVisible) {
                Text("Clear", color = VivoBlue, modifier = Modifier.clickable { calc.clearHistory() }.padding(10.dp))
            }
        }
        HorizontalDivider(color = Line)

        if (historyVisible) {
            HistoryPanel(calc.history, { calc.restore(it); historyVisible = false })
        } else {
            Spacer(Modifier.height(14.dp))
            val rows = listOf(
                listOf("AC", "DEL", "±", "÷"),
                listOf("7", "8", "9", "×"),
                listOf("4", "5", "6", "−"),
                listOf("1", "2", "3", "+"),
                listOf("%", "0", ".", "=")
            )
            Column(Modifier.fillMaxWidth().padding(horizontal = 18.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                rows.forEach { row ->
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        row.forEach { key -> CalculatorKey(key, Modifier.weight(1f)) { calc.press(key) } }
                    }
                }
            }
            Spacer(Modifier.height(18.dp))
        }
    }

    if (settingsVisible) {
        AlertDialog(
            onDismissRequest = { settingsVisible = false },
            title = { Text("Calculator settings", color = MainText) },
            text = {
                Text(
                    "Vivo-inspired standard calculator with basic arithmetic, percentage, sign toggle and saved calculation history. Scientific and degree/radian controls are excluded.",
                    color = Grey
                )
            },
            confirmButton = { TextButton(onClick = { settingsVisible = false }) { Text("Done", color = VivoBlue) } },
            containerColor = White
        )
    }
}

private fun expressionSize(value: String): Float = when {
    value.length <= 9 -> 48f
    value.length <= 14 -> 38f
    value.length <= 20 -> 30f
    else -> (600f / value.length).coerceAtLeast(22f)
}

@Composable
private fun CalculatorKey(label: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    val digit = label.length == 1 && label[0].isDigit()
    val bg = when { label == "=" -> EqualYellow; digit -> NumberKey; else -> SpecialKey }
    val fg = if (label == "=") Color.White else if (digit) MainText else VivoBlue
    Box(
        modifier.height(62.dp).clip(CircleShape).background(bg).clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        if (label == "DEL") {
            Icon(Icons.AutoMirrored.Outlined.Backspace, "Delete", tint = fg, modifier = Modifier.size(25.dp))
        } else {
            Text(label, color = fg, fontSize = if (label == "AC") 21.sp else if (label == "±") 25.sp else 27.sp)
        }
    }
}

@Composable
private fun HistoryPanel(entries: List<HistoryEntry>, onSelect: (HistoryEntry) -> Unit) {
    if (entries.isEmpty()) {
        Box(Modifier.fillMaxWidth().fillMaxHeight(), contentAlignment = Alignment.Center) {
            Text("No calculations yet", color = Grey, fontSize = 16.sp)
        }
    } else {
        LazyColumn(
            Modifier.fillMaxWidth().fillMaxHeight().padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            items(entries) { entry ->
                Column(
                    Modifier.fillMaxWidth().clickable { onSelect(entry) }.padding(vertical = 13.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(pretty(entry.expression), color = Grey, fontSize = 17.sp, maxLines = 1)
                    Text(entry.result, color = MainText, fontSize = 25.sp, fontWeight = FontWeight.Medium, modifier = Modifier.padding(top = 4.dp))
                }
                HorizontalDivider(color = Line)
            }
        }
    }
}
