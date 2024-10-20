package com.enesorhan.contactsapp.uix.viewModel

import androidx.lifecycle.ViewModel
import com.enesorhan.contactsapp.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetaySayfaViewModel @Inject constructor(val kRepo:KisilerRepository) : ViewModel() {



    fun update(person_id:String,person_name:String,person_phone:String){

            kRepo.updatePerson(person_id,person_name,person_phone)

    }
}