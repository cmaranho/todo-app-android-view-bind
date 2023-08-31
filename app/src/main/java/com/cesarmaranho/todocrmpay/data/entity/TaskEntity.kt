package com.cesarmaranho.todocrmpay.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cesarmaranho.todocrmpay.domain.model.Task
import java.util.Date

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val description: String,
    @ColumnInfo(defaultValue = "('Created at')")
    val createAt: Date = Date()

) {
    fun toTask(): Task {
        return Task(
            description = description,
            createAt = createAt
        )
    }
}
