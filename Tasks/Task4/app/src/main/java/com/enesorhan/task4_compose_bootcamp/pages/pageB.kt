package com.enesorhan.task4_compose_bootcamp.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun PageB(navController: NavController){
    Scaffold{paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            Arrangement.SpaceEvenly,
            Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    navController.navigate("pageY"){
                        popUpTo("pageB"){inclusive=true}
                    }
                }
            ) {
                Text(text = "Page Y")
            }

        }
    }
}