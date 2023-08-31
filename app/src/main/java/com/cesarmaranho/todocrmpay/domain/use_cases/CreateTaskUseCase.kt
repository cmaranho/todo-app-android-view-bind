package com.cesarmaranho.todocrmpay.domain.use_cases

import com.cesarmaranho.todocrmpay.data.AppDao
import com.cesarmaranho.todocrmpay.domain.model.Task
import javax.inject.Inject

class CreateTaskUseCase @Inject constructor(
    private val appDao: AppDao,
) {

    suspend operator fun invoke(task: Task) {
        appDao.createTask(task.toTaskEntity())
    }

}