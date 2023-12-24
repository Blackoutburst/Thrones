# Thrones
Lightweight logger api

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
`<date> <thread> <class> <package> <indicator> <message>`