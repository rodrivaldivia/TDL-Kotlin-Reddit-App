package com.tdl.fiubaReddit.postsList


import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.tdl.fiubaReddit.R
import java.util.*

const val EMPTY_COMMENT = ""

class Comments : AppCompatActivity() {

    private lateinit var comment: EditText
    private var commentsSize = 1

    private var comments:  Vector<UserComment> = Vector<UserComment>(1,1)

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
        if(comment.text.toString() != EMPTY_COMMENT){
            comments.ensureCapacity(commentsSize);
            comments.add(UserComment(getUsername(),comment.text.toString(), getUserImage()))
            updateComments()
            comment.setText(EMPTY_COMMENT)
        }
    }

    private fun getUserImage(): String? {
        return "https://www.pinclipart.com/picdir/big/193-1931067_pixel-clipart-finn-50-x-50-px-png.png"
    }

    private fun getUsername(): String {
        return "anonimo" //ToDO: pedir del server
    }

    private fun updateComments() {
        commentsSize++
        val listView = findViewById<ListView>(R.id.commentView)
        val adapter = CommentsAdapter(this, comments)
        listView.adapter = adapter
    }
}