package com.cesarmaranho.todocrmpay.presentation.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarmaranho.todocrmpay.domain.use_cases.UpdateTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    updateTaskUseCase: UpdateTaskUseCase
): ViewModel() {

    init {

    }

    fun updateTask(text: String) {
        viewModelScope.launch {

        }
    }

}