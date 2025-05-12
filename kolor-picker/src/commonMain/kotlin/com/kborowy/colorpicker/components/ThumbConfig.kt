package com.kborowy.colorpicker.components

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
class PickerThumbConfig internal constructor(
    val size: Dp = 8.dp,
    val color: Color = Color.White
) {
    companion object {
        val Default = PickerThumbConfig()
    }
}

@Immutable
class HueSliderThumbConfig internal constructor(
    val height: Dp = 12.dp,
    val color: Color = Color.White,
    val borderSize: Dp = 4.dp,
    val borderRadius: Float = 6f
) {
    companion object {
        val Default = HueSliderThumbConfig()
    }
}