package com.enesorhan.calculatortask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enesorhan.calculatortask.ui.theme.CalculatorTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTaskTheme {
                MainPage()
            }
        }
    }
}

@Composable
fun MainPage() {

    val tf = remember { mutableStateOf("0") }
    val operator = remember { mutableStateOf("") }
    var num1 = remember { mutableStateOf(0) }
    var num2 = remember { mutableStateOf(0) }
    val screenSize = LocalConfiguration.current
    val screenWidth = screenSize.screenWidthDp
    val screenHeight = screenSize.screenHeightDp

    Scaffold { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize(),
        ){
            Spacer(modifier = Modifier.size(200.dp))
            Row(modifier = Modifier
                .weight(20f)
                .fillMaxSize()
                ,
                ){
                TextField(
                    shape = RoundedCornerShape(40f),
                    value = (tf.value),
                    onValueChange = {tf.value=it},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(120.dp),
                    textStyle = TextStyle(
                        textAlign = TextAlign.End,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = android.R.color.system_control_activated_dark),
                        fontSize = 50.sp,

                    ),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        disabledTextColor = Color.White
                    ),
                    enabled = false
                    )
            }


            val list1 = listOf("AC","+/-","%","/")
            val list1Color = listOf(colorResource(id = android.R.color.darker_gray),colorResource(id = android.R.color.darker_gray),colorResource(id = android.R.color.darker_gray),colorResource(id = android.R.color.holo_orange_light))

            CalculatorDesign(
                colors = list1Color,
                buttonTexts = list1,
                onClick = {buttonText ->
                    when(buttonText){
                        "AC" -> {
                            tf.value="0"
                            operator.value = ""
                            num1.value = 0
                            num2.value = 0
                        }
                        "+/-","%","/" -> {
                            tf.value += buttonText
                            operator.value = buttonText
                        }

                    }

                }
            )


            val list2 = listOf("7","8","9","x")
            val list2Color = listOf(Color.DarkGray,Color.DarkGray,Color.DarkGray,colorResource(id = android.R.color.holo_orange_light))

            CalculatorDesign(
                colors = list2Color,
                buttonTexts = list2,
                onClick = { buttonText ->
                    when (buttonText) {
                        "7","8","9" -> {
                            if(operator.value.isEmpty()){
                                num1.value = buttonText.toInt()
                                tf.value = buttonText
                            }else{
                                num2.value = buttonText.toInt()
                                tf.value += buttonText
                            }

                        }

                        "x" -> {
                            tf.value += buttonText
                            operator.value = buttonText
                        }

                    }
                }

            )

            val list3 = listOf("4","5","6","-")
            val list3Color = listOf(Color.DarkGray,Color.DarkGray,Color.DarkGray,colorResource(id = android.R.color.holo_orange_light))

            CalculatorDesign(
                colors = list3Color,
                buttonTexts = list3,
                onClick = { buttonText ->
                    when (buttonText) {
                        "4","5","6" -> {
                            if(operator.value.isEmpty()){
                                num1.value = buttonText.toInt()
                                tf.value = buttonText
                            }else{
                                num2.value = buttonText.toInt()
                                tf.value += buttonText
                            }
                        }


                        "-" -> {
                            tf.value += buttonText
                            operator.value = buttonText
                        }

                    }
                }
            )

            val list4 = listOf("1","2","3","+")
            val list4Color = listOf(Color.DarkGray,Color.DarkGray,Color.DarkGray,colorResource(id = android.R.color.holo_orange_light))

            CalculatorDesign(
                colors = list4Color,
                buttonTexts = list4,
                onClick = { buttonText ->
                    when (buttonText) {
                        "1","2","3" -> {

                            if(operator.value.isEmpty()){
                                num1.value = buttonText.toInt()
                                tf.value = buttonText
                            }else{
                                num2.value = buttonText.toInt()
                                tf.value += buttonText
                            }
                        }

                        "+" -> {
                            tf.value += buttonText
                            operator.value = buttonText
                        }

                    }


                }
            )

            val list5 = listOf("0",",","=")
            val list5Color = listOf(Color.DarkGray,Color.DarkGray,colorResource(id = android.R.color.holo_orange_light))

            CalculatorDesign(
                colors = list5Color,
                buttonTexts = list5,
                onClick = {buttonText ->

                    when(buttonText){
                        "0" -> {
                            if(operator.value.isEmpty()){
                                num1.value = buttonText.toInt()
                                tf.value = buttonText
                            }else{
                                num2.value = buttonText.toInt()
                                tf.value += buttonText
                            }
                        }
                        "=" -> {
                            when(operator.value){
                                "+" -> {
                                    try {
                                        tf.value= (num1.value+num2.value).toString()
                                    }catch (e:Exception){
                                        tf.value = e.toString()
                                    }
                                     }
                                "-" -> {
                                    try {
                                        tf.value= (num1.value-num2.value).toString()
                                    }catch (e:Exception){
                                        tf.value = e.toString()
                                    }
                                }
                                "x" -> {
                                    try {
                                        tf.value= (num1.value*num2.value).toString()
                                    }catch (e:Exception){
                                        tf.value = e.toString()
                                    }                                }
                                "/" -> {
                                    try {
                                        tf.value= (num1.value/num2.value).toString()
                                    }catch (e:Exception){
                                        tf.value = e.message.toString()
                                    }                                }
                                "%" -> {
                                    try {
                                        tf.value= (num1.value%num2.value).toString()
                                    }catch (e:Exception){
                                        tf.value = e.toString()
                                    }                                }
                                "+/-" -> {
                                    try {
                                        tf.value= (num1.value+num2.value).toString()
                                    }catch (e:Exception){
                                        tf.value = e.toString()
                                    }                                }


                            }
                            operator.value = ""
                            num1.value = 0
                            num2.value = 0
                        }
                    }


                }
            )

        } } }
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTaskTheme {
        MainPage()
    }
}