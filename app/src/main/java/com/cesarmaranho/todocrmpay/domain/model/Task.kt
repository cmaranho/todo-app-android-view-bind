package com.cesarmaranho.todocrmpay.domain.model

import com.cesarmaranho.todocrmpay.data.entity.TaskEntity
import java.util.Date

data class Task(
    val description: String,
    val createAt: Date? = null
) {
    fun toTaskEntity(): TaskEntity {
        return TaskEntity(
            description = description
        )
    }
}
