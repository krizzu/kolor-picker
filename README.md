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


## Installation

![maven central latest](https://img.shields.io/maven-central/v/com.kborowy/color-picker?label=Latest%20version)

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("com.kborowy:color-picker:<latest-version>")
}
```

## Usage

```kotlin

var selectedColor by remember { mutableStateOf(Color(red = 120, green = 194, blue = 87)) }
KolorPicker(
    initialColor = selectedColor,
    onColorSelected = { selectedColor = it },
    modifier = Modifier.width(250.dp).height(200.dp),
)

```

# License

    Copyright 2025 Krzysztof Borowy
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
