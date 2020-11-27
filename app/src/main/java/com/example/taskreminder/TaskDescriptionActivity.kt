package com.example.taskreminder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.app.Activity
import android.content.Intent
import android.widget.EditText

class TaskDescriptionActivity : AppCompatActivity() {
    companion object {
        val EXTRA_TASK_DESCRIPTION = "task"
    }

    private lateinit var descriptionText: EditText
    //descriptionText = view.findViewById(R.id.descriptionText)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_description)
    }

    fun doneClicked(view: View) {
        val taskDescription = descriptionText.text.toString()
        if (!taskDescription.isEmpty()) {
            val result = Intent()
            result.putExtra(EXTRA_TASK_DESCRIPTION, taskDescription)
            setResult(Activity.RESULT_OK, result)
        } else {
            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }
}