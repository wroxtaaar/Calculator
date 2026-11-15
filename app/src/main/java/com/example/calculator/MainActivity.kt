package com.example.calculator

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Backspace
import androidx.compose.material.icons.outlined.Close
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
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import org.json.JSONArray
import org.json.JSONObject
import java.math.BigDecimal
import java.math.MathContext
import java.text.DateFormat
import java.util.Date

private data class HistoryEntry(val expression: String, val result: String, val time: Long)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Default style: transparent bars whose icons follow the system light/dark mode.
        enableEdgeToEdge()
        setContent { CalculatorApp() }
    }
}

// ---------------------------------------------------------------------------------------------
// Calculator logic (unchanged)
// ---------------------------------------------------------------------------------------------

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

// ---------------------------------------------------------------------------------------------
// Look & feel. Every number below comes from the original Vivo calculator's resources
// (layout/activity_calculator_port.xml, pad_numeric.xml, pad_operator_one_col.xml,
// values/dimens.xml, values-night/colors.xml and the values-hNNNdp overrides).
// ---------------------------------------------------------------------------------------------

private class Palette(
    val background: Color,
    val formula: Color,
    val result: Color,
    val line: Color,
    val numberKey: Color,
    val numberKeyPressed: Color,
    val specialKey: Color,
    val specialKeyPressed: Color,
    val digit: Color,
    val function: Color,
    val equalFill: Color,
    val icon: Color,
    val historyPanel: Color,
    val historyPressed: Color,
    val historyStroke: Color,
    val historyInput: Color,
    val historyResult: Color,
    val historyDate: Color,
    val clearButton: Color,
    val clearButtonPressed: Color,
    val clearText: Color,
    val emptyText: Color
)

private val LightPalette = Palette(
    background = Color(0xFFFFFFFF),
    formula = Color(0xFF000000),
    result = Color(0x59000000),
    line = Color(0x40D1D1D1),
    numberKey = Color(0xFFF7F7F7),
    numberKeyPressed = Color(0xFFDFDFDF),
    specialKey = Color(0xFFF1F4FF),
    specialKeyPressed = Color(0xFFDDE4FF),
    digit = Color(0xFF000000),
    function = Color(0xFF456FFF),
    equalFill = Color(0xFF4060FF),
    icon = Color(0xFF000000),
    historyPanel = Color(0xFFFFFFFF),
    historyPressed = Color(0xFFE8E8E8),
    historyStroke = Color(0xFFF5F5F5),
    historyInput = Color(0xFFAFAFAF),
    historyResult = Color(0xCC333333),
    historyDate = Color(0xFF579CF8),
    clearButton = Color(0xFFF2F2F2),
    clearButtonPressed = Color(0xFFE8E8E8),
    clearText = Color(0xFFDE4E34),
    emptyText = Color(0xFFD1D1D1)
)

private val DarkPalette = Palette(
    background = Color(0xFF000000),
    formula = Color(0xDEFFFFFF),
    result = Color(0x99FFFFFF),
    line = Color(0x26FFFFFF),
    numberKey = Color(0x14FFFFFF),
    numberKeyPressed = Color(0x26FFFFFF),
    specialKey = Color(0xFF101624),
    specialKeyPressed = Color(0xFF182542),
    digit = Color(0xDEFFFFFF),
    function = Color(0xFF456FFF),
    equalFill = Color(0xFF4060FF),
    icon = Color(0xFFFFFFFF),
    historyPanel = Color(0x4071747C),
    historyPressed = Color(0x14D2D1CF),
    historyStroke = Color(0xFF444444),
    historyInput = Color(0xFFAAAAAA),
    historyResult = Color(0xFFFFFFFF),
    historyDate = Color(0xFFDE4E34),
    clearButton = Color(0xFF24221C),
    clearButtonPressed = Color(0xFF4B4D52),
    clearText = Color(0xFFDE4E34),
    emptyText = Color(0x66FFFFFF)
)

private val LocalPalette = staticCompositionLocalOf { LightPalette }

/** Sizes that the original app switches per available screen height (its values-hNNNdp folders). */
private class Metrics(
    val displayTopMargin: Dp,
    val formulaHeight: Dp,
    val bottomPadding: Dp,
    val keyboardHeight: Dp,
    val formulaMaxText: Dp,
    val formulaMinText: Dp
)

private fun metricsFor(heightDp: Int): Metrics {
    // steps must be listed in ascending order of screen height; the last one that fits wins
    fun pick(default: Int, vararg steps: Pair<Int, Int>): Dp {
        var value = default
        for ((minHeight, v) in steps) if (heightDp >= minHeight) value = v
        return value.dp
    }
    return Metrics(
        displayTopMargin = pick(36, 637 to 10, 682 to 12, 696 to 18, 700 to 10, 704 to 22, 710 to 18, 726 to 12, 750 to 32),
        formulaHeight = pick(70, 682 to 90),
        bottomPadding = pick(22, 637 to 8, 726 to 22, 807 to 30),
        keyboardHeight = pick(366, 637 to 318, 682 to 386, 684 to 318, 710 to 352, 726 to 376, 807 to 366),
        formulaMaxText = pick(48, 682 to 60),
        formulaMinText = pick(30, 682 to 38)
    )
}

private val TitleHeight = 76.dp
private val DisplaySideMargin = 16.dp
private val ResultHeight = 40.dp
private val ResultTextSize = 28.dp
private val ToggleRowHeight = 48.dp
private val KeyboardSideMargin = 20.dp

// Cell weights of the original GridLayouts.
private const val NumericWeight = 459f
private const val OperatorWeight = 130f
private const val KeyRowWeight = 60f
private const val GapRowWeight = 13f
private const val KeyColumnWeight = 74f
private const val GapColumnWeight = 8f

/** The original draws text sizes in dp (they ignore the system font scale), so do the same. */
@Composable
private fun Dp.asSp(): TextUnit = with(LocalDensity.current) { this@asSp.toSp() }

private fun Modifier.tap(onClick: () -> Unit): Modifier = composed {
    clickable(interactionSource = remember { MutableInteractionSource() }, indication = null, onClick = onClick)
}

/** The pill from the original key drawables: a 74x60 viewport, inset 3, with 27-radius ends. */
private object KeyShape : Shape {
    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        val sx = size.width / 74f
        val sy = size.height / 60f
        val path = Path().apply {
            moveTo(30f * sx, 3f * sy)
            lineTo(44f * sx, 3f * sy)
            arcTo(Rect(17f * sx, 3f * sy, 71f * sx, 57f * sy), -90f, 180f, false)
            lineTo(30f * sx, 57f * sy)
            arcTo(Rect(3f * sx, 3f * sy, 57f * sx, 57f * sy), 90f, 180f, false)
            close()
        }
        return Outline.Generic(path)
    }
}

private enum class KeyStyle { Number, Special, Equal }

private val SpecialLabels = setOf("AC", "DEL", "±", "÷", "×", "−", "+")

@Composable
private fun CalculatorApp() {
    val context = LocalContext.current
    val calc = remember { CalculatorState(context) }
    var historyVisible by remember { mutableStateOf(false) }
    var settingsVisible by remember { mutableStateOf(false) }
    val palette = if (isSystemInDarkTheme()) DarkPalette else LightPalette
    val metrics = metricsFor(LocalConfiguration.current.screenHeightDp)

    BackHandler(enabled = historyVisible) { historyVisible = false }

    CompositionLocalProvider(LocalPalette provides palette) {
        Column(
            Modifier
                .fillMaxSize()
                .background(palette.background)
                .statusBarsPadding()
                .navigationBarsPadding()
                .padding(bottom = metrics.bottomPadding)
        ) {
            // Title bar: only the settings gear, at the end.
            Box(Modifier.fillMaxWidth().height(TitleHeight)) {
                Box(
                    Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 12.dp)
                        .size(48.dp)
                        .clip(CircleShape)
                        .tap { settingsVisible = true },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Outlined.Settings, "Settings", tint = palette.icon, modifier = Modifier.size(24.dp))
                }
            }

            // Formula + result sit at the top of the free area, like the original.
            Box(Modifier.weight(1f).fillMaxWidth()) {
                Display(calc, metrics)
            }

            // History toggle row with the 1dp divider on its bottom edge.
            Box(Modifier.fillMaxWidth().height(ToggleRowHeight)) {
                Box(
                    Modifier.align(Alignment.TopStart).padding(start = 34.dp).size(26.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        Modifier
                            .requiredSize(48.dp)
                            .clip(CircleShape)
                            .tap { historyVisible = !historyVisible },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            if (historyVisible) Icons.Outlined.Close else Icons.Outlined.History,
                            if (historyVisible) "Close history" else "History",
                            tint = palette.digit.copy(alpha = palette.digit.alpha * 0.8f),
                            modifier = Modifier.size(26.dp)
                        )
                    }
                }
                HorizontalDivider(Modifier.align(Alignment.BottomCenter), thickness = 1.dp, color = palette.line)
            }

            // Keyboard: 459 : 130 split between the number pad (or history) and the operator column.
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(metrics.keyboardHeight)
                    .padding(horizontal = KeyboardSideMargin)
            ) {
                Box(Modifier.weight(NumericWeight).fillMaxHeight()) {
                    NumericPad(calc)
                    if (historyVisible) {
                        HistoryPanel(
                            entries = calc.history,
                            onSelect = { calc.restore(it); historyVisible = false },
                            onClear = { calc.clearHistory() }
                        )
                    }
                }
                OperatorColumn(calc, Modifier.weight(OperatorWeight).fillMaxHeight())
            }
        }

        if (settingsVisible) {
            AlertDialog(
                onDismissRequest = { settingsVisible = false },
                title = { Text("Calculator settings") },
                text = {
                    Text("Standard calculator with basic arithmetic, percentage, sign toggle and saved calculation history.")
                },
                confirmButton = { TextButton(onClick = { settingsVisible = false }) { Text("Done", color = palette.function) } },
                containerColor = palette.background,
                titleContentColor = palette.formula,
                textContentColor = palette.historyInput
            )
        }
    }
}

@Composable
private fun Display(calc: CalculatorState, metrics: Metrics) {
    val palette = LocalPalette.current
    Column(Modifier.fillMaxWidth().padding(horizontal = DisplaySideMargin)) {
        Spacer(Modifier.height(metrics.displayTopMargin))

        // Formula: big, centered, shrinks between the max and min size as it grows.
        Box(Modifier.fillMaxWidth().height(metrics.formulaHeight).clipToBounds()) {
            val text = when {
                calc.error -> "Error"
                calc.expression.isBlank() -> "0"
                else -> pretty(calc.expression)
            }
            FitText(
                text = text,
                color = if (calc.error) Color(0xFFE34B4B) else palette.formula,
                maxSize = metrics.formulaMaxText,
                minSize = metrics.formulaMinText
            )
        }

        // Live result preview underneath.
        Box(Modifier.fillMaxWidth().height(ResultHeight), contentAlignment = Alignment.Center) {
            val preview = runCatching {
                val s = calc.expression.trimEnd('+', '-', '*', '/', '.')
                if (!calc.error && !calc.completed && s.isNotBlank()) format(Parser(s).parse()) else ""
            }.getOrDefault("")
            if (preview.isNotBlank() && preview != calc.expression) {
                Text(
                    preview,
                    color = palette.result,
                    fontSize = ResultTextSize.asSp(),
                    maxLines = 1,
                    softWrap = false,
                    overflow = TextOverflow.Clip
                )
            }
        }
    }
}

@Composable
private fun FitText(text: String, color: Color, maxSize: Dp, minSize: Dp) {
    val measurer = rememberTextMeasurer()
    val density = LocalDensity.current
    BoxWithConstraints(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        val available = constraints.maxWidth
        var size = maxSize
        var overflow = false
        while (true) {
            val width = measurer.measure(
                text,
                style = TextStyle(fontSize = with(density) { size.toSp() }, fontWeight = FontWeight.Light),
                softWrap = false,
                maxLines = 1
            ).size.width
            if (width <= available) break
            if (size <= minSize) { overflow = true; break }
            size = (size - 1.dp).coerceAtLeast(minSize)
        }
        Text(
            text,
            color = color,
            fontSize = with(density) { size.toSp() },
            fontWeight = FontWeight.Light,
            maxLines = 1,
            softWrap = false,
            textAlign = TextAlign.Center,
            // Past the minimum size keep the end of the number visible, like an editable field would.
            modifier = if (overflow) Modifier.fillMaxWidth().wrapContentWidth(Alignment.End, unbounded = true) else Modifier
        )
    }
}

private val NumericRows = listOf(
    listOf("AC", "DEL", "±"),
    listOf("7", "8", "9"),
    listOf("4", "5", "6"),
    listOf("1", "2", "3"),
    listOf("%", "0", ".")
)

private val OperatorKeys = listOf("÷", "×", "−", "+", "=")

@Composable
private fun NumericPad(calc: CalculatorState) {
    Column(Modifier.fillMaxSize()) {
        NumericRows.forEach { row ->
            Spacer(Modifier.weight(GapRowWeight))
            Row(Modifier.weight(KeyRowWeight).fillMaxWidth()) {
                row.forEach { key ->
                    CalcKey(
                        label = key,
                        style = if (key in SpecialLabels) KeyStyle.Special else KeyStyle.Number,
                        modifier = Modifier.weight(KeyColumnWeight).fillMaxHeight()
                    ) { calc.press(key) }
                    Spacer(Modifier.weight(GapColumnWeight))
                }
            }
        }
    }
}

@Composable
private fun OperatorColumn(calc: CalculatorState, modifier: Modifier) {
    Column(modifier) {
        OperatorKeys.forEach { key ->
            Spacer(Modifier.weight(GapRowWeight))
            CalcKey(
                label = key,
                style = if (key == "=") KeyStyle.Equal else KeyStyle.Special,
                modifier = Modifier.weight(KeyRowWeight).fillMaxWidth()
            ) { calc.press(key) }
        }
    }
}

@Composable
private fun CalcKey(label: String, style: KeyStyle, modifier: Modifier, onClick: () -> Unit) {
    val palette = LocalPalette.current
    val source = remember { MutableInteractionSource() }
    val pressed by source.collectIsPressedAsState()
    val fill = when (style) {
        KeyStyle.Number -> if (pressed) palette.numberKeyPressed else palette.numberKey
        KeyStyle.Special -> if (pressed) palette.specialKeyPressed else palette.specialKey
        KeyStyle.Equal -> palette.equalFill.copy(alpha = if (pressed) 0.8f else 1f)
    }
    Box(
        modifier
            .background(fill, KeyShape)
            .clickable(interactionSource = source, indication = null, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        when {
            label == "=" -> Column(
                Modifier.alpha(if (pressed) 0.8f else 1f),
                verticalArrangement = Arrangement.spacedBy(4.2.dp)
            ) {
                repeat(2) { Box(Modifier.size(width = 13.85.dp, height = 2.7.dp).background(Color.White)) }
            }
            label == "DEL" -> Icon(
                Icons.AutoMirrored.Outlined.Backspace, "Delete",
                tint = palette.function, modifier = Modifier.size(26.dp)
            )
            else -> {
                val size = when (label) {
                    "AC" -> 22.dp
                    "±" -> 26.dp
                    "%" -> 24.dp
                    "÷", "×", "−", "+" -> 30.dp
                    else -> 27.dp
                }
                Text(
                    label,
                    color = if (style == KeyStyle.Number) palette.digit else palette.function,
                    fontSize = size.asSp(),
                    fontWeight = if (label in OperatorKeys) FontWeight.Light else FontWeight.Normal
                )
            }
        }
    }
}

@Composable
private fun HistoryPanel(entries: List<HistoryEntry>, onSelect: (HistoryEntry) -> Unit, onClear: () -> Unit) {
    val palette = LocalPalette.current
    val panelShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
    Column(
        Modifier
            .fillMaxSize()
            .background(palette.background)
            // swallow taps so the number pad underneath can't be hit
            .tap {}
            .padding(top = 8.dp, end = 5.dp)
    ) {
        Box(
            Modifier
                .weight(1f)
                .fillMaxWidth()
                .clip(panelShape)
                .background(palette.historyPanel)
                .border(1.dp, palette.historyStroke, panelShape)
        ) {
            if (entries.isEmpty()) {
                Text(
                    "No history",
                    color = palette.emptyText,
                    fontSize = 16.dp.asSp(),
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                LazyColumn(Modifier.fillMaxSize().padding(1.dp)) {
                    itemsIndexed(entries) { index, entry ->
                        val day = remember(entry.time) { dayLabel(entry.time) }
                        val showDate = index == 0 || day != dayLabel(entries[index - 1].time)
                        HistoryRow(entry, if (showDate) day else null, onSelect)
                        if (index < entries.lastIndex) {
                            HorizontalDivider(Modifier.padding(horizontal = 19.dp), thickness = 1.dp, color = palette.historyStroke)
                        }
                    }
                }
            }
        }
        if (entries.isNotEmpty()) {
            ClearHistoryButton(onClear)
        }
    }
}

private fun dayLabel(time: Long): String =
    if (time <= 0L) "" else DateFormat.getDateInstance(DateFormat.MEDIUM).format(Date(time))

@Composable
private fun HistoryRow(entry: HistoryEntry, date: String?, onSelect: (HistoryEntry) -> Unit) {
    val palette = LocalPalette.current
    val source = remember { MutableInteractionSource() }
    val pressed by source.collectIsPressedAsState()
    Column(Modifier.fillMaxWidth()) {
        if (!date.isNullOrEmpty()) {
            Text(
                date,
                color = palette.historyDate,
                fontSize = 12.dp.asSp(),
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                modifier = Modifier.align(Alignment.End).padding(start = 19.dp, end = 19.dp, top = 12.dp)
            )
        }
        Column(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(if (pressed) palette.historyPressed else Color.Transparent)
                .clickable(interactionSource = source, indication = null) { onSelect(entry) }
                .padding(horizontal = 19.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                pretty(entry.expression),
                color = palette.historyInput,
                fontSize = 16.dp.asSp(),
                maxLines = 1,
                modifier = Modifier.padding(top = 9.dp)
            )
            Text(
                entry.result,
                color = palette.historyResult,
                fontSize = 18.dp.asSp(),
                maxLines = 1,
                modifier = Modifier.padding(top = 6.dp, bottom = 12.dp)
            )
        }
    }
}

@Composable
private fun ClearHistoryButton(onClick: () -> Unit) {
    val palette = LocalPalette.current
    val source = remember { MutableInteractionSource() }
    val pressed by source.collectIsPressedAsState()
    Box(
        Modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .clip(RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp))
            .background(if (pressed) palette.clearButtonPressed else palette.clearButton)
            .clickable(interactionSource = source, indication = null, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "Clear history",
            color = palette.clearText,
            fontSize = 16.dp.asSp(),
            maxLines = 2,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 5.dp)
        )
    }
}
