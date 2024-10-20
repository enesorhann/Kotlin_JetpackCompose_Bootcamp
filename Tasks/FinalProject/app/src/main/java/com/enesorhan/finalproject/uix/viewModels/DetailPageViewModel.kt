package com.enesorhan.finalproject.uix.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enesorhan.finalproject.data.entities.Food_Cart
import com.enesorhan.finalproject.data.repo.FoodsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailPageViewModel @Inject constructor(val fRepo: FoodsRepo) : ViewModel() {

    fun sepeteEkle(
        yemek_adi:String,
        yemek_resim_adi:String,
        yemek_fiyat:Int,
        yemek_siparis_adet:Int,
        kullanici_adi:String
    ) {
        CoroutineScope(Dispatchers.Main).launch {
                fRepo.sepeteEkle(yemek_adi,yemek_resim_adi, yemek_fiyat,
                    yemek_siparis_adet, kullanici_adi)
        }
    }
}