package com.example.ejerciciocolumn.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ejerciciocolumn.screens.Exercise3Column
import com.example.ejerciciocolumn.screens.EjercicioColumn
import com.example.ejerciciocolumn.screens.Exercise2Column
import com.example.ejerciciocolumn.screens.Exercise4Column
import com.example.ejerciciocolumn.screens.Menu

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.Menu.route) {
        composable(route = Screens.Menu.route) {Menu(navController)}
        composable(route = Screens.EjercicioColumn.route){EjercicioColumn()}
        composable(route = Screens.Ejercicio2Column.route){Exercise2Column()}
        composable(route = Screens.Ejercicio3Column.route){Exercise3Column()}
        composable(route = Screens.Ejercicio4Column.route){ Exercise4Column() }
    }
}