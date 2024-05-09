package com.listacompra

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ShoppingListItem(
    val name: String,
    var isChecked: Boolean = false
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun ShoppingList() {
    var items by remember { mutableStateOf(listOf<ShoppingListItem>()) }
    var allSelected by remember { mutableStateOf(false) }

    LaunchedEffect(items) {
        allSelected = items.all { it.isChecked }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de la Compra") }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            checkTotal(texto = "Seleccionar/Deseleccionar todos los productos:", seleccion = allSelected,
            onCheckedChange = { isChecked ->
                allSelected = isChecked
                items.forEach { it.isChecked = isChecked }
            })
            Spacer(modifier = Modifier.height(16.dp))
            anhadirItem(onAddItem = { item -> items = items + ShoppingListItem(item) })
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(items.size) { index ->
                    ListItem(
                        item = items[index],
                        onRemoveItem = { items = items.toMutableList().apply { removeAt(index) } },
                        onCheckedChange = { isChecked ->
                            items[index].isChecked = isChecked
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun anhadirItem(onAddItem: (String) -> Unit) {
    var text by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Producto Nuevo:") },
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = {
                onAddItem(text)
                text = ""
            },
        ) {
            Text("Añadir")
        }
    }
}

@Composable
fun ListItem(item: ShoppingListItem, onRemoveItem: () -> Unit, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = item.name, modifier = Modifier.weight(1f))
        Checkbox(
            checked = item.isChecked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
        IconButton(onClick = onRemoveItem) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Eliminar"
            )
        }
    }
}

@Composable
fun checkTotal (texto: String, seleccion: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row {
        Checkbox(checked = seleccion, onCheckedChange = onCheckedChange)
        Text(text = texto,
            style = TextStyle(
                fontSize = 16.sp
            )
        )
    }
}