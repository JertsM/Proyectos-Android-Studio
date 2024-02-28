package com.example.compose_components.examples.Scaffold

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlin.random.Random

// Función Composable que crea un Scaffold personalizado
@Preview
@Composable
fun CustomScaffold() {
    var scaffoldBackgroundColor by remember { mutableStateOf(Color.White) }

    Scaffold(
        // Barra superior
        topBar = { CustomTopBar() },

        // Barra inferior
        bottomBar = { CustomBottomBar() },

        // Botón flotante personalizado
        floatingActionButton = {
            CustomFAB(
                onButtonClick = { scaffoldBackgroundColor = Color(Random.nextLong(0xFFFFFFFF))}
            )
        },

        // Contenido principal
        content = { padding ->
            CustomContent(padding)
        },

        backgroundColor = scaffoldBackgroundColor
    )
}

@Composable
fun CustomTopBar() {
    TopAppBar(
        // Título de la barra superior
        title = { Text(text = "Ej. Scaffold-Top") },
    )
}

@Composable
fun CustomBottomBar() {
    BottomAppBar(content = {
        // Contenido de la barra inferior
        Text(text = "Ej. Scaffold-Bottom->Item One")
    })
}

@Composable
fun CustomFAB(
    onButtonClick:()->Unit
) {
    val context = LocalContext.current
    FloatingActionButton(
        // Color de fondo
        backgroundColor = MaterialTheme.colors.primary,
        // Acción al hacer clic en el botón (sin definir)
        onClick = { /*TODO*/
                    onButtonClick()
                    Toast.makeText(context, "Click simple en boton Scaffold", Toast.LENGTH_SHORT).show()
                }
    ) {
        Text(
            fontSize = 24.sp, // Tamaño de fuente del texto del botón
            text = "+" // Texto del botón
        )
    }
}


@Composable
fun CustomContent(padding: PaddingValues) {
    val context = LocalContext.current
    Column(
        // Modificadores de estilo de la columna
        modifier = Modifier
            // Ocupar todo el espacio disponible
            .fillMaxSize()
            .padding(padding),

        // Contenido de la aplicación
        content = {
            Text(text = "My app content")
            Button(
                onClick ={
                    Toast.makeText(context, "Click simple en boton Cuerpo Scaffold", Toast.LENGTH_SHORT).show()
//                    Ej06Screen()
                }
            ){
                Text(text = "Navegar")
            }
        }
    )
}


