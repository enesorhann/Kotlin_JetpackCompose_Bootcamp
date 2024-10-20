package com.enesorhan.contactsapp.data.entity.retrofit_entity

import com.enesorhan.contactsapp.data.entity.Persons

data class Persons_Cevap(
    var kisiler:List<Retro_Persons>,
    val success:Int
)