package com.enesorhan.finalproject.data.entities

data class Food_Cart(
    val sepet_yemek_id:Int,
    val yemek_adi:String,
    val yemek_resim_adi:String,
    val yemek_fiyat:Int,
    var yemek_siparis_adet:Int,
    val kullanici_adi:String
)
