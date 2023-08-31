package com.cesarmaranho.todocrmpay.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cesarmaranho.todocrmpay.databinding.TaskLayoutBinding
import com.cesarmaranho.todocrmpay.domain.model.Task


class TaskListAdapter : ListAdapter<Task,
        TaskListAdapter.SelectSettignsViewHolder>(DIFF_CALLBACK) {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectSettignsViewHolder {
        return SelectSettignsViewHolder.create(parent, onClickItem)
    }

    override fun onBindViewHolder(holder: SelectSettignsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class SelectSettignsViewHolder(
        private val itemBinding: TaskLayoutBinding,
        private val onClickItem: ((Task) -> Unit)?,
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(task: Task) {
            itemBinding.run {
                card.apply {
                    setOnClickListener {
                        onClickItem?.let { it1 -> it1(task) }
                    }
                    description.text = task.description
                }
            }
        }

        companion object {
            fun create(
                parent: ViewGroup,
                onClickItem: ((Task) -> Unit)?,
            ): SelectSettignsViewHolder {

                val itemBinding = TaskLayoutBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )

                return SelectSettignsViewHolder(itemBinding, onClickItem)
            }
        }

    }
}