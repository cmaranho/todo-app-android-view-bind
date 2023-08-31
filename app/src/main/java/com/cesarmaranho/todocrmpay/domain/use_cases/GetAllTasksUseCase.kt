package com.cesarmaranho.todocrmpay.domain.use_cases

import com.cesarmaranho.todocrmpay.data.AppDao
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllTasksUseCase @Inject constructor(
    private val appDao: AppDao,
) {

     operator fun invoke() = flow {
        appDao.getAllTasks().collect { task ->
            emit(task.map { item -> item.toTask() })
        }
    }

}