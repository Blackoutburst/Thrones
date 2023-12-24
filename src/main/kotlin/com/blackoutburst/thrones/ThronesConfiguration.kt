package com.blackoutburst.thrones

data class ThronesConfiguration(
    var level: ThronesLevel = ThronesLevel.INFO,
    var showTime: Boolean = true,
    var showThread: Boolean = true,
    var showClass: Boolean = true,
    var showPackage: Boolean = true,
    var showIndicator: Boolean = true,
)