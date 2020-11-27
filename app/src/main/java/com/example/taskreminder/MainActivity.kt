package com.example.taskreminder

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter

class MainActivity : AppCompatActivity() {
    private val taskList: MutableList<String> = mutableListOf()
    private val adapter by lazy { makeAdapter(taskList) }
    private val ADD_TASK_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        taskListView.adapter = adapter
        taskListView.onClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->  }
    }

    override fun onActivityResult (requestCode: Int,resultCode: Int,data: Intent?) {
        if (requestCode == ADD_TASK_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                val task = data?.getStringExtra(TaskDescriptionActivity.EXTRA_TASK_DESCRIPTION)
                task?.let {
                    taskList.add(task)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    fun addTaskClicked(view: View) {

    }

    private fun makeAdapter(list: List<String>): ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

    val intent = Intent(this, TaskDescriptionActivity::class.java)
    startActivityForResult(intent, ADD_TASK_REQUEST)
}