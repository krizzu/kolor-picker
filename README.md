# Kolor Picker

![Kotlin Version](https://img.shields.io/badge/Kotlin-2.20.0-blue?logo=kotlin)
![Maven Central](https://img.shields.io/maven-central/v/com.kborowy/color-picker)
![GitHub Release](https://img.shields.io/github/v/release/krizzu/color-picker?include_prereleases)

Compose Multiplatform classic HSV color picker

<div align="center">
<img src="assets/asset_1.png" width="500px" />
</div>

## Supported platforms

| Platform | Support |
|----------|---------|
| Android  | ✅       |
| iOS      | ✅       |
| Desktop  | ✅       |
| Web      | ✅       |

# Download

todo

# Usage

```kotlin

var selectedColor by remember { mutableStateOf(Color(red = 120, green = 194, blue = 87)) }
KolorPicker(
    initialColor = selectedColor,
    onColorSelected = { selectedColor = it },
    modifier = Modifier.width(250.dp).height(200.dp),
)

```