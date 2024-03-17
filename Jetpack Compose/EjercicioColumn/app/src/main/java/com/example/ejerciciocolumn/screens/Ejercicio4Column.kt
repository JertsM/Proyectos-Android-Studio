package com.example.ejerciciocolumn.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun Exercise4Column(modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .width(600.dp)
        .height(600.dp)
        .background(Color.Blue)
        .padding(45.dp, 40.dp)){
        Box (modifier = Modifier
            .width(800.dp)
            .height(90.dp)
            .background(Color.Cyan)){
            Row (modifier = Modifier
                .align(Alignment.TopCenter)){
                Greeting(texto = "hi")
            }
            Row (modifier = Modifier
                .align(Alignment.TopCenter)){
                Greeting(texto = "teis", Modifier.padding(15.dp))
            }

            Row (modifier = Modifier
                .align(Alignment.TopStart)) {
                Greeting(texto = "hi", Modifier.padding(0.dp, 30.dp, 5.dp, 5.dp))
            }
            Row (modifier = Modifier
                .align(Alignment.TopStart)){
                Greeting(texto = "hi", Modifier.padding(0.dp, 45.dp, 5.dp, 5.dp))
            }
            Row (modifier = Modifier
                .align(Alignment.TopStart)){
                Greeting(texto = "hi", Modifier.padding(0.dp, 60.dp, 5.dp, 5.dp))
            }

            Row (modifier = Modifier
                .align(Alignment.TopEnd)){
                Greeting(texto = "teis", Modifier.padding(0.dp, 30.dp, 0.dp, 5.dp))
            }
            Row (modifier = Modifier
                .align(Alignment.TopEnd)){
                Greeting(texto = "teis", Modifier.padding(0.dp, 45.dp, 0.dp, 5.dp))
            }
            Row (modifier = Modifier
                .align(Alignment.TopEnd)){
                Greeting(texto = "teis", Modifier.padding(0.dp, 60.dp, 0.dp, 5.dp))
            }
        }
    }
}