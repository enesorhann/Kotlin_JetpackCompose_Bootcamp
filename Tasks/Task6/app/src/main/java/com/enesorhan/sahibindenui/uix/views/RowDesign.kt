package com.enesorhan.sahibindenui.uix.views

import android.annotation.SuppressLint
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableInteractionSource")
@Composable
fun RowDesign(text1:String,text2: String,color1: Color=Color.Gray,color2: Color=Color.Gray){

    Row(
        Modifier
            .fillMaxWidth()
            .indicatorLine(
                true,
                false,
                MutableInteractionSource(),
                colors = TextFieldDefaults.colors()
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = text1, fontWeight = FontWeight.W600, fontSize = 18.sp, color = color1)
        Text(text = text2,fontWeight = FontWeight.W600, color = color2, fontSize = 18.sp)
    }
}