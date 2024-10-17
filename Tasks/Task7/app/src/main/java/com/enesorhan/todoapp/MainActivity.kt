package com.enesorhan.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.enesorhan.todoapp.ui.theme.ToDoAppTheme
import com.enesorhan.todoapp.uix.viewModels.DetailsViewModels
import com.enesorhan.todoapp.uix.viewModels.MainViewModels
import com.enesorhan.todoapp.uix.viewModels.SaveViewModels
import com.enesorhan.todoapp.uix.views.PageIntents
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val mainViewModels:MainViewModels by viewModels()
    val saveViewModels:SaveViewModels by viewModels()
    val detailsViewModels:DetailsViewModels by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoAppTheme {
                PageIntents(mainViewModels,saveViewModels,detailsViewModels)
            }
        }
    }
}

