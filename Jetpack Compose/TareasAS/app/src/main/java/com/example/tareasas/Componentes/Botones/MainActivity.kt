package com.example.tareasas.Componentes.Botones

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.composebotones.ui.theme.ComposeBotonesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBotonesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                      GUI()
                      //Boton("Botón en Función")

                    PruebaBotones()
                }
            }
        }
    }
}

@Composable
fun GUI(){
    Column(
//        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "Hi")

        val context = LocalContext.current
        Button(
            onClick = { // Button ya recibe un parámetro especifico para onClick
                        Toast.makeText(context, "Botón pulsado", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "BotonIncrustado")
        }

//        Boton()

//        BotonEnArchivo()

    }
}

@Preview(showSystemUi = true)
@Composable
fun PruebaBotones(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        BotonConContador1()
        BotonConContador2()
        BotonConContador3()
        BotonConContador4()
        BotonConContador5()
    }
}

@Preview(showSystemUi = true)
@Composable
fun Boton(text: String = "ButtonEnFuncion") {
    val context = LocalContext.current

    Button(onClick = { // Button ya recibe un parámetro especifico para onClick
        Toast.makeText(context, "Botón pulsado", Toast.LENGTH_SHORT).show()

    }) {
        Text(text = text)
    }
}

@Preview(showSystemUi = true)
@Composable
fun BotonConContador1(text: String = "ButtonContador") {
    var contador = 0

    Button(
        onClick = { // Button ya recibe un parámetro especifico para onClick
            contador++
        }
    ) {
        Text(text = "${contador}")
    }
    Text(text = "BotónSinEstado")
}

@SuppressLint("UnrememberedMutableState")
@Preview(showSystemUi = true)
@Composable
fun BotonConContador2(text: String = "ButtonContador") {
    var contador:MutableState<Int> = mutableIntStateOf(0)//por la inferencia de tipos no es necesario usar :MutableState<Int>

    Button(
        onClick = { // Button ya recibe un parámetro especifico para onClick
            contador.value++
        }
    ) {
        Text(text = "${contador.value}")
    }
    Text(text = "BotónConEstado->${contador.value}")
}

@Preview(showSystemUi = true)
@Composable
fun BotonConContador3(text: String = "ButtonContador") {
    var contador = remember {mutableStateOf(0)}

    Button(
        onClick = { // Button ya recibe un parámetro especifico para onClick
            contador.value++
        }
    ) {
        Text(text = "${contador.value}")
    }
    Text(text = "BotónConEstadoYRemember->${contador.value}")
}

@Preview(showSystemUi = true)
@Composable
fun BotonConContador4(text: String = "ButtonContador") {//Evitar uso de value gracias a Patrón Delegator
    var contador by remember {mutableStateOf(0)}

    Button(
        onClick = { // Button ya recibe un parámetro especifico para onClick
            contador++
        }
    ) {
        Text(text = "${contador}")
    }
    Text(text = "BotónConEstadoYRememberConBy->${contador}")
}

@Preview(showSystemUi = true)
@Composable
fun BotonConContador5(text: String = "ButtonContador") {//Evitar cambio Portrait y Landscape y cambio de CicloDeVida que se resetee de nuevo
    var contador by rememberSaveable {mutableStateOf(0)}

    Button(
        onClick = { // Button ya recibe un parámetro especifico para onClick
            contador++
        }
    ) {
        Text(text = "${contador}")
    }
    Text(text = "BotónConEstadoYRememberConBySaveable->${contador}")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBotonesTheme {
        Greeting("Android")
    }
}