package com.enesorhan.calculatortask

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorDesign(
    colors: List<Color>,
    buttonTexts: List<String>,
    onClick: (String) -> Unit
    ) {

    Row(
        Modifier
            .fillMaxWidth()
    ) {

        buttonTexts.forEachIndexed { index,buttonText ->

                Button(
                    onClick = { onClick(buttonText) },
                    Modifier
                        .size(90.dp)
                        .weight(1f)
                        .padding(3.dp), shape = CircleShape,

                    colors = ButtonColors(
                        containerColor = colors[index],
                        disabledContainerColor = colors[index],
                        contentColor = Color.Black,
                        disabledContentColor = Color.Black
                    )
                ) {
                    Text(
                        text = buttonText, fontSize = 30.sp, fontWeight = FontWeight.Bold

                    )
                }


        }
    }
}
