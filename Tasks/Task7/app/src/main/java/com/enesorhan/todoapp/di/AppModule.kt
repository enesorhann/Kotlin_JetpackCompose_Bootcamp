package com.enesorhan.todoapp.di

import android.content.Context
import androidx.room.Room
import com.enesorhan.todoapp.data.dataSource.TodoDataSource
import com.enesorhan.todoapp.data.repository.TodoRepo
import com.enesorhan.todoapp.room.MyDatabase
import com.enesorhan.todoapp.room.TodoDao
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
    fun provideDataSource(dao: TodoDao) : TodoDataSource{
        return TodoDataSource(dao)
    }

    @Provides
    @Singleton
    fun provideTodoRepo(todoDS: TodoDataSource) : TodoRepo{
        return TodoRepo(todoDS)
    }
    @Provides
    @Singleton
    fun provideTodoDao(@ApplicationContext context: Context) : TodoDao{
        val db = Room.databaseBuilder(context,MyDatabase::class.java,"todo_task7.sqlite")
            .createFromAsset("todo_task7.sqlite").build()
        return db.getTodoDao()
    }
}