package com.example.todoapp

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import com.example.todoapp.databinding.ActivityInputBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputBinding
    private val viewModel: InputViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater).apply {
            setContentView(root)
            lifecycleOwner = this@InputActivity
            viewModel = this@InputActivity.viewModel
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.addTodoTitleEditText.doOnTextChanged(fun(
            text: CharSequence?,
            _: Int,
            _: Int,
            _: Int
        ) {
            Log.d("InputActivity", "title: $text")
            viewModel.setTitle(
                text.toString()
            )
        })

        binding.addTodoDescriptionEditText.addTextChangedListener(
            onTextChanged = fun(text: CharSequence?, _: Int, _: Int, _: Int) {
                Log.d("InputActivity", "description: $text")
                viewModel.setDescription(text.toString())
            })
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}