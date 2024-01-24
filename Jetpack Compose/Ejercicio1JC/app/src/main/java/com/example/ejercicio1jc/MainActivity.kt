package com.example.ejercicio1jc

import android.content.res.Resources.Theme
import android.graphics.LightingColorFilter
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejercicio1jc.ui.theme.Ejercicio1JCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejercicio1JCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                        .background(Color.Gray)
                ) {
                    Greeting("Texto")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    ColumnPreview()
}

@Composable
fun ColumnPreview(){
        Column(
            modifier = Modifier.fillMaxSize().padding(30.dp).background(Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            Text (text = "Texto 1",
                style = TextStyle(
                    color = Color.Black,
                    textAlign = TextAlign.Center),
                modifier = Modifier
                    .background(Color.Red)
                    .padding(1.dp)

            )
            Text (text = "Texto 2",
                style = TextStyle(
                    textAlign = TextAlign.Center),
                modifier = Modifier
                    .background(Color.Green)
                    .padding(1.dp)
            )
            Text (text = "Texto 3",
                style = TextStyle(
                    textAlign = TextAlign.Center),
                modifier = Modifier
                    .background(Color.Blue)
                    .padding(1.dp)
            )
        }

}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    ColumnPreview()
}