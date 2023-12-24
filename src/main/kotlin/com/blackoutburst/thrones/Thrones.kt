package com.blackoutburst.thrones

object Thrones {

    var configuration: ThronesConfiguration = ThronesConfiguration()

    private fun log(level: ThronesLevel, message: String) {
        if (configuration.level.ordinal > level.ordinal) return
        val builder = StringBuilder()

        if (configuration.showTime) builder.append("${dateTime()} ")
        if (configuration.showThread) builder.append("\u001B[35m${formatString(Thread.currentThread().name, 10)}\u001B[0m ")
        if (configuration.showClass) builder.append("\u001B[38;5;208m${caller().first} ")
        if (configuration.showPackage) builder.append("${caller().second} ")
        if (configuration.showIndicator) builder.append("${level.indicator} ")

        builder.append("$message\u001B[0m")

        println(builder)
    }

    fun t(message: String) = log(ThronesLevel.TRACE, message)

    fun d(message: String) = log(ThronesLevel.DEBUG, message)

    fun i(message: String) = log(ThronesLevel.INFO, message)

    fun w(message: String) = log(ThronesLevel.WARN, message)

    fun e(message: String) = log(ThronesLevel.ERROR, message)
}