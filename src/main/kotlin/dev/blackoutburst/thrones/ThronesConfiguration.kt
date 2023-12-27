package dev.blackoutburst.thrones

/**
 * A data class representing the configuration for the `Thrones` logging utility.
 * It allows customization of various aspects of log messages such as the severity level,
 * inclusion of time, thread name, class name, package name, and indicators in the log output.
 *
 * @property level The minimum logging level for which messages will be logged. Default is [ThronesLevel.INFO].
 * @property showTime Flag to include the current time in the log messages. Default is true.
 * @property showThread Flag to include the name of the current thread in the log messages. Default is true.
 * @property showClass Flag to include the name of the class that generated the log message. Default is true.
 * @property showPackage Flag to include the package name of the class in the log messages. Default is true.
 * @property showIndicator Flag to include a severity level indicator in the log messages. Default is true.
 */
data class ThronesConfiguration(
    var level: ThronesLevel = ThronesLevel.INFO,
    var showTime: Boolean = true,
    var showThread: Boolean = true,
    var showClass: Boolean = true,
    var showPackage: Boolean = true,
    var showIndicator: Boolean = true,
)