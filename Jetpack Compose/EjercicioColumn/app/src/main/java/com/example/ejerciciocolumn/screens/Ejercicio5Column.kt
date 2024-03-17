package com.example.ejerciciocolumn.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejerciciocolumn.R

private @Composable
fun Greeting(texto:String,modifier: Modifier = Modifier) {
    Text(text = "$texto", modifier=modifier, color = Color.Black)
}

@Preview
@Composable
fun Ejercicio5Column(){
    Column (modifier = Modifier
        .background(Color.Cyan)
        .fillMaxSize()){
        Box(modifier = Modifier
            .align(Alignment.End)
            .padding(10.dp, 20.dp, 80.dp, 10.dp)){
            Greeting(texto = stringResource(R.string.jc), modifier = Modifier.background(Color.Magenta))
        }
        Box(modifier = Modifier
            .fillMaxSize()){
            Greeting(texto = stringResource(R.string.texto_ejemplo), modifier = Modifier
                .align(alignment = Alignment.CenterStart))
        }
    }
}