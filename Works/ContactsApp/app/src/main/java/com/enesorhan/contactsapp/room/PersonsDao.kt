package com.enesorhan.contactsapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.enesorhan.contactsapp.data.entity.Persons


@Dao
interface PersonsDao {
    @Query("SELECT * FROM kisiler")
    suspend fun allPerson() : List<Persons>

    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%' || :searchedWord || '%' ")
    suspend fun searchPerson(searchedWord:String) : List<Persons>

    @Insert
    suspend fun insertPerson(persons: Persons)

    @Update
    suspend fun updatePerson(persons: Persons)

    @Delete
    suspend fun deletePerson(persons: Persons)

}