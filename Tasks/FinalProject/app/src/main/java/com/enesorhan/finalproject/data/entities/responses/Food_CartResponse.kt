package com.enesorhan.finalproject.data.entities.responses

import com.enesorhan.finalproject.data.entities.Food_Cart
import com.enesorhan.finalproject.data.entities.Meals

data class Food_CartResponse(
    val sepet_yemekler:List<Food_Cart>,
    val success:Int
)
