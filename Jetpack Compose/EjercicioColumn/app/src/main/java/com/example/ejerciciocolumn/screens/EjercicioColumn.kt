package com.example.ejerciciocolumn.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun EjercicioColumn(modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly) {
        Text(
            text = "Text 1",
            modifier = modifier.background(Color.Red))
        Text(
            text = "Text 2",
            modifier = modifier.background(Color.Blue))
        Text(
            text = "Text 3",
            modifier = modifier.background(Color.Green))
    }
}