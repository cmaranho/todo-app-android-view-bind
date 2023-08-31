package com.cesarmaranho.todocrmpay.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarmaranho.todocrmpay.domain.model.Task
import com.cesarmaranho.todocrmpay.domain.use_cases.CreateTaskUseCase
import com.cesarmaranho.todocrmpay.domain.use_cases.GetAllTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val createTaskUseCase: CreateTaskUseCase,
    private val getAllTasksUseCase: GetAllTasksUseCase
) : ViewModel() {

    private var _taskList = MutableLiveData<List<Task>>(emptyList())
    val taskList: LiveData<List<Task>> = _taskList

    init {
        getAll()
    }

    fun createTask() {
        viewModelScope.launch {
            createTaskUseCase(Task(description = "Título"))
        }
    }

    private fun getAll() {

        getAllTasksUseCase()
            .onEach { list ->
            _taskList.value = list
        }.launchIn(viewModelScope)

    }
}