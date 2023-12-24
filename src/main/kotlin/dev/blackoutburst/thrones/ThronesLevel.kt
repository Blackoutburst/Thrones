package dev.blackoutburst.thrones

enum class ThronesLevel(val indicator: String) {
    TRACE("\u001B[36m\uD83C\uDD83"),
    DEBUG("\u001B[32m\uD83C\uDD73"),
    INFO( "\u001B[37m\uD83C\uDD78"),
    WARN("\u001B[33m\uD83C\uDD86"),
    ERROR("\u001B[31m\uD83C\uDD74")
}