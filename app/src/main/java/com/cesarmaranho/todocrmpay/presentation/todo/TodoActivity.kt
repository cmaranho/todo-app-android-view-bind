package com.cesarmaranho.todocrmpay.presentation.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cesarmaranho.todocrmpay.databinding.ActivityTodoBinding
import com.cesarmaranho.todocrmpay.presentation.home.MainActivity

class TodoActivity : AppCompatActivity() {

    private lateinit var bind: ActivityTodoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityTodoBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.run {
            topAppBar.setNavigationOnClickListener {
                val intent = Intent(this@TodoActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }

    }
}