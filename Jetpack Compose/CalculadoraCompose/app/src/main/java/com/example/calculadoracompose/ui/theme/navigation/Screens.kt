package com.example.calculadoracompose.ui.theme.navigation

sealed class Screens(val route: String) {
    object Menu: Screens("initial_screen") //info a aparecer en pantalla

    object Calculadora: Screens("ejCalculadora") //info a aparecer en pantalla
    object CalculadoraOps: Screens("ejCalculadoraOperaciones") //info a aparecer en pantalla

}

// Aquellos ficheros que correspondan a un menú, deberán tener la estructura.