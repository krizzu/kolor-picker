package com.kborowy.colorpicker

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun KolorPicker(
    onColorSelected: (Color) -> Unit,
    modifier: Modifier = Modifier,
    initialColor: Color = Color.Red
) {
    val initial = remember { initialColor }
    var selectedColor by remember { mutableStateOf(initialColor) }

    Row(modifier = modifier) {
        HSVPicker(
            selectedHue = selectedColor,
            onColorSelected = onColorSelected,
            modifier = Modifier.weight(9f),
        )

        Spacer(modifier = Modifier.width(8.dp))

        HueSlider(
            initialColor = initial,
            onColorSelected = { selectedColor = it },
            modifier = Modifier.weight(1f)
        )
    }
}





