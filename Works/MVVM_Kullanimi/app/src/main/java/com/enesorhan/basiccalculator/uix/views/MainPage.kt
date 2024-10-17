package com.enesorhan.basiccalculator.uix.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.enesorhan.basiccalculator.uix.MainPageViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(mainPageViewModel: MainPageViewModel){
    val sonuc = mainPageViewModel.sonuc.observeAsState("0")
    val tf1 = remember { mutableStateOf("") }
    val tf2 = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = {

                Text(text = "MVVM Architecture")
            })
        }
    ) {paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = sonuc.value, fontSize = 30.sp)

            TextField(
                value = tf1.value,
                onValueChange = {tf1.value=it},
                label = { Text(text = "Num 1")}
                )
            TextField(
                value = tf2.value,
                onValueChange = {tf2.value=it},
                label = { Text(text = "Num 2")}
            )

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = {
                    mainPageViewModel.topla(tf1.value,tf2.value)
                }) {
                    Text(text = "Toplama")
                }
                Button(onClick = {
                    mainPageViewModel.carp(tf1.value,tf2.value)
                }) {
                    Text(text = "Carpma")
                }
            }
        }
    }
}