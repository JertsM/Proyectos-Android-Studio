package com.example.composeprimeraslayoutslayouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class BoxExample {
    private @Composable
    fun Greeting(name:String,modifier: Modifier=Modifier) {
        Text(text = "Hello $name!", modifier=modifier)
    }

    @Preview(
        showBackground=true,
        name="MRN ExComposeApp_Box",
        widthDp= 400,
        heightDp = 200
    )
    @Composable
    fun BoxPreview(){
        Box(
            //estimación de tamaño
            modifier = Modifier.fillMaxSize(),//.background(Color.Magenta)
            //estimación de contenido de todos los eltos del Box
            contentAlignment = Alignment.Center
        )
        {
            Greeting("MRN",)
            Greeting(name="mrnovoa",modifier=Modifier.align(Alignment.BottomEnd))
        }
    }
}