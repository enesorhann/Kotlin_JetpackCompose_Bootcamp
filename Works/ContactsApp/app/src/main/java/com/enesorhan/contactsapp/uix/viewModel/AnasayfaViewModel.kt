package com.enesorhan.contactsapp.uix.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enesorhan.contactsapp.data.entity.Persons
import com.enesorhan.contactsapp.data.entity.retrofit_entity.Retro_Persons
import com.enesorhan.contactsapp.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(val kRepo:KisilerRepository) : ViewModel() {

    var kisilerListesi = MutableLiveData<List<Retro_Persons>>()

    init {
        kisileriYukle()
    }

    fun kisileriYukle(){

            kisilerListesi = kRepo.kisileriGetir()

    }
    fun ara(searchedWord:String){

        kisilerListesi = kRepo.aramaYap(searchedWord)

    }
    fun sil(person_id:String){

            kRepo.deletePerson(person_id)
            kisileriYukle()

    }
}