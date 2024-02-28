package com.example.composebotones.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebotones.toDoubleOrZero

@Preview(showSystemUi = true)
@Composable
fun Caluladora(){

    var op1 by remember { mutableStateOf("") }
    var op2 by remember { mutableStateOf("") }
    var suma by remember { mutableStateOf(0.0) }

    val onCalular = {
            //operacionSuma
            //operacionCambioColor
    }

    Column(
        Modifier.fillMaxSize()
                .padding(vertical = 64.dp, horizontal = 16.dp),
        horizontalAlignment=Alignment.CenterHorizontally
    ){
        TextField(
            value = op1,
            onValueChange = { op1 = it },
            label = { Text("Operando 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer()

        TextField(
            value = op2,
            onValueChange = { op2 = it },
            label = { Text("Operando 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer()

        Text(
            text="Suma= $suma",
            fontSize = 25.sp
            //color
        )

        Spacer()

        Button(onClick = //onCalcular
                {suma=op1.toDouble()+op2.toDouble()
                 //calculoColor
                }
        ){
            Text("Calcular")
        }
    }

}

