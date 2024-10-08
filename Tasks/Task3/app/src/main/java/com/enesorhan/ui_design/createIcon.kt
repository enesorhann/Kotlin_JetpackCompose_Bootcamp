package com.enesorhan.ui_design

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CreateIcon(id:Int, color: Color){
    OutlinedIconButton(onClick = {  },
        Modifier.size(70.dp)) {
        Image(painter = painterResource(id = id), contentDescription = "",
            Modifier.background(color))
    }
}