package dev.blackoutburst.thrones

/**
 * A logging utility object `Thrones` for formatting and logging messages at different levels.
 * This object provides functions to log messages with various importance levels like TRACE, DEBUG, INFO, WARN, and ERROR.
 * It uses a `ThronesConfiguration` instance to manage logging configurations.
 */
object Thrones {

    /**
     * The configuration settings for `Thrones` logging.
     */
    var configuration: ThronesConfiguration = ThronesConfiguration()

    /**
     * Formats a log message based on the current configuration and the specified level.
     *
     * @param level The severity level of the log message (e.g., TRACE, DEBUG).
     * @param message The message to be logged.
     * @return A formatted string based on the configuration settings and log level.
     */
    fun format(level: ThronesLevel, message: String) {
        val builder = StringBuilder()

        if (configuration.showTime) builder.append("${dateTime()} ")
        if (configuration.showThread) builder.append("\u001B[35m${formatString(Thread.currentThread().name, 10)}\u001B[0m ")
        if (configuration.showClass) builder.append("\u001B[38;5;208m${caller().first} ")
        if (configuration.showPackage) builder.append("${caller().second} ")
        if (configuration.showIndicator) builder.append("${level.indicator} ")

        builder.append("$message\u001B[0m")
    }

    /**
     * Logs a message at a specified severity level.
     * The message is printed to the standard output if its level is equal or higher than the configured level.
     *
     * @param level The severity level of the log message.
     * @param message The message to be logged.
     */
    fun log(level: ThronesLevel, message: String) {
        if (configuration.level.ordinal > level.ordinal) return
        println(format(level, message))
    }

    /**
     * Logs a message at TRACE level.
     *
     * @param message The message to be logged at TRACE level.
     */
    fun t(message: String) = log(ThronesLevel.TRACE, message)

    /**
     * Logs a message at DEBUG level.
     *
     * @param message The message to be logged at DEBUG level.
     */
    fun d(message: String) = log(ThronesLevel.DEBUG, message)

    /**
     * Logs a message at INFO level.
     *
     * @param message The message to be logged at INFO level.
     */
    fun i(message: String) = log(ThronesLevel.INFO, message)

    /**
     * Logs a message at WARN level.
     *
     * @param message The message to be logged at WARN level.
     */
    fun w(message: String) = log(ThronesLevel.WARN, message)

    /**
     * Logs a message at ERROR level.
     *
     * @param message The message to be logged at ERROR level.
     */
    fun e(message: String) = log(ThronesLevel.ERROR, message)
}