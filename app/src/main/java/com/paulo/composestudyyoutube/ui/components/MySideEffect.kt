package com.paulo.composestudyyoutube.ui.components

import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import kotlinx.coroutines.launch

@Composable
fun MySideEffect() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(scaffoldState =  scaffoldState) {
        var counter = produceState(initialValue = 0){
            kotlinx.coroutines.delay(3000L)
            value = 4
        }
        if(counter.value % 5 == 0 && counter.value > 0){
           LaunchedEffect(key1 = scaffoldState.snackbarHostState ) {
                scaffoldState.snackbarHostState.showSnackbar(
                    "Opa module % 5"
                )
            }

        }
        Button(onClick = {}) {
            Text(text =  "Click me: ${counter.value}")
        }
    }
}