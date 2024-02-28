package com.example.compose_state.examples

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun TextFieldWithoutState() {
    TextField(
        value = "",
        onValueChange = { },
        label = { Text("Número 1") }
    )
}

@Preview
@Composable
fun TextFieldWithState() {
    var firstNumber by remember { mutableStateOf("") }
    TextField(
        value = firstNumber,
        onValueChange = { firstNumber = it },
        label = { Text("Número 1") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}