package com.enesorhan.genomflix.data.dataSource

import androidx.lifecycle.MutableLiveData
import com.enesorhan.genomflix.data.entity.Movies
import com.enesorhan.genomflix.data.entity.retro_entity.Filmler_Retrofit
import com.enesorhan.genomflix.retrofit.RetroMoviesDao
import com.enesorhan.genomflix.room.MoviesDao
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesDataSource(var collectionMovies:CollectionReference) {

    val movieList = MutableLiveData<List<Filmler_Retrofit>>()

    fun getMovies() : MutableLiveData<List<Filmler_Retrofit>>{

        collectionMovies.get().addOnCompleteListener {
            val list = ArrayList<Filmler_Retrofit>()
            for (d in it.result){
                val movie = d.toObject(Filmler_Retrofit::class.java)
                movie.id=d.id
                list.add(movie)
            }
            movieList.value = list
        }
        return movieList
    }

}