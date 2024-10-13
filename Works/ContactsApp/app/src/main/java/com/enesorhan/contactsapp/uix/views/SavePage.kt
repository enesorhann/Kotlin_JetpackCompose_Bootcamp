package com.enesorhan.contactsapp.uix.views

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavePage(navController: NavController){

    val tf_name  = remember { mutableStateOf("") }
    val tf_phone  = remember { mutableStateOf("") }

    LaunchedEffect(key1 = true) {

    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Add a new Person") },
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
                value = tf_name.value,
                onValueChange = {tf_name.value=it},
                label = { Text(text = "Person Name")}
            )
            TextField(
                value = tf_phone.value,
                onValueChange = {tf_phone.value=it},
                label = { Text(text = "Person Phone")}
            )
            Button(onClick = {
                insertPerson(tf_name.value,tf_phone.value)
                navController.navigate("mainpage")
            }) {
                Text(text = "Save")
            }
        }
    }
}

fun insertPerson(person_name:String,person_phone:String) {
    Log.e("Added Person","New Person: $person_name - $person_phone")
}
