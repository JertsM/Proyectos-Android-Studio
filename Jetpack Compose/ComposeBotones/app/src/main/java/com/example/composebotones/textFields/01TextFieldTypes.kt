package com.example.composebotones.textFields

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
        label = { Text("Name") }
    )
}

@Preview
@Composable
fun outlinedTextFieldExample() {
    var name by remember {
        mutableStateOf("Maria")
    }

    OutlinedTextField(
        value = name,
        onValueChange = { name = it },
        label = { Text("Name") }
    )
}