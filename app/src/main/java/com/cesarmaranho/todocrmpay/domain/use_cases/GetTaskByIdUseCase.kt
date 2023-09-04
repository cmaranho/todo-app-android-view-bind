package com.cesarmaranho.todocrmpay.domain.use_cases

import com.cesarmaranho.todocrmpay.data.AppDao
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTaskByIdUseCase @Inject constructor(
    private val appDao: AppDao
) {

    operator fun invoke(id: Int) = flow {
        appDao.getTaskById(id).collect { task ->
            emit(task.toTask())
        }
    }
}