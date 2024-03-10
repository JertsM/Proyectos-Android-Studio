package com.example.ejerciciocolumn.navigation

sealed class Screens (val route: String) {
    object Menu: Screens("menu_principal")

    object EjercicioColumn: Screens("Ejercicio_Column")
    object Ejercicio2Column: Screens("Ejercicio2_Column")
    object Ejercicio3Column: Screens("Ejercicio3_Column")
    object Ejercicio4Column: Screens("Ejercicio4_Column")
}