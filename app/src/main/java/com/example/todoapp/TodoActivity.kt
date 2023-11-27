package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.todoapp.databinding.ActivityTodoBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TodoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoBinding
    private val viewModel: TodoViewModel by viewModels()
    private val todoListAdapter by lazy { TodoListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoBinding.inflate(layoutInflater).apply {
            setContentView(root)
            view = this@TodoActivity
            todoRecyclerView.adapter = todoListAdapter
        }

        lifecycleScope.launch {

            viewModel.todoList.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collectLatest {
                    it.forEach { todoEntity ->
                        Log.d("TodoActivity.kt", "$todoEntity")
                    }
                    binding.emptyTextView.isVisible = it.isEmpty()
                    binding.todoRecyclerView.isVisible = it.isNotEmpty()
                    todoListAdapter.submitList(it)
                }
        }
    }

    fun onClickAdd() {
        startActivity(Intent(this, InputActivity::class.java))
    }
}
