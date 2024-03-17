package com.example.ejerciciocolumn.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ToastButtons(modifier: Modifier = Modifier){
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly){

        Button(onClick = { Toast.makeText(context, "Button Con Button", Toast.LENGTH_SHORT).show() }){
            Text(text = "Button con Button")
        }
        Button(onClick = { Toast.makeText(context, "Button En Text", Toast.LENGTH_SHORT).show() }){
            Text(text = "Button en Text")
        }
        Box(){
            Button(onClick = { Toast.makeText(context, "Button En Box", Toast.LENGTH_SHORT).show() },
                modifier = Modifier
                    .background(Color.Green)
                    .padding(2.dp)
                    .border(
                        width = 6.dp,
                        color = Color.Green,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .clipToBounds()){
                Text(text = "Button en Box")

            }
        }
    }

}