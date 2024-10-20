package com.enesorhan.contactsapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.enesorhan.contactsapp.data.entity.Persons

@Database(entities = [Persons::class], version = 2)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getPersonsDao(): PersonsDao
}