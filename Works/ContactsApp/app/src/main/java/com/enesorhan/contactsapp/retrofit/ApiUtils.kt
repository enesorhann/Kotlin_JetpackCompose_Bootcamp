package com.enesorhan.contactsapp.retrofit

class ApiUtils {

    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"
        fun getRetroDao():RetrofitPersonsDao{
            return RetrofitClient.getClient(BASE_URL).create(RetrofitPersonsDao::class.java)
        }
    }

}