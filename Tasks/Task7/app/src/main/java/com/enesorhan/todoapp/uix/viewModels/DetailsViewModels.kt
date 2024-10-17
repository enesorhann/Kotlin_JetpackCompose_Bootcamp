package com.enesorhan.todoapp.uix.viewModels

import androidx.lifecycle.ViewModel
import com.enesorhan.todoapp.data.repository.TodoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModels @Inject constructor(val todoRepo: TodoRepo) : ViewModel() {
    fun updateToDo(id: Int,name:String){
        CoroutineScope(Dispatchers.Main).launch {
            todoRepo.updateData(id,name)
        }
    }
}