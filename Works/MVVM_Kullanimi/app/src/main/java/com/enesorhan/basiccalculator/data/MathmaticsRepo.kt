package com.enesorhan.basiccalculator.data

class MathmaticsRepo{
    val mds = MathMaticsDataSource()
    suspend fun topla(alinanSayi1:String,alinanSayi2: String) : String = mds.toplama(alinanSayi1,alinanSayi2)
    suspend fun carp(alinanSayi1:String,alinanSayi2: String) : String = mds.carpma(alinanSayi1,alinanSayi2)
}
