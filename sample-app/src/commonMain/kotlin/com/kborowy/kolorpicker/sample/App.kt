package com.kborowy.kolorpicker.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kborowy.colorpicker.KolorPicker
import com.kborowy.colorpicker.toHex
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(
            Modifier.fillMaxSize().background(Color(32, 34, 48))
                .windowInsetsPadding(WindowInsets.safeContent).padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            var selectedColor by remember {
                mutableStateOf(
                    Color(
                        red = 120,
                        green = 194,
                        blue = 87
                    )
                )
            }
            KolorPicker(
                initialColor = selectedColor,
                onColorSelected = { selectedColor = it },
                modifier = Modifier.width(350.dp).height(300.dp).clip(RoundedCornerShape(16.dp))
                    .padding(10.dp),
            )

            Spacer(modifier = Modifier.height(50.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("picked color: #${selectedColor.toHex()}", color = Color.White)
                Box(modifier = Modifier.size(100.dp).background(selectedColor))
            }
        }
    }
}

