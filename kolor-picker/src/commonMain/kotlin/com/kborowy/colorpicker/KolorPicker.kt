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
import com.kborowy.colorpicker.components.HSVPicker
import com.kborowy.colorpicker.components.HueSlider
import com.kborowy.colorpicker.components.HueSliderThumbConfig
import com.kborowy.colorpicker.components.PickerThumbConfig


@Composable
fun KolorPicker(
    onColorSelected: (Color) -> Unit,
    modifier: Modifier = Modifier,
    initialColor: Color = Color.Red,
    hueSliderConfig: HueSliderThumbConfig = HueSliderThumbConfig.Default,
    pickerThumbConfig: PickerThumbConfig = PickerThumbConfig.Default
) {
    var selectedHue by remember { mutableStateOf(initialColor) }

    Row(modifier = modifier) {
        HSVPicker(
            selectedHue = selectedHue,
            onColorSelected = onColorSelected,
            thumbConfig = pickerThumbConfig,
            modifier = Modifier.weight(9f),
        )

        Spacer(modifier = Modifier.width(8.dp))

        HueSlider(
            initialColor = initialColor,
            onColorSelected = { selectedHue = it },
            thumbConfig = hueSliderConfig,
            modifier = Modifier.weight(1f)
        )
    }
}





