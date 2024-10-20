package com.enesorhan.finalproject.uix.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enesorhan.finalproject.data.entities.Meals
import com.enesorhan.finalproject.data.repo.FoodsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(val fRepo:FoodsRepo) : ViewModel() {

    val foodList = MutableLiveData<List<Meals>>()

    fun tumYemekleriGetir() {
        CoroutineScope(Dispatchers.Main).launch {
            foodList.value = fRepo.tumYemekleriGetir()
        }
    }

}