package com.example.viewmodel.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

import com.example.viewmodel.otromain.UsuarioViewModel

//Explicación State
@Composable
fun MainScreenFuncVersionInicial() {//Será el precursor para explicar la necesidad y uso de VM ViewModel->con él no habrá que usar remember
    //1.Usando la línea siguiente- todo se recompone y no se cambia el nombre al hacer click
//    val user = "Usuario1"

    //2.Usando State y remember
    var user by remember { mutableStateOf("Usuario1") }


    //3.Bloque código para cambio usuario. Siguiente ->Paso a su uso en una fun
//    Column {
//        Text(text = user)
//        Button(onClick = { user="Usuario2" }) {
//            Text(text = "Cambio Nombre" )
//        }
//    }

//    DisplayNameSinOnClick(user)//3.1

//3.2 implementación de lo que hará el onClick->el estado sólo se manejará aquí
    DisplayName(user, { user = "OtroUsuario" })//Forma1


//    DisplayName(user){//Forma2
//        user="OtroUsuario"//3.2 implementación de lo que hará el onClick->el estado sólo se manejará aquí
//    }
}


@Composable
// 4.Uso ViewModel
fun MainScreenFuncVersionFinal(
    viewModel1: UsuarioViewModel
){
    DisplayName(viewModel1.estado){//los cambios ahora son gestionados por VM y no UI
        viewModel1.updateUser()//Lanza un evento para modificar el estado
        //ya que la vista sólo puede escuchar el estado->la vista será reactiva al viewModel->existirá flujo de UI a VM
    }
}

@Composable
fun DisplayNameSinOnClick(user:String){
    Column {
        Text(text = user)
//        Button(onClick = { user="Usuario2" }) { //3.1
//            Text(text = "Cambio Nombre" )
//        }
    }
}

@Composable
fun DisplayName(user:String,
                onClick:()->Unit) {//3.2 Uso del onClick como parámetro
    Column {
        Text(text = user)
        Button(onClick = onClick) {//3.2 sustitución de { user="Usuario2" }
            Text(text = "Cambio Nombre" )
        }
    }
}

@Composable
@Preview
fun ScreenUsuarioSinVM(){
    MainScreenFuncVersionInicial()
}

@Composable
@Preview
fun MainScreenFuncVersionFinal(){
    MainScreenFuncVersionFinal(UsuarioViewModel())
}