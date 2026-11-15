package com.example.calculator

import android.content.Context
import android.graphics.Color as AColor
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Backspace
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.json.JSONArray
import org.json.JSONObject

val Blue = Color(0xFF4A6CFF)
val KeyBg = Color(0xFF171717)
val OpBg = Color(0xFF101521)
val PanelBg = Color(0xFF1C1D1F)
val Grey = Color(0xFFA0A0A0)
val Txt = Color(0xFFE3E3E3)

data class Entry(val expr: String, val result: String, val count: Int)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(AColor.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.dark(AColor.TRANSPARENT)
        )
        setContent { CalcApp() }
    }
}

val numRe = Regex("\\d+\\.?\\d*|\\.\\d+")

fun comma(s: String): String {
    val p = s.split(".")
    val i = p[0].reversed().chunked(3).joinToString(",").reversed()
    return if (p.size > 1) "$i.${p[1]}" else i
}
fun show(s: String) = numRe.replace(s) { comma(it.value) }
    .replace('*', '×').replace('/', '÷').replace('-', '−')

fun fmt(d: Double): String {
    val r = java.math.BigDecimal(d).round(java.math.MathContext(12)).stripTrailingZeros()
    return r.toPlainString()
}

fun evalExpr(s: String): Double? {
    val nums = mutableListOf<Double>(); val ops = mutableListOf<Char>()
    var i = 0; var neg = false
    if (s.startsWith("-")) { neg = true; i = 1 }
    while (i < s.length) {
        val st = i
        while (i < s.length && (s[i].isDigit() || s[i] == '.')) i++
        if (st == i) return null
        var v = s.substring(st, i).toDoubleOrNull() ?: return null
        if (i < s.length && s[i] == '%') { v /= 100; i++ }
        if (neg) { v = -v; neg = false }
        nums.add(v)
        if (i < s.length) { ops.add(s[i]); i++ }
    }
    if (nums.isEmpty() || ops.size != nums.size - 1) return null
    val n2 = mutableListOf(nums[0]); val o2 = mutableListOf<Char>()
    for (k in ops.indices) {
        val b = nums[k + 1]
        when (ops[k]) {
            '*' -> n2[n2.lastIndex] = n2.last() * b
            '/' -> { if (b == 0.0) return null; n2[n2.lastIndex] = n2.last() / b }
            else -> { o2.add(ops[k]); n2.add(b) }
        }
    }
    var r = n2[0]
    for (k in o2.indices) r = if (o2[k] == '+') r + n2[k + 1] else r - n2[k + 1]
    return r
}

class Calc(private val ctx: Context) {
    var expr by mutableStateOf("")
    var error by mutableStateOf(false)
    var done = false
    val hist = mutableStateListOf<Entry>()
    private val prefs = ctx.getSharedPreferences("calc", Context.MODE_PRIVATE)

    init {
        try {
            val a = JSONArray(prefs.getString("history", "[]"))
            for (i in 0 until a.length()) {
                val o = a.getJSONObject(i)
                hist.add(Entry(o.getString("e"), o.getString("r"), o.getInt("c")))
            }
        } catch (_: Exception) {}
    }

    fun save() {
        val a = JSONArray()
        hist.take(100).forEach { a.put(JSONObject().put("e", it.expr).put("r", it.result).put("c", it.count)) }
        prefs.edit().putString("history", a.toString()).apply()
    }
    fun clearHistory() { hist.clear(); save() }

    private fun lastNum() = Regex("(\\d+\\.?\\d*|\\.\\d+)%?$").find(expr)

    fun press(k: String) {
        error = false
        val last = expr.lastOrNull()
        when {
            k.length == 1 && k[0].isDigit() -> {
                if (done) { expr = ""; done = false }
                if (last == '%') return
                if (expr.endsWith("0") && lastNum()?.value == "0") expr = expr.dropLast(1)
                expr += k
            }
            k == "." -> {
                if (done) { expr = ""; done = false }
                val m = Regex("[\\d.]+$").find(expr)
                if (m != null && m.value.contains('.')) return
                expr += if (last?.isDigit() == true) "." else "0."
            }
            k in listOf("+", "-", "*", "/") -> {
                done = false
                if (expr.isEmpty()) { if (k == "-") expr = "-"; return }
                if (last in listOf('+', '-', '*', '/')) { if (expr.length == 1) return; expr = expr.dropLast(1) }
                expr += k
            }
            k == "%" -> if (last?.isDigit() == true) { done = false; expr += "%" }
            k == "AC" -> { expr = ""; done = false }
            k == "del" -> { if (done) { expr = ""; done = false } else expr = expr.dropLast(1) }
            k == "neg" -> {
                val m = lastNum() ?: return
                val i = m.range.first
                val b = expr.getOrNull(i - 1)
                expr = when {
                    b == '-' && (i - 1 == 0 || expr[i - 2] in "+-*/") -> expr.removeRange(i - 1, i)
                    i == 0 -> "-$expr"
                    b == '+' -> expr.replaceRange(i - 1, i, "-")
                    b == '-' -> expr.replaceRange(i - 1, i, "+")
                    else -> expr.substring(0, i) + "-" + expr.substring(i)
                }
            }
            k == "=" -> equals()
        }
    }

    private fun equals() {
        val s = expr.trimEnd('+', '-', '*', '/', '.')
        if (s.isEmpty() || !Regex("[+\\-*/%]").containsMatchIn(s.removePrefix("-"))) return
        val count = numRe.findAll(s).count()
        val v = evalExpr(s)
        if (v == null || v.isNaN() || v.isInfinite()) { expr = ""; error = true; return }
        val r = fmt(v)
        hist.add(0, Entry(s, r, count)); save()
        expr = r; done = true
    }
}

@Composable
fun CalcApp() {
    val ctx = androidx.compose.ui.platform.LocalContext.current
    val calc = remember { Calc(ctx) }
    var showHist by remember { mutableStateOf(false) }

    Column(
        Modifier.fillMaxSize().background(Color.Black).statusBarsPadding().navigationBarsPadding()
    ) {
        Row(
            Modifier.fillMaxWidth().padding(start = 22.dp, end = 22.dp, top = 22.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(Icons.Outlined.FullscreenExit, null, tint = Color.White, modifier = Modifier.size(28.dp))
            Icon(Icons.Outlined.Settings, null, tint = Color.White, modifier = Modifier.size(28.dp))
        }

        Box(Modifier.weight(1f).fillMaxWidth().padding(end = 14.dp), contentAlignment = Alignment.CenterEnd) {
            val text = if (calc.error) "Error" else show(calc.expr)
            val size = if (text.length <= 9) 60f else maxOf(24f, 60f * 9f / text.length)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text, color = Txt, fontSize = size.sp, fontWeight = FontWeight.Light, maxLines = 1, softWrap = false)
                if (!showHist) Box(Modifier.padding(start = 2.dp).width(2.dp).height(76.dp).background(Blue))
            }
        }

        Row(Modifier.fillMaxWidth().height(50.dp).padding(start = 18.dp, end = 22.dp), verticalAlignment = Alignment.CenterVertically) {
            ToolIcon(if (showHist) Icons.Outlined.Calculate else Icons.Outlined.History, showHist) { showHist = !showHist }
            ToolIcon(Icons.Outlined.Functions, false) {}
            ToolIcon(Icons.Outlined.CurrencyExchange, false) {}
            Spacer(Modifier.weight(1f))
            if (showHist) Icon(Icons.AutoMirrored.Outlined.Backspace, null, tint = Blue,
                modifier = Modifier.size(34.dp).clip(CircleShape).clickable { calc.press("del") }.padding(4.dp))
        }
        HorizontalDivider(color = Color(0xFF222222))
        Spacer(Modifier.height(15.dp))

        val ops = listOf("÷" to "/", "×" to "*", "−" to "-", "+" to "+", "=" to "=")
        if (showHist) {
            Row(Modifier.fillMaxWidth().padding(start = 19.dp, end = 22.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                HistoryPanel(calc)
                Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                    ops.forEach { (l, k) -> Key(l, null, k == "=") { calc.press(k) } }
                }
            }
        } else {
            val rows = listOf(
                listOf("AC", "del", "neg", "/"), listOf("7", "8", "9", "*"), listOf("4", "5", "6", "-"),
                listOf("1", "2", "3", "+"), listOf("%", "0", ".", "=")
            )
            Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                rows.forEach { row ->
                    Row(Modifier.fillMaxWidth().padding(horizontal = 22.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        row.forEach { k ->
                            when {
                                k == "AC" -> Key("AC", null, false, op = true) { calc.press(k) }
                                k == "del" -> Key(null, Icons.AutoMirrored.Outlined.Backspace, false, op = true) { calc.press(k) }
                                k == "neg" -> Key("+/_", null, false, op = true) { calc.press(k) }
                                k in listOf("/", "*", "-", "+") -> Key(ops.first { it.second == k }.first, null, false) { calc.press(k) }
                                k == "=" -> Key("=", null, true) { calc.press(k) }
                                else -> Key(k, null, false, digit = true) { calc.press(k) }
                            }
                        }
                    }
                }
            }
        }
        Spacer(Modifier.height(30.dp))
    }
}

@Composable
fun ToolIcon(icon: ImageVector, active: Boolean, onClick: () -> Unit) {
    Box(Modifier.size(52.dp), contentAlignment = Alignment.Center) {
        Box(
            Modifier.size(34.dp).clip(CircleShape).background(if (active) Color(0xFF1B1C1E) else Color.Transparent)
                .clickable(onClick = onClick),
            contentAlignment = Alignment.Center
        ) { Icon(icon, null, tint = Color(0xFFBBBBBB), modifier = Modifier.size(24.dp)) }
    }
}

@Composable
fun Key(label: String?, icon: ImageVector?, equals: Boolean, op: Boolean = false, digit: Boolean = false, onClick: () -> Unit) {
    val bg = when { equals -> Blue; digit -> KeyBg; else -> OpBg }
    val fg = when { equals -> Color.White; digit -> Txt; else -> Blue }
    Box(
        Modifier.size(66.dp, 51.dp).clip(CircleShape).background(bg).clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        if (label != null) Text(label, color = fg, fontSize = if (op && label == "AC") 26.sp else 28.sp, fontWeight = FontWeight.Light)
        if (icon != null) Icon(icon, null, tint = fg, modifier = Modifier.size(30.dp))
    }
}

@Composable
fun HistoryPanel(calc: Calc) {
    val total = calc.hist.sumOf { it.count }
    Column(Modifier.width(278.dp).height(337.dp).clip(RoundedCornerShape(28.dp)).background(PanelBg)) {
        LazyColumn(Modifier.weight(1f).padding(horizontal = 20.dp)) {
            item {
                Row(Modifier.fillMaxWidth().padding(top = 16.dp, bottom = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("$total item${if (total == 1) "" else "s"} added in total", color = Grey, fontSize = 13.sp)
                    Text("Today", color = Blue, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }
            }
            if (calc.hist.isEmpty()) item {
                Text("No history yet", color = Grey, fontSize = 16.sp, textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 40.dp))
            }
            items(calc.hist) { e ->
                Column(Modifier.fillMaxWidth().padding(top = 12.dp)) {
                    Text(e.expr.replace('*', '×').replace('/', '÷').replace('-', '−'), color = Grey, fontSize = 19.sp,
                        textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth().clickable { calc.expr = e.result; calc.done = true })
                    Row(Modifier.fillMaxWidth().padding(vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically) {
                        Text("${e.count} item${if (e.count == 1) "" else "s"} added", color = Blue, fontSize = 13.sp,
                            modifier = Modifier.clip(CircleShape).background(Color(0xFF232A45)).padding(horizontal = 10.dp, vertical = 3.dp))
                        Text("=" + comma(e.result), color = Txt, fontSize = 26.sp)
                    }
                    HorizontalDivider(color = Color(0xFF3A3B3D))
                }
            }
        }
        Box(Modifier.fillMaxWidth().background(Color(0xFF232220)).clickable { calc.clearHistory() }.padding(vertical = 16.dp),
            contentAlignment = Alignment.Center) {
            Text("Clear history", color = Blue, fontSize = 20.sp)
        }
    }
}
