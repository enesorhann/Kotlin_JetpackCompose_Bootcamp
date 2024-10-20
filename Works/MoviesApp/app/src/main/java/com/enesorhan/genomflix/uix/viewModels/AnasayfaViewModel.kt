package com.enesorhan.genomflix.uix.viewModels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enesorhan.genomflix.data.entity.Movies
import com.enesorhan.genomflix.data.entity.retro_entity.Filmler_Retrofit
import com.enesorhan.genomflix.data.repo.MoviesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(val mRepo:MoviesRepo) : ViewModel() {

    var movieList = MutableLiveData<List<Filmler_Retrofit>>()


    init {
        getMovies()
    }

    fun getMovies() {
        movieList = mRepo.getMovies()
    }
}