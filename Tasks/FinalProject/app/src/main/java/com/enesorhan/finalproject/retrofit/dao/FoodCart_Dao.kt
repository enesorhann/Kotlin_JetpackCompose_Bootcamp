package com.enesorhan.finalproject.retrofit.dao

import com.enesorhan.finalproject.data.entities.responses.CRUD_Response
import com.enesorhan.finalproject.data.entities.responses.Food_CartResponse
import com.enesorhan.finalproject.data.entities.responses.MealsResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodCart_Dao {

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun getAllFoodCart(
        @Field("kullanici_adi") kullanici_adi:String
    ) : Food_CartResponse

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun insertFoodCart(
        @Field("yemek_adi") yemek_adi:String,
        @Field("yemek_resim_adi") yemek_resim_adi:String,
        @Field("yemek_fiyat") yemek_fiyat:Int,
        @Field("yemek_siparis_adet") yemek_siparis_adet:Int,
        @Field("kullanici_adi") kullanici_adi:String
    ) : CRUD_Response

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun deleteFoodCart(
        @Field("sepet_yemek_id") sepet_yemek_id:Int,
        @Field("kullanici_adi") kullanici_adi:String
    ) : CRUD_Response

}