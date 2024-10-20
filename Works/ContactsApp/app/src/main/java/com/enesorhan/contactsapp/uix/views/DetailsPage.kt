package com.enesorhan.contactsapp.uix.views

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
import com.enesorhan.contactsapp.data.entity.retrofit_entity.Retro_Persons
import com.enesorhan.contactsapp.uix.viewModel.DetaySayfaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsPage(navController: NavController, inputPerson: Retro_Persons, detaySayfaViewModel: DetaySayfaViewModel){

    val tf_name  = remember { mutableStateOf("") }
    val tf_phone  = remember { mutableStateOf("") }

    LaunchedEffect(key1 = true) {
        tf_name.value = inputPerson.kisi_ad!!
        tf_phone.value = inputPerson.kisi_tel!!
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Details of Person") },

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
                detaySayfaViewModel.update(inputPerson.kisi_id!!,tf_name.value,tf_phone.value)
                navController.navigate("mainpage")
            }) {
                Text(text = "Update")
            }
        }
    }
}
