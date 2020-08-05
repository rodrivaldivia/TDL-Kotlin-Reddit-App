package com.tdl.fiubaReddit.activitys

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.RequestManager
import com.tdl.fiubaReddit.R
import com.tdl.fiubaReddit.requests.Requests

/*class NewPost : AppCompatActivity() {

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

            val title = postTitle.text.toString()
            val body = postBody.text.toString()
            val image = postImageURL.text.toString()

            if (isAnyStringNullOrEmpty(title, body, image)) {
                Toast.makeText(this,"Oops, you forgot to fill in some fields!", Toast.LENGTH_SHORT).show()
            } else {
                Requests.createPost(title, body, image)

                Toast.makeText(this,"Uploaded king \uD83D\uDE09", Toast.LENGTH_SHORT).show()

                val intent = Intent()
                setResult(RESULT_FIRST_USER, intent)
                finish()
            }
        }
    }
}

fun isAnyStringNullOrEmpty(vararg strings: String?): Boolean {
    for (s in strings) if (s.isNullOrEmpty()) return true
    return false
}*/