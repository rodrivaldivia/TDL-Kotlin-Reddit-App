package com.tdl.fiubaReddit.activitys.addPost

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tdl.fiubaReddit.R
import com.tdl.fiubaReddit.requests.Requests
import kotlinx.android.synthetic.main.activity_new_post.*

/*class NewPost : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)

        button.setOnClickListener {

            val title = post_title.text.toString()
            val body = post_description.text.toString()
            val image = post_image_url.text.toString()

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