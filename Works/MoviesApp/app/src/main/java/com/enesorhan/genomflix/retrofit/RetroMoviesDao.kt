package com.enesorhan.genomflix.retrofit

import com.enesorhan.genomflix.data.entity.retro_entity.Filmler_Cevap
import retrofit2.http.GET

interface RetroMoviesDao {

    @GET("filmler_yeni/tum_filmler.php")
    suspend fun tumFilmler():Filmler_Cevap

}