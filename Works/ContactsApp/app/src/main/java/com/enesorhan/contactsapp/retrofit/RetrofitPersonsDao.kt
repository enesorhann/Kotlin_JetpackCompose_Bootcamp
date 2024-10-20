package com.enesorhan.contactsapp.retrofit

import com.enesorhan.contactsapp.data.entity.retrofit_entity.IUD_Cevap
import com.enesorhan.contactsapp.data.entity.retrofit_entity.Persons_Cevap
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitPersonsDao {

    @GET("test/tum_kisiler.php")
    suspend fun tumKisiler():Persons_Cevap

    @POST("test/tum_kisiler_arama.php")
    @FormUrlEncoded
    suspend fun araKisiler(@Field("kisi_ad") person_name:String):Persons_Cevap

    @POST("test/insert_kisiler.php")
    @FormUrlEncoded
    suspend fun kisiEkle(
        @Field("kisi_ad") person_name: String,
        @Field("kisi_tel") person_phone:String
    ):IUD_Cevap

    @POST("test/update_kisiler.php")
    @FormUrlEncoded
    suspend fun kisiGuncelle(
        @Field("kisi_id") person_id:Int,
        @Field("kisi_ad") person_name: String,
        @Field("kisi_tel") person_phone:String
    ):IUD_Cevap

    @POST("test/delete_kisiler.php")
    @FormUrlEncoded
    suspend fun kisiSil(
        @Field("kisi_id") person_id: Int,
    ):IUD_Cevap
}