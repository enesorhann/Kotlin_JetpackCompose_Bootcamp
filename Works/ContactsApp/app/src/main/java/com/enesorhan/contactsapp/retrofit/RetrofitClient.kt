package com.enesorhan.contactsapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url
import java.net.URL

class RetrofitClient {

    companion object{
        fun getClient(baseURL:String):Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}