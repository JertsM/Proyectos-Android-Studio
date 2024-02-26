package com.example.viewmodel.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viewmodel.ContactsViewModel
import kotlin.random.Random


@Composable
fun CambioBackgroundScreen(){
    var randomColor = Color.LightGray

    val viewModel= viewModel<ContactsViewModel>(
        factory=object: ViewModelProvider.Factory{
            //override la función create
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                //return super.create(modelClass)
                //lo que necesitamos es que devuelva el viewModel que hemos creado
                return ContactsViewModel(
                    helloWorld = "Hi world!"
                ) as T//para uso del genérico
            }
        }
    )
//    Surface(
//        modifier = Modifier.fillMaxSize(),
////                    color = MaterialTheme.colorScheme.background
//        color=viewModel.backgroundcolor
//    )
    Column(
        modifier = Modifier.fillMaxSize()
                           .background(viewModel.backgroundcolor)
    )
    {
//                    Greeting("Android")
        Button(onClick = {
            viewModel.changeBackgroundColor()
        } )
        {
            Text(text="Contact-Change Background color")
        }

        Button(onClick = {
            viewModel.changeButtonColor()
        } ,
            colors = ButtonDefaults.buttonColors(viewModel.buttoncolor),
        )
        {
            Text(text="Contact-Change Button color")
        }
    }
}