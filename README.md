[![Release](https://img.shields.io/github/release/Blackoutburst/Thrones.svg)](https://github.com/Blackoutburst/Thrones/releases)
![Size](https://img.shields.io/github/repo-size/Blackoutburst/Thrones)

# Thrones
Lightweight logger api

## Install
```gradle
repositories {
    maven {
        url = uri("https://plugins.blackoutburst.dev")
    }
}

dependencies {
    implementation("dev.blackoutburst:thrones:1.1.1")
}
```

## Usage
Code
```kotlin
Thrones.t("Trace")
Thrones.d("Debug")
Thrones.i("Info")
Thrones.w("Warn")
Thrones.e("Error")
```
Output
![./readme/log_output.png](./readme/log_output.png)

## Configuration
This is the default configuration
```kotlin
Thrones.configuration = ThronesConfiguration(
    level = ThronesLevel.INFO,
    showTime = true,
    showThread = true,
    showClass = true,
    showPackage = true,
    showIndicator = true,
)
```

### Level
- TRACE
- DEBUG
- INFO
- WARN
- ERROR

### Format
`<time> <thread> <class> <package> <indicator> <message>`
