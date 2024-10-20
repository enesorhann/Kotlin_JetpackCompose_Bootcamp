package com.enesorhan.genomflix.retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"
        fun getFilmlerDao() : RetroMoviesDao{
            return RetrofitClient.getClient(BASE_URL).create(RetroMoviesDao::class.java)
        }
    }

}