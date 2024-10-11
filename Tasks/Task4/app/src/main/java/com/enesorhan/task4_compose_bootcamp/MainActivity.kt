package com.enesorhan.task4_compose_bootcamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.enesorhan.task4_compose_bootcamp.pages.SayfaGecisleri
import com.enesorhan.task4_compose_bootcamp.ui.theme.Task4_compose_bootcampTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task4_compose_bootcampTheme {
                SayfaGecisleri()
            }
        }
    }
}

@Composable
fun MainPage(navController: NavController){
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
                    navController.navigate("pageA")
                }
            ) {
                Text(text = "Page A")
            }
            Button(
                onClick = {
                    navController.navigate("pageX")
                }
            ) {
                Text(text = "Page X")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Task4_compose_bootcampTheme {
    }
}