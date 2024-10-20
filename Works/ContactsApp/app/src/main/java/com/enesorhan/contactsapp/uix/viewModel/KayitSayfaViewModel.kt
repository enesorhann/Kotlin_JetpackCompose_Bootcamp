package com.enesorhan.contactsapp.uix.viewModel

import androidx.lifecycle.ViewModel
import com.enesorhan.contactsapp.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KayitSayfaViewModel @Inject constructor(val kRepo:KisilerRepository) : ViewModel() {

    fun ekle(person_name:String,person_phone:String){

         kRepo.insertPerson(person_name, person_phone)

    }
}