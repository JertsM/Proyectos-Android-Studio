package com.example.composeprimeraslayoutslayouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class ColumnExample {
    private @Composable
    fun Greeting(name:String,modifier: Modifier = Modifier) {
        Text(text = "Hi $name!", modifier=modifier)
    }

    @Preview(
        showBackground=true,
        name="MRN ExComposeApp_Column",
        widthDp= 400,
        heightDp = 200
    )
    @Composable
    fun ColumnPreview(){
        Column(
            modifier=Modifier.fillMaxSize(),//lo que ocupa
            //Definición posición vertical
            //En vez de verticalArrangement se podrían aplicar pesos weight en este caso en los Greeting()

           // verticalArrangement = Arrangement.SpaceAround,//cómo se colocan de forma vertical los eltos
                                                         //con SpaceEvenly->en función del espacio que tienen(dejando encima y debajo)
                                                         //SpaceBetween->mismo espacio entre cada uno los huecos(sin espacio encima 1erElto ni debajo últimoElto)
                                                         //SpaceAround->como Evenly pero dejando mismo espacio encima primero y debajo último (siendo la mitad que el q existe entre eltos)
            //Definición posición horizontal
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Greeting(
                name = "MRN",
                modifier =Modifier
                    .background(Color.LightGray)
                    .weight(2f)
            )
            Greeting(
                name = "mrnovoa",
                modifier =Modifier
                    .background(Color.Yellow)
                    .weight(1f)
            )
            Greeting(
                name = "mrnovoa",
                modifier =Modifier
                    .background(Color.Cyan)
                    .weight(1f)
            )
        }
    }
}