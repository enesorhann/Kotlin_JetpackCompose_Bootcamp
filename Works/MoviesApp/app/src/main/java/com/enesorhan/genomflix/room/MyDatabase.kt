package com.enesorhan.genomflix.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.enesorhan.genomflix.data.entity.Movies

@Database(entities = [Movies::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getMoviesDao() :MoviesDao
}