package com.cesarmaranho.todocrmpay.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarmaranho.todocrmpay.domain.model.Task
import com.cesarmaranho.todocrmpay.domain.use_cases.CreateTaskUseCase
import com.cesarmaranho.todocrmpay.domain.use_cases.GetAllTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val createTaskUseCase: CreateTaskUseCase,
    private val getAllTasksUseCase: GetAllTasksUseCase
) : ViewModel() {

    fun createTask() {
        viewModelScope.launch {
            createTaskUseCase(Task(description = "Título"))
        }
    }

    fun getAll() {
        viewModelScope.launch {

        }
    }
}