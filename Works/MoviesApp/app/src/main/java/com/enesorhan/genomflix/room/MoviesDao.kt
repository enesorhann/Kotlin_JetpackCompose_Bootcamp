package com.enesorhan.genomflix.room

import androidx.room.Dao
import androidx.room.Query
import com.enesorhan.genomflix.data.entity.Movies

@Dao
interface MoviesDao {
    @Query("SELECT * FROM filmler")
    suspend fun allMovies() : List<Movies>
}