package com.example.todoapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.todoapp.databinding.ActivityInputBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
            text: CharSequence?, _: Int, _: Int, _: Int
        ) {
            Log.d("InputActivity", "title: $text")
            viewModel.setTitle(
                text.toString()
            )
        })

        binding.addTodoDescriptionEditText.addTextChangedListener(onTextChanged = fun(
            text: CharSequence?,
            _: Int,
            _: Int,
            _: Int
        ) {
            Log.d("InputActivity", "description: $text")
            viewModel.setDescription(text.toString())
        })


        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    when {
                        it.success -> {
                            Toast.makeText(this@InputActivity, "완료", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    }
                }
            }
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}