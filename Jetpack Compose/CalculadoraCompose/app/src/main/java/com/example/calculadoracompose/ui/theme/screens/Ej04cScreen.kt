package com.example.calculadoracompose.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


// Usando ViewModel con LiveData

class Ej04cViewModel : ViewModel() {
    private val _name = MutableLiveData("")
    val name = _name

    fun onNameChange(newName: String) {
        _name.value = newName
    }
}

@Preview(showSystemUi =true)
@Composable
fun Ej04cScreen(ej04cViewModel : Ej04cViewModel = viewModel()) {//OPCIÓN1
//    val ej04cViewModel: Ej04cViewModel = viewModel()//OPCIÓN2
    val name : String by ej04cViewModel.name.observeAsState("")  // (1)
    Ej04cContent(name = name, onNameChange = { ej04cViewModel.onNameChange(it) })
}


@Composable
fun Ej04cContent(name: String, onNameChange: (String) -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        OutlinedTextField(value = name,
            onValueChange = onNameChange,
            label = { Text(text = "Nombre") }
        )

        if (name.isNotBlank())
            Text(text = "¡Hola, $name !, qué tal estás?", Modifier.padding(10.dp))
    }
}


/*
(1) https://stackoverflow.com/questions/66560404/jetpack-compose-unresolved-reference-observeasstate
 */