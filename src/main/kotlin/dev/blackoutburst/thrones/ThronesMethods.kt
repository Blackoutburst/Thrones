package dev.blackoutburst.thrones

import java.text.SimpleDateFormat
import java.util.*

internal fun dateTime(): String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Date())

internal fun caller(): Pair<String, String> {
    val stackTrace = Thread.currentThread().stackTrace
    val caller = stackTrace.getOrNull(2) ?: return Pair("unknown", "unknown")

    val fullClassName = caller.className
    val className = fullClassName.substringAfterLast('.')
    val packageName = fullClassName.substringBeforeLast('.', "")

    return Pair("\u001B[38;5;208m${formatString(className, 10)}\u001B[0m", formatString(packageName, 30))
}

internal fun formatString(str: String, length: Int): String {
    val tmp = String(str.toByteArray())
    val croppedString = if (tmp.length > length) tmp.substring(0, length) else tmp
    return croppedString.padEnd(length)
}
