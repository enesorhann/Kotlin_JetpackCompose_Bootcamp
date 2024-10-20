package com.enesorhan.finalproject.retrofit.dao

import com.enesorhan.finalproject.data.entities.responses.MealsResponse
import retrofit2.http.GET

interface MealsDao {
    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getAllFood() : MealsResponse

}