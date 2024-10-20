package com.enesorhan.finalproject.data.entities.responses

import com.enesorhan.finalproject.data.entities.Meals

data class MealsResponse(
    val yemekler:List<Meals>,
    val success:Int
)
