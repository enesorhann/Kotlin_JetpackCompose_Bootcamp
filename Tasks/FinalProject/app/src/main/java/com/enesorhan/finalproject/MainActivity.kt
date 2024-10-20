package com.enesorhan.finalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.enesorhan.finalproject.ui.theme.FinalProjectTheme
import com.enesorhan.finalproject.uix.viewModels.CartPageViewModel
import com.enesorhan.finalproject.uix.viewModels.DetailPageViewModel
import com.enesorhan.finalproject.uix.viewModels.MainPageViewModel
import com.enesorhan.finalproject.uix.views.PageIntents
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val mainPageViewModel:MainPageViewModel by viewModels()
    val detailPageViewModel:DetailPageViewModel by viewModels()
    val cartPageViewModel:CartPageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinalProjectTheme {
                PageIntents(mainPageViewModel,cartPageViewModel,detailPageViewModel)
            }
        }
    }
}
