package com.example.ejerciciocolumn.screens

import android.media.VolumeShaper
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Checkbox
import androidx.compose.material.RadioButton
import androidx.compose.material3.Button
import androidx.compose.material.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showSystemUi = true)
@Composable
fun Calculadora(){
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)){
        val (selectedOperacion, setSelectedOperaciones) = remember { mutableStateOf(Operaciones.SUMA) }
        RadioOperaciones(selectedOperacion, setSelectedOperaciones, Modifier.fillMaxSize())
        EstructuraCalculadora(selectedOperacion, Modifier.align(Alignment.Center))
    }
}
enum class Operaciones { SUMA, RESTA, MULTIPLICACION, DIVISION}

@Composable
fun RadioOperaciones(selectedOperacion: Operaciones,
                          setSelectedOperaciones: (Operaciones) -> Unit,
                          modifier: Modifier){

    Column(modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selectedOperacion == Operaciones.SUMA,
                onClick = { setSelectedOperaciones(Operaciones.SUMA) }
            )
            Text(text = "Suma")

            RadioButton(
                selected = selectedOperacion == Operaciones.RESTA,
                onClick = { setSelectedOperaciones(Operaciones.RESTA) }
            )
            Text(text = "Resta")
        }

        Row (verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selectedOperacion == Operaciones.MULTIPLICACION,
                onClick = { setSelectedOperaciones(Operaciones.MULTIPLICACION) }
            )
            Text(text = "Multiplicación")

            RadioButton(
                selected = selectedOperacion == Operaciones.DIVISION,
                onClick = { setSelectedOperaciones(Operaciones.DIVISION) }
            )
            Text(text = "División")
        }
    }
}

@Composable
fun EstructuraCalculadora(selectedOperacion: Operaciones,
                          modifier: Modifier) {

    var op1 by rememberSaveable { mutableStateOf("") }
    var op2 by rememberSaveable { mutableStateOf("") }
    var resultado by rememberSaveable { mutableDoubleStateOf(0.0) }
    var sumColor: Color by remember { mutableStateOf(Color.Black) }

    Column (
        Modifier
            .fillMaxSize()
            .padding(vertical = 150.dp, horizontal = 16.dp),
        horizontalAlignment=Alignment.CenterHorizontally) {
        TextField(
            value = op1,
            onValueChange = { op1 = it },
            label = { Text("Operando 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = modifier)

        TextField(
            value = op2,
            onValueChange = { op2 = it },
            label = { Text("Operando 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = modifier)

        Text(text = "Resultado = $resultado",
            fontSize = 25.sp)

        Spacer(modifier = modifier)

        Button(onClick = {resultado = when (selectedOperacion){
            Operaciones.SUMA -> {op1.toDouble() + op2.toDouble()}
            Operaciones.RESTA -> {op1.toDouble() - op2.toDouble()}
            Operaciones.MULTIPLICACION -> {op1.toDouble() * op2.toDouble()}
            Operaciones.DIVISION -> {op1.toDouble() / op2.toDouble() }
        }
        }) {
            Text(text = "Calcular")
        }

        sumColor = when {
            resultado < 25.0 -> Color.Cyan
            resultado > 25.0 -> Color.Blue
            resultado == 25.0 -> Color.Red
            else -> Color.Black
        }
    }

}