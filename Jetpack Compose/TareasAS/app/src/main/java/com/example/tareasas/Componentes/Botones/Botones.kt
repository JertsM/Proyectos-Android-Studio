package com.example.composebotones

import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true)
@Composable
fun BotonEnArchivo(text: String = "ButtonEnArchivoKotlin") {
    val context = LocalContext.current

    Button(onClick = { // Button ya recibe un parámetro especifico para onClick
        Toast.makeText(context, "Botón pulsado", Toast.LENGTH_SHORT).show()

    }) {
        Text(text = text)
    }
}