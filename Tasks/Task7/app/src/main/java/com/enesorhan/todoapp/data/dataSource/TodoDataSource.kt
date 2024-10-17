package com.enesorhan.todoapp.data.dataSource

import com.enesorhan.todoapp.data.entity.ToDo
import com.enesorhan.todoapp.room.TodoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoDataSource(val todoDao: TodoDao) {

    suspend fun allData() : List<ToDo> = withContext(Dispatchers.IO){
        return@withContext todoDao.getAllToDo()
    }

    suspend fun searchData(search: String) : List<ToDo> = withContext(Dispatchers.IO){
        return@withContext todoDao.getContnsSWrd(search)
    }

    suspend fun insertData(todo_name:String) = withContext(Dispatchers.IO){
        val todo = ToDo(0,todo_name)
        return@withContext todoDao.insertToDo(todo)
    }

    suspend fun updateData(todo_id: Int,todo_name: String) = withContext(Dispatchers.IO){
        val todo = ToDo(todo_id,todo_name)
        return@withContext todoDao.updateToDo(todo)
    }

    suspend fun deleteData(todo_id: Int) = withContext(Dispatchers.IO){
        val todo = ToDo(todo_id,"")
        return@withContext todoDao.deleteToDo(todo)
    }


}