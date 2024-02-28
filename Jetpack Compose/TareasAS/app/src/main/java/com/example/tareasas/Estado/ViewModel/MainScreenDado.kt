package com.example.compose_state.viewmodel

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlin.random.Random

class DadoViewModel : ViewModel() {
    private var _numero by mutableStateOf(0)
    val numero get() = _numero

    fun changeNumber() {
        _numero = Random.nextInt(from = 1, until = 7)
    }
}

@Preview
@Composable
fun MainScreenDado() {
    val viewModel: DadoViewModel = viewModel()
    BotonYText(viewModel.numero, { viewModel.changeNumber() })
}

@Composable
fun BotonYText(numero: Int, changeNumber: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(35.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        val context = LocalContext.current

        val onClickEvent = {
            changeNumber
        }

        Button(onClick = changeNumber
              , colors= ButtonDefaults.buttonColors(
                backgroundColor = Color.LightGray,
                contentColor = Color.Blue
              )
        ) {
            Text(text = "Tirar dado")
        }
        Text(text = numero.toString(), fontSize = 50.sp,color=Color.Blue)

       Button(onClick =//onClickEvent()
       {
            changeNumber()
            Toast.makeText(context, "Click simple", Toast.LENGTH_SHORT).show()
       }
           , colors= ButtonDefaults.buttonColors(
               backgroundColor = Color.Blue,
               contentColor = Color.White
           )
           ) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
//                                    .background(Color.Gray)
                                    ,
                tint=Color.White
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Dado")
        }
    }
}
