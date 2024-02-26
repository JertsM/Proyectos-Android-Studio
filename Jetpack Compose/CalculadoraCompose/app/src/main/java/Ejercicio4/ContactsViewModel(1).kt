package com.example.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlin.random.Random

//Modelamos la funcionalidad de cambiar el fondo cuando se haga click en el botón
class ContactsViewModel (
    //3.Mejora-Añadir constructores->cambio de la llamada en la Activity
        val helloWorld:String
    //Necesitamos delegar la construcción para que esto sea transparente->Factory
                            ): ViewModel() {//2. para Activity o Fragment
    //1.Uso de State
    var backgroundcolor by mutableStateOf(Color.White)
    var buttoncolor by mutableStateOf(Color.LightGray)

    //cuando hacemos algo como el cambio de configuración del dispositivo->paso de Portrait a Landscape,
    //vuelve a iniciarse el lifecycle y por lo tanto vuelve de nuevo a generarse el viewModel (reset again)
    //SOLUCIÓN: 2.uso-> :ViewModel de (androidx.lifecycle)
        private set

    fun changeBackgroundColor(){
//        backgroundcolor=Color.Red
        backgroundcolor=Color(Random.nextLong(0xFF000000, 0xFFFFFFFF))
    }

    fun changeButtonColor():Color{
        buttoncolor =Color(Random.nextLong(0xFF000000, 0xFFFFFFFF))
        return buttoncolor
    }
}