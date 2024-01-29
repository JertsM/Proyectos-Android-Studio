package com.example.composebotones

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose_components.examples.Button.IconButtonExample
import com.example.compose_components.examples.Button.OutlinedButtonExample
import com.example.compose_components.examples.Button.TextButtonExample
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

                }

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun botonesNuevos(){

    Column (horizontalAlignment = Alignment.CenterHorizontally){
        TextButtonExample()
        OutlinedButtonExample()
        IconButtonExample()
    }
}

//@Preview(showSystemUi = true)
@Composable
fun GUI(){
    Column(
        // verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        /*
        Text(text = "Hi")
        val context = LocalContext.current
        Button(
            onClick = {Toast.makeText(context, "Botón", Toast.LENGTH_SHORT).show()}
        ) {
            Text(text = "Boton")
        }
        
         */
        BotonConContador1()
        BotonConContador3()
        BotonConContador4()
        BotonConContador5()
    }
}

//@Preview(showSystemUi = true)
@Composable
fun Boton(text: String = "BotonEnArchivo"){
    val context = LocalContext.current

    Button(onClick = {Toast.makeText(context, "Botón", Toast.LENGTH_SHORT).show()} ) {
        Text(text = "BotonIncrustado")
    }
}

//@Preview(showSystemUi = true)
@Composable
fun pruebaBotones(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){

    }
}

//@Preview(showSystemUi = true)
@Composable
fun BotonConContador1(text: String = "BotonContador"){
    var contador = 0

    Button(onClick = {contador++} ) {
        Text(text = "${contador}")
    }
    Text(text = "Botón Sin Estado")
}

@SuppressLint("UnrememberedMutableState")
//@Preview(showSystemUi = true)
@Composable
fun BotonConContador2(text: String = "BotonContador"){
    var contador: MutableState<Int> = mutableStateOf(0)

    Button(onClick = {contador.value++} ) {
        Text(text = "${contador.value}")
    }
    Text(text = "Botón Con Estado->${contador.value}")
}


//@Preview(showSystemUi = true)
@Composable
fun BotonConContador3(text: String = "BotonContador"){
    var contador = remember{
        mutableStateOf(0)
    }

    Button(onClick = {contador.value++} ) {
        Text(text = "${contador.value}")
    }
    Text(text = "Botón Con Estado Remember->${contador.value}")
}

//@Preview(showSystemUi = true)
@Composable
fun BotonConContador4(text: String = "BotonContador"){
    var contador by remember { mutableStateOf(0)}

    Button(onClick = {contador++} ) {
        Text(text = "${contador}")
    }
    Text(text = "Botón Con Estado Remember con By->${contador}")
}

//@Preview(showSystemUi = true)
@Composable
fun BotonConContador5(text: String = "BotonContador"){
    var contador by rememberSaveable { mutableStateOf(0)}

    Button(onClick = {contador++} ) {
        Text(text = "${contador}")
    }
    Text(text = "Botón Con Estado Remember con By Saveable->${contador}")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name",
        modifier = modifier
    )
}