package com.enesorhan.contactsapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import com.enesorhan.contactsapp.data.dataSource.KisilerDataSource
import com.enesorhan.contactsapp.data.repo.KisilerRepository
import com.enesorhan.contactsapp.retrofit.ApiUtils
import com.enesorhan.contactsapp.retrofit.RetrofitPersonsDao
import com.enesorhan.contactsapp.room.MyDatabase
import com.enesorhan.contactsapp.room.PersonsDao
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
    fun provideKisilerRepository(kds:KisilerDataSource) : KisilerRepository{
        return  KisilerRepository(kds)
    }
    @Provides
    @Singleton
    fun provideKisilerDataSource(collectionReference: CollectionReference) : KisilerDataSource{
        return  KisilerDataSource(collectionReference)
    }
/*
    @Provides
    @Singleton
    fun providePersonsDao(@ApplicationContext context: Context) : PersonsDao{
        val vt = Room.databaseBuilder(context,MyDatabase::class.java,"rehber.sqlite")
            .fallbackToDestructiveMigration()
            .createFromAsset("rehber.sqlite").build()
        return  vt.getPersonsDao()  }

    @Provides
    @Singleton
    fun provideRetroPersonsDao() : RetrofitPersonsDao{
        return ApiUtils.getRetroDao()
    }
 */
    @Provides
    @Singleton
    fun provideCollectionReference() : CollectionReference{
        return  Firebase.firestore.collection("Persons")
    }


}