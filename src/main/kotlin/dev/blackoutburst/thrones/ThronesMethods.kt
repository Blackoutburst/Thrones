package dev.blackoutburst.thrones

import java.text.SimpleDateFormat
import java.util.*

/**
 * Internal utility functions used by the `Thrones` logging object.
 */

/**
 * Generates the current date and time in a specific format.
 *
 * @return A string representing the current date and time in the format "yyyy-MM-dd HH:mm:ss.SSS".
 */
internal fun dateTime(): String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Date())

/**
 * Determines the class and package name of the caller method.
 *
 * @return A Pair where the first element is the formatted class name of the caller and the second element
 *         is the formatted package name. Both class and package names are truncated to a specific length
 *         and formatted for logging output. Returns "unknown" for both if the caller cannot be determined.
 */
internal fun caller(): Pair<String, String> {
    val stackTrace = Thread.currentThread().stackTrace
    val caller = stackTrace.getOrNull(2) ?: return Pair("unknown", "unknown")

    val fullClassName = caller.className
    val className = fullClassName.substringAfterLast('.')
    val packageName = fullClassName.substringBeforeLast('.', "")

    return Pair("\u001B[38;5;208m${formatString(className, 10)}\u001B[0m", formatString(packageName, 30))
}

/**
 * Formats a given string to a specified length.
 * If the string is longer than the specified length, it is truncated.
 * If it is shorter, it is padded with spaces at the end.
 *
 * @param str The string to be formatted.
 * @param length The desired length of the formatted string.
 * @return The formatted string.
 */
internal fun formatString(str: String, length: Int): String {
    val tmp = String(str.toByteArray())
    val croppedString = if (tmp.length > length) tmp.substring(0, length) else tmp
    return croppedString.padEnd(length)
}
