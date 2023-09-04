package com.cesarmaranho.todocrmpay.presentation.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.cesarmaranho.todocrmpay.databinding.ActivityMainBinding
import com.cesarmaranho.todocrmpay.domain.model.Task
import com.cesarmaranho.todocrmpay.presentation.todo.TodoActivity
import com.cesarmaranho.todocrmpay.presentation.ui.TaskListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var bind: ActivityMainBinding
    private lateinit var taskListAdapter: TaskListAdapter

    private val taskList = Observer<List<Task>> { tasks ->
        taskListAdapter.submitList(tasks)
    }

    private fun openEditTodo() {
        val intent = Intent(this@MainActivity, TodoActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        taskListAdapter = TaskListAdapter().apply {
            onClickItem = { task ->
                openEditTodo()
            }
        }

        bind.run {
            addTask.setOnClickListener {
                viewModel.createTask()
                openEditTodo()
            }

            taskList.apply {
                layoutManager = GridLayoutManager(context, 2)
                adapter = taskListAdapter
            }

            taskListAdapter.submitList(emptyList())
        }

        viewModel.taskList.observe(this, taskList)
    }
}