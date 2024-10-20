package com.enesorhan.finalproject.uix.viewModels

import android.util.Log
import android.widget.Toast
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
class CartPageViewModel @Inject constructor(val fRepo: FoodsRepo) : ViewModel() {
    val cartList = MutableLiveData<List<Food_Cart>?>()

    fun tumSepetiGetir(kullanici_adi:String) {
        CoroutineScope(Dispatchers.Main).launch {

            try {
                cartList.value = fRepo.tumSepetiGetir(kullanici_adi)
            }catch (e:Exception){
                Log.e("API ERROR","${e.message} ${e.cause}")
            }



        }
    }

    fun sepettenSil(sepet_yemek_id:Int, kullanici_adi:String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
               fRepo.sepettenSil(sepet_yemek_id,kullanici_adi)
                if(cartList.value?.size==1){
                    cartList.value = emptyList()
                }

                tumSepetiGetir(kullanici_adi)
            }catch (e:Exception){
                Log.e("Silme Hatasi","${e.message} ${e.cause}")
            }

        }

    }
    fun sepetiGuncelle(gelenFood: Food_Cart,yeniDeger:Int){

        val guncelListe = cartList.value?.map { itemOfcartList->
            if (itemOfcartList.sepet_yemek_id==gelenFood.sepet_yemek_id){
                itemOfcartList.copy(yemek_siparis_adet = yeniDeger)
            }else itemOfcartList
        }
        cartList.value = guncelListe
    }
}