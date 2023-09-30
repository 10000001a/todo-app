package com.example.todoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        findViewById<ListView>(R.id.todo_list_view).also {
            it.adapter = TodoListViewAdapter(
                ArrayList((0 until 40).map { "" + it + "번 할일" }),
                layoutInflater
            )
        }
    }
}

class TodoListViewAdapter(
    private val todoList: ArrayList<String>,
    private val layoutInflater: LayoutInflater
) : BaseAdapter() {
    // ListView가 받는 item의 갯수를 반환합니다.
    override fun getCount(): Int {
        return todoList.size
    }

    // ListView의 p0번째 item의 View가 전달받을 값을 반환합니다.
    override fun getItem(p0: Int): String {
        return todoList[p0]
    }

    // ListView의 각 item들은 고유 id를 필요로 하는데, 적절한 값을 반환합니다.
    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    // ListView의 item을 그릴 View를 반환합니다.
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        return layoutInflater.inflate(R.layout.todo_item, null)
            .also { it.findViewById<TextView>(R.id.todo_name).text = getItem(p0) }
    }
}