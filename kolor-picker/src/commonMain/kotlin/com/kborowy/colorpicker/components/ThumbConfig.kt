/*
 * Copyright 2025 Krzysztof Borowy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kborowy.colorpicker.components

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
class PickerThumbConfig internal constructor(val size: Dp = 8.dp, val color: Color = Color.White) {
    companion object {
        val Default = PickerThumbConfig()
    }
}

@Immutable
class HueSliderThumbConfig
internal constructor(
    val height: Dp = 12.dp,
    val color: Color = Color.White,
    val borderSize: Dp = 4.dp,
    val borderRadius: Float = 6f
) {
    companion object {
        val Default = HueSliderThumbConfig()
    }
}
