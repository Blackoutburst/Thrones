package dev.blackoutburst.thrones

/**
 * Enum representing different severity levels for logging in the `Thrones` utility.
 * Each level is associated with a unique indicator for visual distinction in log outputs.
 *
 * @property indicator A string combining an ANSI color code and a Unicode character
 *                     to visually represent the log level.
 */
enum class ThronesLevel(val indicator: String) {
    /**
     * TRACE level with a cyan color indicator.
     */
    TRACE("\u001B[36m\uD83C\uDD83"),

    /**
     * DEBUG level with a green color indicator.
     */
    DEBUG("\u001B[32m\uD83C\uDD73"),

    /**
     * INFO level with a white color indicator.
     */
    INFO( "\u001B[37m\uD83C\uDD78"),

    /**
     * WARN level with a yellow color indicator.
     */
    WARN("\u001B[33m\uD83C\uDD86"),

    /**
     * ERROR level with a red color indicator.
     */
    ERROR("\u001B[31m\uD83C\uDD74")
}