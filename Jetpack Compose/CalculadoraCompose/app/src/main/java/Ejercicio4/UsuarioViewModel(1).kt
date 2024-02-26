package com.example.viewmodel.otromain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UsuarioViewModel(): ViewModel() {
    var estado by mutableStateOf("UnUser1")
        private set//para asegurar que sólo se cambie aquí el estado

    fun updateUser() {
        estado = "OtroUser2"
    }


}