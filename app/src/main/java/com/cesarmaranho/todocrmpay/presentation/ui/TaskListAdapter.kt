package com.cesarmaranho.todocrmpay.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cesarmaranho.todocrmpay.databinding.TaskLayoutBinding
import com.cesarmaranho.todocrmpay.domain.model.Task


class TaskListAdapter : ListAdapter<Task, TaskListAdapter.SelectTaskViewHolder>(DIFF_CALLBACK) {

    var onClickItem: ((Task) -> Unit)? = null

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Task>() {
            override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem.description == newItem.description
            }

            override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem == newItem
            }
        }
    }

    class SelectTaskViewHolder(
        private val itemBinding: TaskLayoutBinding,
        private val onClickItem: ((Task) -> Unit)?

    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(task: Task) {
            itemBinding.run {
                card.apply {
                    setOnClickListener {
                        onClickItem?.let { callback ->
                            callback(task)
                        }
                    }
                    description.text = task.description
                }
            }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                onClickItem: ((Task) -> Unit)?,
            ): SelectTaskViewHolder {
                val itemBinding = TaskLayoutBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )

                return SelectTaskViewHolder(itemBinding, onClickItem)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectTaskViewHolder {
        return  SelectTaskViewHolder.create(parent, onClickItem)
    }

    override fun onBindViewHolder(holder: SelectTaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}