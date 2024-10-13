package com.enesorhan.sahibindenui

import android.icu.text.DateFormat
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.DatePickerState
import com.enesorhan.sahibindenui.data.entity.Cars
import com.enesorhan.sahibindenui.ui.theme.SahibindenUITheme
import com.enesorhan.sahibindenui.uix.views.PageIntent
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SahibindenUITheme {
                PageIntent()
            }
        }
    }
}
