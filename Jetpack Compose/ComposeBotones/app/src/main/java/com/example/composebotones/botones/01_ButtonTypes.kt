package com.example.compose_components.examples.Button

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime
import kotlin.random.Random

@Preview(showBackground = true)
@Composable
fun ButtonPrueba1() {

    var cuenta =0
    Button(
        onClick = {
            cuenta++
            Log.i("---", "count - in = $cuenta") // Incrementa a 1, pero la siguiente vez se ha reinicializado a 0
        },
    ) {
        Text(text = "${cuenta}")
    }
    Text(text="botón sin estado")
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun ButtonPrueba2() {

    var cuenta = mutableStateOf(0)
    Button(
        onClick = {
            cuenta.value++
            Log.i("---", "count - in = ${cuenta.value}") // Incrementa a 1, pero la siguiente vez se ha reinicializado a 0
        },
    ) {
        Text(text = "${cuenta.value}")
    }
//    Text(text="botón con estado")
    Text(text = "botón con estado-> ${cuenta.value}")
}

@Preview(showBackground = true)
@Composable
fun ButtonPrueba3() {

    val cuenta: MutableState<Int> = remember { mutableStateOf(0) }//solución al problema anterior para que no resetee cuando recompone

    Button(
        onClick = {
            cuenta.value++
            Log.i("---", "count - in = ${cuenta.value}") // Incrementa a 1, pero la siguiente vez se ha reinicializado a 0
        },
    ) {
        Text(text = "${cuenta.value}")
    }
    Text(text="botón con remember-> ${cuenta.value}")
}

@Preview(showBackground = true)
@Composable
fun ButtonPrueba4() {

    //Uso PATRÓN DELEGATOR -> evitar uso .value

    //Uso Patrón Delegator->para facilitar legibilidad código
    var cuenta by remember { mutableStateOf(0) }
    Button(
        onClick = {
            cuenta++
            Log.i("---", "count - in = ${cuenta}") // Incrementa a 1, pero la siguiente vez se ha reinicializado a 0
        },
    ) {
        Text(text = "${cuenta}")
    }
    Text(text="botón con by-> ${cuenta}")
}

/**
 * Podemos usar la delegación de propiedades de Kotlin
 * (https://kotlinlang.org/docs/delegated-properties.html)
 * para simplificar el uso de remember. Esto nos permitirá no llamar a los getters del valor que el
 * mutableStateOf envuelve, sino delegar la gestión de count en él utilizando el patrón delegation.
 * De este modo tendremos un código más legible.
 *
 * Evita tener que usar value
 *
 * Aún así, si la activity se elimina por un cambio en su ciclo de vida (por ejemplo si cambiamos
 * la orientación de la pantalla), el estado se pierde y se rehace la vista ->contador a 0
 */

@Preview(showBackground = true)
@Composable
fun ButtonPrueba5() {

    var cuenta by rememberSaveable { mutableStateOf(0) }
//Saveable->para que sea operativo a través del Ciclo de Vida

    Button(
        onClick = {
            cuenta++
            Log.i("---", "count - in = ${cuenta}") // Incrementa a 1, pero la siguiente vez se ha reinicializado a 0
        },
    ) {
        Text(text = "${cuenta}")
    }
    Text(text="botón con saveable-> ${cuenta}")
}


@Preview(showBackground = true)
@Composable
fun ButtonPrueba() {

    var cuenta by remember { mutableStateOf(0) }

    Button(
        onClick = {
            cuenta++
            Log.i("---", "count - in = $cuenta") // Incrementa a 1, pero la siguiente vez se ha reinicializado a 0
        },
    ) {
        Text(text = "${cuenta}")
    }
    Text(text="botón")
}

@Preview
@Composable
fun TextButtonExample() {
    var counter by remember { mutableStateOf(0) }

    TextButton(onClick = { counter++ }) {
        Text("CLICS: $counter")
    }
}

@Preview
@Composable
fun OutlinedButtonExample() {
    var date by remember { mutableStateOf(LocalDateTime.now()) }

    Column {

        OutlinedButton(
            onClick = { date = LocalDateTime.now() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("INFORMAR")
        }
        Spacer(Modifier.size(16.dp))
        Text(
            "Fecha actual -> $date",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
fun ContainedButtonExample() {
    val WIDTH1 = 150.dp
    val WIDTH2 = 200.dp
    val WIDTH3 = 300.dp

    var width by remember { mutableStateOf(WIDTH1) }

    Button(
        onClick = {
            width = when (width) {
                WIDTH1 -> WIDTH2
                WIDTH2 -> WIDTH3
                else -> WIDTH1
            }
        },
        modifier = Modifier.width(width)
    ) {
        Text("CAMBIAR")
    }
}

/*
@Preview
@Composable

fun ToggleButtonExample() {
    var checked by remember { mutableStateOf(false) } //1

    IconToggleButton(checked = checked, onCheckedChange = { checked = it }) { //2
        Icon(
            painter = painterResource( //3
                if (checked) R.drawable.ic_bookmark
                else R.drawable.ic_bookmark_border
            ),
            contentDescription = //4
            if (checked) "Añadir a marcadores"
            else "Quitar de marcadores",
            tint = Color(0xFF26C6DA) //5
        )
    }
}

 */

@Preview
@Composable
fun IconButtonExample() {
    var color by remember { mutableStateOf(Color.LightGray) }

    IconButton(
        onClick = {
            val randomColor = Color(Random.nextLong(0xFF000000, 0xFFFFFFFF))
            color = randomColor
        }) {
//        Icon(
//            Icons.Filled.Home,
//            contentDescription = "Cambiar color",
//            tint = color
//        )
        Icon(
            Icons.Default.Home,
            contentDescription = "Cambiar color2",
            tint = color
        )
    }
}

