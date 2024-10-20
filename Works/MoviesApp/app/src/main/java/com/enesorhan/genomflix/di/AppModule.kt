package com.enesorhan.genomflix.di

import android.content.Context
import androidx.room.Room
import com.enesorhan.genomflix.data.dataSource.MoviesDataSource
import com.enesorhan.genomflix.data.repo.MoviesRepo
import com.enesorhan.genomflix.retrofit.ApiUtils
import com.enesorhan.genomflix.retrofit.RetroMoviesDao
import com.enesorhan.genomflix.room.MoviesDao
import com.enesorhan.genomflix.room.MyDatabase
import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideMoviesRepo(mds:MoviesDataSource):MoviesRepo{
        return MoviesRepo(mds)
    }

    @Provides
    @Singleton
    fun provideDataSource(collectionReference: CollectionReference):MoviesDataSource {
        return MoviesDataSource(collectionReference)
    }
/*
    @Provides
    @Singleton
    fun provideMoviesDao(@ApplicationContext context: Context):MoviesDao {
        val db = Room.databaseBuilder(context,MyDatabase::class.java,"filmler_app.sqlite")
            .createFromAsset("filmler_app.sqlite").build()
        return db.getMoviesDao()
    }

    @Provides
    @Singleton
    fun provideMoviesDao() : RetroMoviesDao{
        return ApiUtils.getFilmlerDao()
    }
    */

    @Provides
    @Singleton
    fun provideCollectionReference():CollectionReference {
        return Firebase.firestore.collection("Movies")
    }

}