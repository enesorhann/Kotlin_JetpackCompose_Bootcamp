package com.enesorhan.sayacpreferences

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.enesorhan.sayacpreferences.ui.theme.SayacPreferencesTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SayacPreferencesTheme {
                CountDownTimer()
            }
        }
    }
}

@Composable
fun CountDownTimer(){
    val context = LocalContext.current
    val appPref = AppPref(context)
    val sayacVal = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = true) {
        CoroutineScope(Dispatchers.Main).launch { //suspend fun icin dynamic calismamiz lazim
            var gelenDeger = appPref.okuSayac()
            sayacVal.value = ++gelenDeger
            appPref.kayitSayac(gelenDeger)
        } }

    Column(
        Modifier.fillMaxSize(),
        Arrangement.SpaceEvenly,
        Alignment.CenterHorizontally
    ) {
        Text(text = "${sayacVal.value}", fontSize = 40.sp) // Bu yapiyla zamanlayici yapilabilir
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SayacPreferencesTheme {
        CountDownTimer()
    }
}