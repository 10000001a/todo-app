package com.example.todoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class TodoActivity : AppCompatActivity() {
    private lateinit var todoRecyclerViewLayoutManager: LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        todoRecyclerViewLayoutManager = LinearLayoutManager(this@TodoActivity)

        findViewById<RecyclerView>(R.id.todo_recycler_view).apply {
            adapter =
                TodoAdapter(
                    ArrayList((0 until 40).map { Todo(it.toString(), false) }),
                )
            layoutManager = todoRecyclerViewLayoutManager
        }
    }
}

class TodoAdapter(private val dataSet: ArrayList<Todo>) :
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.todo_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.view.findViewById<TextView>(R.id.todo_name).text = dataSet[position].title
    }

    override fun getItemCount() = dataSet.size
}