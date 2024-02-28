package com.example.compose_state.examples.android_developer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

//https://developer.android.com/codelabs/jetpack-compose-state?hl=es-419#8

/*
 Elevación de estado
 -------------------
Un elemento componible que usa remember para almacenar un objeto contiene un estado interno, lo que genera un elemento componible con estado. Esto es útil en situaciones en las que no es necesario que el llamador controle el estado, y pueda usar este estado sin tener que administrarlo por su cuenta. Sin embargo, los elementos de componibilidad con estado interno suelen ser menos reutilizables y más difíciles de probar.

Los elementos de componibilidad y que no tienen ningún estado se denominan elementos sin estado. Una forma fácil de crear un elemento de componibilidad sin estado es usar la elevación de estado.

La toma de estado en Compose es un patrón asociado al movimiento de estado a un llamador de un elemento de componibilidad a fin de quitarle el estado al elemento. El patrón general para la elevación de estado en Jetpack Compose es reemplazar la variable de estado con dos parámetros:

valor: T: Es el valor actual que se mostrará.
onValueChange: (T) -> Unit: Es un evento que solicita que el valor cambie con un valor T nuevo,
donde este valor representa cualquier estado que podría modificarse.

El patrón en el que el estado baja y los eventos suben se denomina flujo unidireccional de datos (UDF), y la elevación de estado es la forma en que implementamos esta arquitectura en Compose. Puedes obtener más información al respecto en la documentación de la arquitectura de Compose.

El estado elevado de esta manera tiene algunas propiedades importantes:

Fuente única de información: Mover el estado en lugar de duplicarlo garantizará que exista solo una fuente de información. Eso ayuda a evitar errores.
Capacidad de compartir: El estado elevado puede compartirse con varios elementos de componibilidad.
Capacidad de interceptar: Los llamadores a los elementos de componibilidad sin estado pueden decidir ignorar o modificar eventos antes de cambiar el estado.
Separación: El estado de una función de componibilidad sin estado se puede almacenar en cualquier lugar. Por ejemplo, en un ViewModel.
Intenta implementar esto para el WaterCounter de modo que pueda beneficiarse de todo lo anterior.

Con estado y sin estado
-----------------------
Cuando se puede extraer todo el estado de una función de componibilidad, la función de componibilidad resultante se denomina sin estado.

Un elemento de componibilidad sin estado no tiene ningún estado, por lo que no contiene ni define o modifica un estado nuevo.

Un elemento de componibilidad con estado es aquel que posee un fragmento de estado que puede cambiar con el tiempo.

En apps reales, tener un elemento de componibilidad 100% sin estado puede ser difícil de alcanzar según las responsabilidades de ese elemento. Debes diseñar tus elementos componibles de modo que tengan la menor cantidad de estado posible y permitir que se eleve cuando convenga, exponiéndolos en la API del elemento componible.
* */

/*
Refactoriza el elemento de componibilidad WaterCounter dividiéndolo en dos partes: contador con estado y sin estado.

La función del StatelessCounter es mostrar el count y llamar a una función cuando incrementas el count.
Para ello, sigue el patrón descrito anteriormente y pasa:
 +el estado, count (como parámetro a la función de componibilidad)
 +y una lambda (onIncrement), a la que se llama cuando se debe incrementar el estado. StatelessCounter se ve así:
* */



@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

//StatefulCounter es propietario del estado. Eso significa que contiene el estado count y lo modifica cuando llama a la función StatelessCounter.


@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)
}
//¡Bien hecho! Elevaste count de StatelessCounter a StatefulCounter.

//Puedes conectar esto a tu app y actualizar WellnessScreen con StatefulCounter:


@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        StatefulCounter(modifier)
        
    }
}
