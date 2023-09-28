package com.example.todoapp

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        val container = findViewById<LinearLayout>(R.id.todo_container)

        for (i in 0 until 20) {
            val todoItemView =
                this@TodoActivity.layoutInflater.inflate(R.layout.todo_item, null)

            todoItemView.findViewById<TextView>(R.id.todo_name)
                .also { it.text = "" + i + "번 할일" }

            container.addView(todoItemView)
        }
    }
}