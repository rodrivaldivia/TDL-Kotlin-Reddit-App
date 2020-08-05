package com.tdl.fiubaReddit.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.tdl.fiubaReddit.R

class NewPost : AppCompatActivity() {

    lateinit var mToast: Toast

    lateinit var postTitle: EditText
    lateinit var postBody: EditText
    lateinit var postImageURL: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)

        postTitle = findViewById<EditText>(R.id.post_title)
        postBody = findViewById<EditText>(R.id.post_description)
        postImageURL = findViewById<EditText>(R.id.post_image_url)

        findViewById<Button>(R.id.button).setOnClickListener {

            val title = postTitle.text
            val body = postBody.text
            val image = postImageURL.text

            if (title.isNullOrEmpty() || body.isNullOrEmpty() || image.isNullOrEmpty()) {
                mToast = Toast.makeText(this,"some elements are missing", Toast.LENGTH_SHORT)
                mToast.show()
            } else {
                mToast = Toast.makeText(this,"uploaded \uD83D\uDE09", Toast.LENGTH_SHORT)

                println("Title:$title, Body:$body, Image:$image")
                mToast.show()
                finish()
            }
        }
    }
}