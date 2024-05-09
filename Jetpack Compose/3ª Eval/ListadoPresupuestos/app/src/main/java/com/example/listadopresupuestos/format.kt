package com.example.listadopresupuestos

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Checkbox
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listadopresupuestos.clases.Producto

val product1 : Producto = Producto ("ASUS ROG STRIX B760-F GAMING WIFI 100€", 100.00, R.drawable.placa1)
val product2 : Producto = Producto ("Intel Core i7-14700KF 3.4/5.6GHz Box 150€", 150.00, R.drawable.microprocesador)
val product3 : Producto = Producto ("Gigabyte GeForce RTX 4060 EAGLE OC 8GB GDDR6 DLSS3 200€", 200.00, R.drawable.grafica)

val items = listOf(product1, product2, product3)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "DiscouragedApi", "InternalInsetResource", "RememberReturnType")
@Preview(showSystemUi = true)
@Composable
fun Format(){

    var presu by remember { mutableDoubleStateOf(0.0) }
    var allSelected by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Productos Tecno.",
                    style = TextStyle(
                        fontFamily = FontFamily.Cursive,
                        fontSize = 30.sp,
                        color = Color.White
                    )
                ) }
            )
            Row (modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.End),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Compra total: $presu",
                    style = TextStyle(
                        fontSize = 15.sp,
                        color = Color.White
                    ))
            }
        }
    ) {
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {

                Column {
                    checkTotal(seleccion = allSelected, texto = "Seleccionar/Deseleccionar todos los productos:") {
                        allSelected = it
                        presu = if (allSelected) {
                            items.sumOf { it.precio }
                        } else {
                            0.0
                        }
                    }
                    Text(text = "Precio total de la compra: $presu",
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.Black
                        ))
                }
            }
            LazyColumn (modifier = Modifier.fillMaxSize()) {
                items(items.size) { i ->
                    val product = items[i]
                    ListItemWithImage(product.nombre, product.precio, sumarPrecio = { it -> presu += it}, product.imagen)

                }
            }
        }
    }
}

@Composable
fun ListItemWithImage (text: String, precioProd: Double, sumarPrecio: (Double) -> Unit, imageResId: Int) {

    var isChecked by remember { mutableStateOf (false) }
    var precio = 0.0

    Row (modifier = Modifier
        .border(1.dp, Color.Magenta)
        .padding(16.dp)
        .fillMaxWidth()
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { newCheckedState ->
                isChecked = newCheckedState
                if (isChecked) {
                    precio += precioProd
                } else {
                    precio -= precioProd
                }

                sumarPrecio (precio)
            },
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Image (painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier.size(52.dp))
        Spacer (modifier = Modifier.width(16.dp))
        Text(text = text,
            style = TextStyle(color = Color.Black))
    }
}

@Composable
fun checkTotal (texto: String, seleccion: Boolean, onSelectedChange: (Boolean) -> Unit) {
    Row {
        Checkbox(checked = seleccion, onCheckedChange = onSelectedChange)
        Text(text = texto,
            style = TextStyle(
                fontSize = 16.sp
            ))
    }
}