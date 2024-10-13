package com.enesorhan.widgets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enesorhan.widgets.ui.theme.WidgetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WidgetsTheme {
                MainPage()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(){

    val tf = remember { mutableStateOf("") }
    val getText = remember { mutableStateOf("") }
    val checkValue = remember { mutableStateOf(false) }
    val switchValue = remember { mutableStateOf(false) }
    val radioValue = remember { mutableStateOf(0) }
    val countries = listOf("Turkey","Japan","Italy","France","USA","UK","Russian","Germany")
    val currentIndex = remember { mutableStateOf(0) }
    val control = remember { mutableStateOf(false) }
    val sliderVal = remember { mutableStateOf(0f) }
    val progressVal = remember { mutableStateOf(false) }


    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Mainpage") }) }
    ) {paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Text(text = getText.value)
            TextField(value = tf.value, onValueChange = {tf.value=it})
            Image(painter = painterResource(id = R.drawable.baseline_emoji_emotions_24), contentDescription = "")
            Button(onClick = { getText.value=tf.value }) {
                Text(text = "Read")
            }

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(checked = checkValue.value, onCheckedChange = {checkValue.value=it})
                    Text(text = "Jetpack Compose")

                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Switch(checked = switchValue.value, onCheckedChange = {switchValue.value=it})
                    Text(text = "Kotlin")

                }

            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = radioValue.value==1, onClick = { radioValue.value=1 })
                    Text(text = "Barcelona")
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = radioValue.value==2, onClick = { radioValue.value=2 })
                    Text(text = "Real Madrid")
                }

            }

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Button(onClick = {
                    progressVal.value=true
                }) {
                    Text(text = "Start")
                }
                if(progressVal.value){
                    CircularProgressIndicator()
                }
                Button(onClick = { progressVal.value=false }) {
                    Text(text = "Stop")
                }
            }

            Text(text = "Volume: ${sliderVal.value.toInt()}")

            Slider(
                value = sliderVal.value,
                onValueChange = {sliderVal.value=it},
                valueRange = 0f..100f,
                modifier = Modifier.padding(20.dp)
            )

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(120.dp, 40.dp)
                    .clickable { control.value = true }
            ){
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = countries[currentIndex.value], fontSize = 20.sp)
                    Image(painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24), contentDescription = "")
                }
                DropdownMenu(expanded = control.value, onDismissRequest = { control.value=false }) {
                    countries.forEachIndexed { index, country ->
                        DropdownMenuItem(
                            text = { Text(text = country, fontSize = 20.sp)},
                            onClick = {
                                control.value=false
                                currentIndex.value=index
                            }
                        )
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WidgetsTheme {
        MainPage()
    }
}