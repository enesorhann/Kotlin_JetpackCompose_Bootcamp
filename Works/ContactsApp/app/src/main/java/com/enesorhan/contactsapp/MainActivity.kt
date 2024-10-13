package com.enesorhan.contactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.enesorhan.contactsapp.ui.theme.ContactsAppTheme
import com.enesorhan.contactsapp.uix.views.PageIntent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsAppTheme {
                PageIntent()
            }
        }
    }
}

