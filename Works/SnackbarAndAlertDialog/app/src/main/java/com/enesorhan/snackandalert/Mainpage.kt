package com.enesorhan.snackandalert

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(){
    val scope = rememberCoroutineScope()
    val hostState = remember {SnackbarHostState()}
    val alertControl = remember { mutableStateOf(false) }

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Snack & Alert") })},
        snackbarHost = {
            SnackbarHost(hostState = hostState){
                Snackbar(
                    snackbarData = it,
                    containerColor = Color.LightGray,
                    contentColor = Color.Blue,
                    actionColor = Color.Green,
                    actionContentColor = Color.Green,
                    dismissActionContentColor = Color.Red
                )
            }
        }
    ) {paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            Arrangement.SpaceEvenly,
            Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                scope.launch {
                    val sb = hostState.showSnackbar("Do you want to delete this?", actionLabel = "Yes")

                    if(sb==SnackbarResult.ActionPerformed){
                        hostState.showSnackbar("Deleted")
                    }
                }
            }) {
                Text(text = "Snackbar")
            }
            if (alertControl.value){
                AlertDialog(
                    onDismissRequest = { alertControl.value=false },
                    confirmButton = {
                        Button(onClick = {
                            alertControl.value=false
                            scope.launch {
                                hostState.showSnackbar("DELETED")
                            }
                        }) {
                            Text(text = "Accept")
                        }
                    },
                    dismissButton = {
                        Button(onClick = {
                            alertControl.value=false
                            scope.launch {
                                hostState.showSnackbar("CANCELED")
                            }
                        }) {
                            Text(text = "Reject")
                        }
                    },
                    title = { Text(text = "File Controller")},
                    text = { Text(text = "Do you want to delete this file")}

                )
            }
            Button(onClick = {
                alertControl.value=true
            }) {
                Text(text = "Alert Dialog")
            }
        }
    }

}