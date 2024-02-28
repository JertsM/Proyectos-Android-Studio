package com.example.compose_componentes.examples.TextField

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun TextFieldExample() {
    var name by remember {
        mutableStateOf("Maria")
    }

    TextField(
        value = name,
        onValueChange = { name = it },
        label = { Text("Nombre") }
    )
}

@Preview
@Composable
fun OutlinedTextFieldExample() {
    var name by remember {
        mutableStateOf("Maria")
    }

    OutlinedTextField(
        value = name,
        onValueChange = { name = it },
        label = { Text("Nombre") }
    )
}