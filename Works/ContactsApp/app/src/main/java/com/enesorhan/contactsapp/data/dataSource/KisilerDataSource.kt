package com.enesorhan.contactsapp.data.dataSource

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.enesorhan.contactsapp.data.entity.Persons
import com.enesorhan.contactsapp.data.entity.retrofit_entity.Retro_Persons
import com.enesorhan.contactsapp.retrofit.RetrofitPersonsDao
import com.enesorhan.contactsapp.room.PersonsDao
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(val collectionPersons: CollectionReference) {

    val kisilerListesi = MutableLiveData<List<Retro_Persons>>()


    fun getContact() : MutableLiveData<List<Retro_Persons>>{
        collectionPersons.addSnapshotListener { value, error ->
            value?.let{
                val list = ArrayList<Retro_Persons>()
                for (d in value.documents){
                    val person = d.toObject(Retro_Persons::class.java)
                    person?.let {
                        person.kisi_id = d.id
                        list.add(person)
                    }
                }
                kisilerListesi.value = list
            }
        }
        return kisilerListesi
    }
    fun search(searchedWord:String) : MutableLiveData<List<Retro_Persons>>{
        collectionPersons.addSnapshotListener { value, error ->
            value?.let {
                val list = ArrayList<Retro_Persons>()
                for (d in value.documents){
                    val person = d.toObject(Retro_Persons::class.java)
                    person?.let {
                        if(person.kisi_ad!!.lowercase().contains(searchedWord.lowercase())){
                            person.kisi_id = d.id
                            list.add(person)
                        }

                    }
                }
                kisilerListesi.value = list
            }
        }
        return kisilerListesi
    }
    fun deletePerson(person_id:String) {
        collectionPersons.document(person_id).delete()

    }
    fun updatePerson(person_id:String,person_name:String,person_phone:String) {
        val personInfo = HashMap<String,Any>()
        personInfo["kisi_ad"] = person_name
        personInfo["kisi_tel"] = person_phone
        collectionPersons.document(person_id).update(personInfo)
    }

    fun insertPerson(person_name:String,person_phone:String) {
        val person = Retro_Persons("",person_name,person_phone)
        collectionPersons.document().set(person)

    }


}