package com.kborowy.colorpicker

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

@Composable
fun HueSlider(
    onColorSelected: (Color) -> Unit,
    modifier: Modifier = Modifier,
    initialColor: Color? = null,
    thumbColor: Color = Color.White,
    thumbHeight: Dp = 12.dp,
    thumbBorderWidth: Dp = 4.dp,
) {
    var sliderSize by remember { mutableStateOf(Size.Zero) }
    var thumbPositionY by remember { mutableStateOf(0f) }
    val thumbHeightPx = with(LocalDensity.current) { thumbHeight.toPx() }
    val updateColor by rememberUpdatedState(onColorSelected)

    fun setThumbPosition(newOffset: Offset) {
        val start = thumbHeightPx / 2
        val end = sliderSize.height - start
        val y = newOffset.y.coerceIn(start..end)
        thumbPositionY = y - start
    }

    LaunchedEffect(thumbPositionY) {
        val hueDegreeAtPosition =
            (thumbPositionY / (sliderSize.height - thumbHeightPx) * 360f).coerceIn(0f, 360f)
        val newColor = hueDegreeToColor(hueDegreeAtPosition)
        updateColor(newColor)
    }

    LaunchedEffect(sliderSize, initialColor) {
        if (!sliderSize.isEmpty() && initialColor != null) {
            val deg = initialColor.toHueDegree()
            thumbPositionY = (deg / 360f) * (sliderSize.height - thumbHeightPx)
        }
    }


    Box(modifier = modifier.fillMaxHeight().onSizeChanged { sliderSize = it.toSize() }
        .pointerInput(Unit) {
            detectTapGestures(onTap = ::setThumbPosition)
        }
        .pointerInput(Unit) {
            detectDragGestures { change, _ ->
                setThumbPosition(change.position)
            }
        }
    ) {
        // color track
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = thumbBorderWidth)
                .clip(RoundedCornerShape(4.dp))
        ) {
            drawRect(Brush.verticalGradient(Color.colorList))
        }
        // thumb
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRoundRect(
                color = thumbColor,
                topLeft = Offset(
                    x = (thumbBorderWidth.toPx()) / 2,
                    y = thumbPositionY
                ),
                size = Size(
                    width = sliderSize.width - (thumbBorderWidth.toPx()),
                    height = thumbHeight.toPx()
                ),
                style = Stroke(width = thumbBorderWidth.toPx()),
                cornerRadius = CornerRadius(6f, 6f)
            )
        }
    }
}


