package com.example.ejerciciocolumn.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private @Composable
fun Greeting(texto:String,modifier: Modifier=Modifier) {
    Text(text = "$texto", modifier=modifier, color = Color.Black)
}

@Preview
@Composable
fun Exercise3Column() {
    Column(modifier = Modifier.width(600.dp).height(600.dp).background(Color.Yellow)
        .padding(40.dp)) {
        Box(
            //estimación de tamaño
            modifier = Modifier
                .width(900.dp)
                .height(900.dp)
                .background(Color.Cyan),//.background(Color.Magenta)
            //estimación de contenido de todos los eltos del Box
            contentAlignment = Alignment.Center
        )
        {
            Greeting("Hola,", modifier = Modifier.align(Alignment.TopStart))
            Greeting(texto = "Jetpack Compose", modifier = Modifier.align(Alignment.CenterStart))
            Greeting(
                texto = "Otro texto hardcodeado",
                modifier = Modifier.align(Alignment.BottomEnd)
            )

        }
    }
}