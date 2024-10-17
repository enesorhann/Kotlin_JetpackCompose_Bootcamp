package com.enesorhan.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.enesorhan.todoapp.data.entity.ToDo

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo")
    suspend fun getAllToDo() : List<ToDo>

    @Query("SELECT * FROM todo WHERE name like '%' || :searchedWord || '%' ")
    suspend fun getContnsSWrd(searchedWord:String) : List<ToDo>

    @Insert
    suspend fun insertToDo(toDo: ToDo)

    @Update
    suspend fun updateToDo(toDo: ToDo)

    @Delete
    suspend fun deleteToDo(toDo: ToDo)
}