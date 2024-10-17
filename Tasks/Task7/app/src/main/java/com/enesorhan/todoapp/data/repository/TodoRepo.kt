package com.enesorhan.todoapp.data.repository

import com.enesorhan.todoapp.data.dataSource.TodoDataSource
import com.enesorhan.todoapp.data.entity.ToDo

class TodoRepo(val todoDS: TodoDataSource) {

    suspend fun allData():List<ToDo> = todoDS.allData()
    suspend fun searchData(searchedWord:String):List<ToDo> = todoDS.searchData(searchedWord)
    suspend fun insertData(todo_name:String) = todoDS.insertData(todo_name)
    suspend fun updateData(todo_id: Int,todo_name: String)= todoDS.updateData(todo_id, todo_name)
    suspend fun deleteData(todo_id: Int)= todoDS.deleteData(todo_id)

}