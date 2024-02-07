package com.example.calculadoracompose

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadoracompose.ui.theme.CalculadoraComposeTheme

class MainActivity() : ComponentActivity() {
    @Preview(showSystemUi = true)
    @Composable
    fun Caluladora() {

        var op1 by remember { mutableStateOf("") }
        var op2 by remember { mutableStateOf("") }
        var suma by remember { mutableStateOf(0.0) }
        var sumColor by remember { mutableStateOf(Color.Black) }

        val onCalcular = {
            //operacionSuma
            suma = op1.toDouble() + op2.toDouble()
            //operacionCambioColor
            sumColor= when{
                suma < 25.0 -> Color.Green
                suma > 25.0 -> Color.Blue
                suma == 25.0 -> Color.Red
                else -> Color.Black
            }
        }

        Column(
            Modifier.fillMaxSize()
                .padding(vertical = 64.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = op1,
                onValueChange = { op1 = it },
                label = { Text("Operando 1") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = op2,
                onValueChange = { op2 = it },
                label = { Text("Operando 2") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Suma= $suma",
                fontSize = 25.sp
                //color
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = onCalcular) {
                Text("Calcular")
            }
        }
    }


}

