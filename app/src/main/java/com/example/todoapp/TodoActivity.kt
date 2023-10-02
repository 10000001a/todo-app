package com.example.todoapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        findViewById<RecyclerView>(R.id.todo_recycler_view).also { it ->
            it.adapter =
                TodoAdapter(
                    ArrayList((0 until 40).map { number -> "" + number + "번 할일" }),
                    this@TodoActivity.layoutInflater
                )

            it.layoutManager = LinearLayoutManager(this@TodoActivity)
        }
    }
}

class TodoAdapter(
    private val itemList: ArrayList<String>,
    private val inflater: LayoutInflater
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val todoNameView: TextView

        init {
            todoNameView = itemView.findViewById(R.id.todo_name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        Log.d("Test", "viewType$viewType")
        return TodoViewHolder(inflater.inflate(R.layout.todo_item, parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        Log.d("Test", "position: " + position + "  text: " + holder.todoNameView.text.toString())
        holder.todoNameView.text = itemList[position]
    }
}