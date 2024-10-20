package com.enesorhan.finalproject.data.repo

import com.enesorhan.finalproject.data.dataSource.DataSource
import com.enesorhan.finalproject.data.entities.Food_Cart
import com.enesorhan.finalproject.data.entities.Meals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodsRepo(val ds:DataSource) {
    suspend fun tumYemekleriGetir() : List<Meals> = ds.tumYemekleriGetir()

    suspend fun tumSepetiGetir(kullaniciAdi:String) : List<Food_Cart> = ds.tumSepetiGetir(kullaniciAdi)

    suspend fun sepeteEkle(
        yemek_adi:String,
        yemek_resim_adi:String,
        yemek_fiyat:Int,
        yemek_siparis_adet:Int,
        kullanici_adi:String
    ) = ds.sepeteEkle(yemek_adi,
        yemek_resim_adi,
        yemek_fiyat,
        yemek_siparis_adet,
        kullanici_adi)

    suspend fun sepettenSil(
        sepet_yemek_id:Int,
        kullanici_adi:String
    ) = ds.sepettenSil(sepet_yemek_id, kullanici_adi)

}