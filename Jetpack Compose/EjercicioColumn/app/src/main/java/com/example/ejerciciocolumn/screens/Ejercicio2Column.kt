package com.example.ejerciciocolumn.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Exercise2Column(modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = "Text 1",
            modifier = modifier
                .background(Color.Red)
                .weight(1.7f),
            color = Color.Black
        )
        Text(
            text = "Text 2",
            modifier = modifier
                .background(Color.Yellow)
                .weight(2.8f)
                .width(400.dp),
            color = Color.Black
        )
        Text(
            text = "Text 3",
            modifier = modifier
                .background(Color.Green)
                .weight(2.2f),
            color = Color.Black)
    }
}