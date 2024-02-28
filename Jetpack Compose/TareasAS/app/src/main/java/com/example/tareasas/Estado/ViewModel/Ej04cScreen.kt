package com.example.compose_state.viewmodel

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose_state.ui.theme._2aEVAComposeTheme
import com.example.compose_state.R


// Usando ViewModel con LiveData

class Ej04cViewModel : ViewModel() {
    private val _name = MutableLiveData("")
    val name = _name

    fun onNameChange(newName: String) {
        _name.value = newName
    }
}

//class Ej04cViewModelSinVM : ViewModel() {
//    private val _name = mutableStateOf("")
//    val name = _name
//
//    fun onNameChange(newName: String) {
//        _name.value = newName
//    }
//}

@Preview(showSystemUi = true)
@Composable
fun Ej04cScreenConScaffold() {
    Scaffold(
        topBar = {
//            TopAppBar(
//                title = { Text(text = stringResource(R.string.livedata)) })

            DetailTopAppBar()
        }
    ) {
        _2aEVAComposeTheme() {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(it)) {
//                when (LocalConfiguration.current.orientation) {
//                    Configuration.ORIENTATION_PORTRAIT -> ComposicionVertical()
//                    Configuration.ORIENTATION_LANDSCAPE -> ComposicionHorizontal()
//                    else -> throw RuntimeException()
//                }
                Ej04cScreen()
            }
        }
    }
}

//@Preview(showSystemUi =true)
@Composable
fun Ej04cScreen(ej04cViewModel : Ej04cViewModel = viewModel()) {//OPCIÓN1
//    val ej04cViewModel: Ej04cViewModel = viewModel()//OPCIÓN2
    val name : String by ej04cViewModel.name.observeAsState("")  // (1)

//    Ej04cContent(name = ej04cViewModel.name.value, onNameChange = { ej04cViewModel.onNameChange(it) })//Sin LiveData

    Ej04cContent(name = name, onNameChange = { ej04cViewModel.onNameChange(it) })//con LiveData
}


@Composable
fun Ej04cContent(name: String, onNameChange: (String) -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        OutlinedTextField(value = name,
            onValueChange = onNameChange,
            label = { Text(text = "Nombre") }
        )

        if (name.isNotBlank())
            Text(text = "¡Hola, $name !, qué tal estás?", Modifier.padding(10.dp))
    }
}

// Ejemplo con constructor fijo
@Preview
@Composable
internal fun DetailTopAppBar(
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = AppBarDefaults.TopAppBarElevation
) {
    val context = LocalContext.current

    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ Toast.makeText(context, "Arriba", Toast.LENGTH_SHORT).show()}) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Ir hacia arriba")
            }
        },
        title = { Text(text = "TopAppBScaffold_"+stringResource(R.string.livedata)) },
        actions = {
            IconButton(onClick = { /*TODO*/Toast.makeText(context, "LeerMásTarde", Toast.LENGTH_SHORT).show() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bookmark),
                    contentDescription = "Leer después"
                )
            }
            IconButton(onClick = { /*TODO*/Toast.makeText(context, "Compartir", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Filled.Share, contentDescription = "Compartir")
            }

            IconButton(onClick = { /*TODO*/ Toast.makeText(context, "VerMás", Toast.LENGTH_SHORT).show()}) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Ver más")
            }
        },
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation
    )
}

