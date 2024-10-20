package com.enesorhan.contactsapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.enesorhan.contactsapp.data.dataSource.KisilerDataSource
import com.enesorhan.contactsapp.data.entity.Persons
import com.enesorhan.contactsapp.data.entity.retrofit_entity.Retro_Persons
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerRepository(val kds:KisilerDataSource) {




     fun kisileriGetir() : MutableLiveData<List<Retro_Persons>> = kds.getContact()
     fun aramaYap(searchedWord:String) : MutableLiveData<List<Retro_Persons>> = kds.search(searchedWord)
     fun deletePerson(person_id:String) = kds.deletePerson(person_id)
     fun updatePerson(person_id:String,person_name:String,person_phone:String) = kds.updatePerson(person_id, person_name, person_phone)
     fun insertPerson(person_name:String,person_phone:String) = kds.insertPerson(person_name, person_phone)

}