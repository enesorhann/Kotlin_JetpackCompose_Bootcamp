package com.enesorhan.finalproject.data.dataSource

import com.enesorhan.finalproject.data.entities.Food_Cart
import com.enesorhan.finalproject.data.entities.Meals
import com.enesorhan.finalproject.retrofit.dao.FoodCart_Dao
import com.enesorhan.finalproject.retrofit.dao.MealsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DataSource(val mealsDao: MealsDao,val cartDao: FoodCart_Dao) {
    suspend fun tumYemekleriGetir() : List<Meals> = withContext(Dispatchers.IO){
        return@withContext mealsDao.getAllFood().yemekler
    }
    suspend fun tumSepetiGetir(kullaniciAdi:String) : List<Food_Cart> = withContext(Dispatchers.IO){
        return@withContext cartDao.getAllFoodCart(kullaniciAdi).sepet_yemekler
    }
    suspend fun sepeteEkle(
        yemek_adi:String,
        yemek_resim_adi:String,
        yemek_fiyat:Int,
        yemek_siparis_adet:Int,
        kullanici_adi:String
    ) {
        cartDao.insertFoodCart(
            yemek_adi,
            yemek_resim_adi,
            yemek_fiyat,
            yemek_siparis_adet,
            kullanici_adi
        )
    }

    suspend fun sepettenSil(
        sepet_yemek_id:Int,
        kullanici_adi:String
    ) {
        cartDao.deleteFoodCart(sepet_yemek_id, kullanici_adi)
    }
}