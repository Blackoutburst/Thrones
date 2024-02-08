# Thrones

<img align="right" src="./dokka/logo-icon.png" width=15%>

[![Release](https://img.shields.io/github/release/Blackoutburst/Thrones.svg?style=for-the-badge)](https://github.com/Blackoutburst/Thrones/releases)
![Size](https://img.shields.io/github/repo-size/Blackoutburst/Thrones?style=for-the-badge)
[<img src="https://img.shields.io/badge/V1.1.2-blueviolet?style=for-the-badge&logo=kotlin&logoColor=white&label=KDoc">](https://plugins.blackoutburst.dev/dev/blackoutburst/thrones/1.1.2/index.html)

Lightweight logger api

## Install
```gradle
repositories {
    maven {
        url = uri("https://plugins.blackoutburst.dev")
    }
}

dependencies {
    implementation("dev.blackoutburst:thrones:1.1.2")
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
