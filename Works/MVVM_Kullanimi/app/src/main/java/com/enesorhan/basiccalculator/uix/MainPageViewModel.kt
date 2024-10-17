package com.enesorhan.basiccalculator.uix

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enesorhan.basiccalculator.data.MathmaticsRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainPageViewModel : ViewModel(){
    val sonuc = MutableLiveData("0")
    private val mRepo = MathmaticsRepo()

    fun topla(alinanSayi1:String,alinanSayi2: String){
        CoroutineScope(Dispatchers.Main).launch {
            sonuc.value = mRepo.topla(alinanSayi1,alinanSayi2)
        }
    }
    fun carp(alinanSayi1:String,alinanSayi2: String){
        CoroutineScope(Dispatchers.Main).launch {
            sonuc.value = mRepo.carp(alinanSayi1,alinanSayi2)
        }
    }

}