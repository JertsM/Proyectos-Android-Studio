package com.example.calculadoracompose.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Override
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.Menu.route){
        // pantalla principal con la navegación
        composable(route = Screens.Menu.route) {Menu(navController)}
        composable(route = Screens.Calculadora.route){
            Calculadora() //Nombre del fichero .kt al que navegar
        }
        Composable(route = Screens.CalculadoraOps.route){
            CalculadoraOps()
        }
    }
}