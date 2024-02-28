package com.example.compose_components.examples.Image_Icon

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog

import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.compose_components.R
import com.example.compose_components.examples.Dialog.Example1
import com.example.compose_components.examples.Dialog.Example2
import com.example.compose_components.examples.Dialog.Example3
import com.example.compose_components.examples.Dialog.Example4
import com.example.compose_components.examples.Dialog.Example5
import com.example.compose_components.examples.Dialog.TutorialAlertDialog
import kotlin.random.Random


// https://devexperto.com/imagenes-coil-iconos-jetpack-compose/

/*
* ICONS
* Simple Icon
* ------------
*       Icon(imageVector = Icons.Default.Image,
*            contentDescription = null)
        Text(text = "Default")

        Icon(imageVector = Icons.Filled.Image, contentDescription = null)
        Text(text = "Filled")

        Icon(imageVector = Icons.Outlined.Image, contentDescription = null)
        Text(text = "Outlined")
        *
        Icon(imageVector = Icons.Rounded.Image, contentDescription = null)
        Text(text = "Rounded")
        *
        Icon(imageVector = Icons.TwoTone.Image, contentDescription = null)
        Text(text = "TwoTone")
        *
        Icon(imageVector = Icons.Sharp.Image, contentDescription = null)
        Text(text = "Sharp")
        *
Icon Size
Icon Color
*
Icon(
       imageVector = Icons.Default.Backup,
       contentDescription = null,
       modifier = Modifier.size(100.dp)//SIZE
       .background(Color.Cyan),//background color
       tint = Color.Red//icon COLOR (5)
    )
    *
//(3)Painter Icon/Image...
* ---------------
//This displays the icon from the drawable resource folder. It takes the same parameters instead of the painter.
*
* @Composable
fun Icon(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current (5)
)
* */

@Preview
@Composable
fun ImagenesIconos() {
    val context = LocalContext.current
    var (actionText, setActionText) = remember { mutableStateOf("Ninguna") }
    val (dialogOpen, showDialog) = remember { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), // para que la Column sea scrollable,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {

        Icon(
            Icons.Default.PlayArrow,
            contentDescription = "Texto alternativo para accesibilidad",
            tint = Color.Red//5
        )

        Icon(
            Icons.Default.Flag,
            contentDescription = null,
            modifier = Modifier.size(92.dp),
            tint = Color.Blue//5
        )
        var checked by remember { mutableStateOf(false) } //2

        IconToggleButton(checked = checked,
            onCheckedChange = { checked = it
                if(checked)
                    Toast.makeText(context, "Añadido a Marcadores", Toast.LENGTH_SHORT).show()
                else  Toast.makeText(context, "Eliminado de Marcadores", Toast.LENGTH_SHORT).show()
        }) { //2

            Icon(
            painter = painterResource( //3
                if (checked){
                    R.drawable.ic_bookmark
                }
                else R.drawable.ic_bookmark_border
            ),
            contentDescription = //4
            if (checked) "Añadir a marcadores"
            else "Quitar de marcadores",
//            tint = Color(0xFF26C6DA) //5
            tint = Color(0xFF7D5260)
        )
        }

        var color by remember { mutableStateOf(Color.LightGray) }//2

        IconButton(
            onClick = {
                val randomColor = Color(Random.nextLong(0xFF000000, 0xFFFFFFFF))
                color = randomColor
                Toast.makeText(context, "Añadido a Home", Toast.LENGTH_SHORT).show()
            }) {
            Icon(
                Icons.Default.Home,
                contentDescription = "Cambiar color",
                tint = color
            )
        }

//        Image(
//            painter = painterResource(id = R.drawable.compose_cat),
//            contentDescription = "Descripción para personas con problemas de visión",//4
//            modifier = Modifier
//                .fillMaxSize()
//        )

        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "Descripción para personas con problemas de visión",//4
            modifier = Modifier
                .weight(25f)
                .fillMaxSize()
                .clickable//(onClick =
                    {
                    showDialog(true)
                    Toast.makeText(context, "Click sobre imagen", Toast.LENGTH_SHORT).show()
                }
//                )
        )


        AsyncImage( // (1)
            //model = "http://",//link web
             model ="https://www.meme-arsenal.com/memes/75c1109bebaab9c203247308908e9c8d.jpg",
//            model = "https://miro.medium.com/v2/resize:fit:640/format:webp/1*g2SqLKUsyr36ejSK2Moa3A.jpeg",
            contentDescription = "Texto alternativo"
        )

        if(dialogOpen)
//            SectionImage(section = "Cuadro diálogo", setActionText = setActionText)//otra forma
            ExampleAlertDialog(
                bodyText = "¿Eliminar ítem?",
                confirmButtonText = "ACEPTAR",
                onConfirm = {
                    Toast.makeText(context, "ACEPTAR", Toast.LENGTH_SHORT).show()
                },
                cancelButtonText = "CANCELAR",
                onCancel = {
                    Toast.makeText(context, "CANCELAR", Toast.LENGTH_SHORT).show()
                }
                ,
                onDismiss = {
                    showDialog(false)
                }
            )
    }

}


/*
(1) Referenciando una imagen por su URL en la red con Coil (https://coil-kt.github.io/coil/compose/).
 Requiere añadir:
    - La dependencia de Coil en build.gradle

    /* Coil */
    implementation("io.coil-kt:coil-compose:2.2.2")

    - Permiso de acceso a Internet en el Manifest
 <uses-permission android:name="android.permission.INTERNET"/>

     /* Librería para tener más iconos */
    past:
    implementation "androidx.compose.material:material-icons-extended:1.3.1"
    now:
     implementation ("androidx.compose.material:material-icons-extended:1.6.0")

     (2) Guardado de variables de estado

     (4) Para problemas con problemas visibilidad
 */

@Composable
fun SectionImage(
    section: String,
//    index: Int,
    setActionText: (String) -> Unit
) {
    val context = LocalContext.current

    val (dialogOpen, showDialog) = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .clickable(
                onClick = {
                    showDialog(true)
                })
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        androidx.compose.material3.Text(
            modifier = Modifier.fillMaxWidth(),
            text = section
        )
    }

    if (!dialogOpen) return

    ExampleAlertDialog(
        titleText="ACCIÓN",
        bodyText = "¿Eliminar ítem?",
        confirmButtonText = "ACEPTAR",
        onConfirm = {
            Toast.makeText(context, "ACEPTAR", Toast.LENGTH_SHORT).show()
        },
        cancelButtonText = "CANCELAR",
        onCancel = {
            Toast.makeText(context, "CANCELAR", Toast.LENGTH_SHORT).show()
        }
        ,
        onDismiss = {
            showDialog(false)
        }
    )

}

@Composable
fun ExampleAlertDialog(
    titleText: String? = null,
    bodyText: String,
    confirmButtonText: String,
    onConfirm: () -> Unit,
    cancelButtonText: String,
    onCancel: () -> Unit,
    onDismiss: () -> Unit
) {
    val title: @Composable (() -> Unit)? = if (titleText.isNullOrBlank())
        null
    else {
        { Text(text = titleText) }
    }

    AlertDialog(
        title = title,
        text = {
            Text(
                text = bodyText
            )
        },
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm()
                    onDismiss()
                }) {
                Text(text = confirmButtonText)
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onCancel()
                onDismiss()
            }) {
                Text(text = cancelButtonText)
            }
        }
    )
}