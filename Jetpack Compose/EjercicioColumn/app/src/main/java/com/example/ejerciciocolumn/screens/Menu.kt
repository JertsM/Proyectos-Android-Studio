package com.example.ejerciciocolumn.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.ejerciciocolumn.navigation.Screens

@Composable
fun Menu(navController: NavController){

    //Si por ejemplo fuese un listado de botones que permiten navegar:

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(text = "Ejercicio Práctica nº1 del uso de Column")
        Button(onClick = { navController.navigate(route = Screens.EjercicioColumn.route) }) {
            Text(text = "Práctica nº1")
        }

        Text(text = "Ejercicio Práctico nº2 del uso de Column")
        Button(onClick = { navController.navigate(route = Screens.Ejercicio2Column.route) }) {
            Text(text = "Práctica nº2")
        }

        Text(text = "Ejercicio Práctico nº3 del uso de Column")
        Button(onClick = { navController.navigate(route = Screens.Ejercicio3Column.route) }) {
            Text(text = "Práctica nº3")
        }

        Text(text = "Ejercicio Práctico nº4 del uso de Column")
        Button(onClick = { navController.navigate(route = Screens.Ejercicio4Column.route) }) {
            Text(text = "Práctica nº4")
        }

        Text(text = "Ejercicio Práctico nº5 del uso de Column")
        Button(onClick = { navController.navigate(route = Screens.Ejercicio5Column.route) }) {
            Text(text = "Práctica nº5")
        }

        Text(text = "Ejercicio Práctico de Botones")
        Button(onClick = { navController.navigate(route = Screens.BotonesToast.route)}) {
            Text(text = "Práctica Nº7")
        }
        
        Text(text = "Calculadora SRMD")
        Button(onClick = {navController.navigate(route = Screens.Calculadora.route)}) {
            Text(text = "Calculadora")
        }
    }
}