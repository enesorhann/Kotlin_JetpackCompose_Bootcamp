package com.enesorhan.todoapp.uix.views

import android.telecom.Call.Details
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.enesorhan.todoapp.data.entity.ToDo
import com.enesorhan.todoapp.uix.viewModels.DetailsViewModels

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsPage(navController: NavController, toDo: ToDo,detailsViewModels: DetailsViewModels){

    val tfName = remember { mutableStateOf("") }

    LaunchedEffect(key1 = true) {
        tfName.value=toDo.name
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Details ToDo")
                }
            )
        }
    ) {paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            TextField(
                value = tfName.value,
                onValueChange = {tfName.value=it},
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Blue,
                    focusedContainerColor = Color.Transparent,
                    focusedLabelColor = Color.Blue,
                    unfocusedLabelColor = Color.Blue,
                    unfocusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Blue,
                ),
                label = { Text(text = "Name")}
            )
            ElevatedButton(
                onClick = {
                    detailsViewModels.updateToDo(toDo.id,tfName.value)
                    navController.navigate("mainpage")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = android.R.color.holo_orange_dark),
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(15.dp)) {
                Text(text = "Update")
            }
        }
    }
}