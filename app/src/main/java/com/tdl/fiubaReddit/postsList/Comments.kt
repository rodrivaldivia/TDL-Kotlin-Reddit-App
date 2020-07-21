package com.tdl.fiubaReddit.postsList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


import com.tdl.fiubaReddit.R

class Comments : AppCompatActivity() {

    private var comment: EditText? = null
    private lateinit var comments: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_comments)
        findViewById<Button>(R.id.sendButton).setOnClickListener {
            val mToast = Toast.makeText(this,"posted", Toast.LENGTH_SHORT)
            mToast.show()
            getComment()
        }
        comment = findViewById<EditText>(R.id.editTextTextMultiLine)

    }

    private fun getComment() {
        updateComments()
        comment?.setText("")
    }

    private fun updateComments() {
        val textView:TextView = findViewById<TextView>(R.id.commentView)
        textView.text = comment?.text.toString() //ToDo modificar
    }
}