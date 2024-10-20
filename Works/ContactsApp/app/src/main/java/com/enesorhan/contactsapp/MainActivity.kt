package com.enesorhan.contactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.enesorhan.contactsapp.ui.theme.ContactsAppTheme
import com.enesorhan.contactsapp.uix.viewModel.AnasayfaViewModel
import com.enesorhan.contactsapp.uix.viewModel.DetaySayfaViewModel
import com.enesorhan.contactsapp.uix.viewModel.KayitSayfaViewModel
import com.enesorhan.contactsapp.uix.views.PageIntent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val anasayfaViewModel:AnasayfaViewModel by viewModels()
    val kayitSayfaViewModel:KayitSayfaViewModel by viewModels()
    val detaySayfaViewModel:DetaySayfaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsAppTheme {
                PageIntent(anasayfaViewModel,detaySayfaViewModel,kayitSayfaViewModel)
            }
        }
    }
}

