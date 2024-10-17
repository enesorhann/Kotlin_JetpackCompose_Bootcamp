package com.enesorhan.basiccalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.enesorhan.basiccalculator.ui.theme.BasicCalculatorTheme
import com.enesorhan.basiccalculator.uix.MainPageViewModel
import com.enesorhan.basiccalculator.uix.views.MainPage

class MainActivity : ComponentActivity() {
    val mainPageViewModel:MainPageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicCalculatorTheme {
                MainPage(mainPageViewModel = mainPageViewModel)
            }
        }
    }
}
