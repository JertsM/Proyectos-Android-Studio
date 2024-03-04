package com.example.ejerciciocolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejerciciocolumn.ui.theme.EjercicioColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjercicioColumnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    EjercicioColumn("Texto 1")
                }
            }
        }
    }
}

@Composable
fun EjercicioColumn(name: String, modifier: Modifier = Modifier) {
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjercicioColumnTheme {
        EjercicioColumn("Texto 1")
    }
}