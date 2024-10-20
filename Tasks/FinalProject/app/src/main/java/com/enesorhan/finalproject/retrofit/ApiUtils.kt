package com.enesorhan.finalproject.retrofit

import com.enesorhan.finalproject.retrofit.dao.FoodCart_Dao
import com.enesorhan.finalproject.retrofit.dao.MealsDao

class ApiUtils {


    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"
        fun getMealsDao() : MealsDao {
            return RetrofitClient.getClient(BASE_URL).create(MealsDao::class.java)
        }
        fun getFoodCart_Dao() : FoodCart_Dao {
            return RetrofitClient.getClient(BASE_URL).create(FoodCart_Dao::class.java)
        }
    }

}