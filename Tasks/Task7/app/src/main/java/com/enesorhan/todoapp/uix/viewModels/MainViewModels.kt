package com.enesorhan.todoapp.uix.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enesorhan.todoapp.data.entity.ToDo
import com.enesorhan.todoapp.data.repository.TodoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModels @Inject constructor(private val todoRepo: TodoRepo) : ViewModel() {
    var toDoList = MutableLiveData<List<ToDo>>()

    init {
        getAllToDo()
    }

    fun getAllToDo(){
        CoroutineScope(Dispatchers.Main).launch {
            toDoList.value = todoRepo.allData()
        }
    }

    fun searchToDo(searchedWord:String){
        CoroutineScope(Dispatchers.Main).launch {
            toDoList.value = todoRepo.searchData(searchedWord)
        }
    }

    fun deleteToDo(id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            todoRepo.deleteData(id)
            getAllToDo()
        }
    }

}