package com.enesorhan.genomflix.data.repo

import androidx.lifecycle.MutableLiveData
import com.enesorhan.genomflix.data.dataSource.MoviesDataSource
import com.enesorhan.genomflix.data.entity.Movies
import com.enesorhan.genomflix.data.entity.retro_entity.Filmler_Retrofit

class MoviesRepo(val mds:MoviesDataSource) {

    fun getMovies() : MutableLiveData<List<Filmler_Retrofit>> = mds.getMovies()
}