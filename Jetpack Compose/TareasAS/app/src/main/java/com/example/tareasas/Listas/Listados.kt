package com.example.composebotones.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true)
@Composable
fun EjLazyListSimple(){
// A simple lazy column with 10 items
    LazyColumn {
// Add 10 items
        items(10) { index ->
// Content of each item
            Text(
                text = "Item $index",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h5,
                color = Color.Blue
            )
        }
    }
}


@Composable
fun ListWithColumn(items: List<String>) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.verticalScroll(scrollState)) {
        items.forEach { item ->
            ListItemRow(item)
        }
    }
}

@Composable
fun ListWithLazyColumn(items: List<String>) {
    LazyColumn {
        items(items) { item ->
            ListItemRow(item)
        }
    }
}

@Composable
fun ListItemRow(item: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(text = item, style = MaterialTheme.typography.subtitle1)
    }
}
@Preview(showSystemUi = true)
@Composable
fun Listas(){
    val items = List(10) { "Item ${it + 1}" }
// val items = List(20) { "Item ${it + 1}" }

    Column {
        Row{
            Text(text="Column",
                style = MaterialTheme.typography.h3,
                color = Color.Blue)
            ListWithColumn(items = items)
        }
        Row{
            Text(text="LazyColumn")
            ListWithLazyColumn(items = items)
        }
    }
}
