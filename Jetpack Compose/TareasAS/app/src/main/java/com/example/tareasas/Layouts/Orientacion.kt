package com.example.compose_layouts

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true)
@Composable
fun ContenidoOrientado() {
    when (LocalConfiguration.current.orientation) {
        Configuration.ORIENTATION_PORTRAIT -> {
            Column() {
                Text("Portrait", Modifier.weight(1f))
                CajaEltos(Modifier.weight(3f).fillMaxWidth())
            }
        }
        Configuration.ORIENTATION_LANDSCAPE -> {
            Row() {
                Text("Landscape", Modifier.weight(1f))
                CajaEltos(Modifier.weight(3f).fillMaxSize()) // Aplica "Size" por estar después del peso
            }
        }
        else -> throw RuntimeException()
    }
}


@Preview(widthDp = 150, heightDp = 150)
@Composable
private fun CajaEltos(
    modifier: Modifier = Modifier,
) {
    Box(modifier.background(Color.LightGray)) {
        Text(text = "Texto en TopStart", Modifier.align(Alignment.TopStart).background(Color.Cyan))
        Text(text = "Texto en BottomEnd", Modifier.align(Alignment.BottomEnd).background(Color.Green))

    }
}