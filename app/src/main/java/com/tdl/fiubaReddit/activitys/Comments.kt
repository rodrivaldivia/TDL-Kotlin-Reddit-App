package com.tdl.fiubaReddit.activitys


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.tdl.fiubaReddit.R
import com.tdl.fiubaReddit.post.Post
import com.tdl.fiubaReddit.postsList.CommentsAdapter
import com.tdl.fiubaReddit.post.UserComment
import java.util.*

const val EMPTY_COMMENT = ""

class Comments : AppCompatActivity() {

    private lateinit var comment: EditText

    private var comments = Vector<UserComment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_comments)

        val post = intent.getSerializableExtra("Post") as Post

        comments = Requests.getPostComments(0)

        findViewById<Button>(R.id.sendButton).setOnClickListener {
            val mToast = Toast.makeText(this,"posted", Toast.LENGTH_SHORT)
            mToast.show()
            getComment()
        }

        comment = findViewById<EditText>(R.id.editTextTextMultiLine)

        val listView = findViewById<ListView>(R.id.commentView)
        val adapter = CommentsAdapter(this, comments)
        listView.adapter = adapter

    }

    private fun getComment() {
        if(comment.text.toString() != EMPTY_COMMENT){
            val userCom = UserComment(
                getUsername(),
                comment.text.toString(),
                getUserImage()
            )

            Requests.addComment(userCom, 0)
            updateComments()
            comment.setText(EMPTY_COMMENT)
        }
    }

    private fun getUserImage(): String? {
        return "https://www.pinclipart.com/picdir/big/193-1931067_pixel-clipart-finn-50-x-50-px-png.png" //ToDO: pedir del server
    }

    private fun getUsername(): String {
        return "anonimo" //ToDO: pedir del server
    }

    private fun updateComments() {
        val listView = findViewById<ListView>(R.id.commentView)

        comments = Requests.getPostComments(0)
        val adapter = CommentsAdapter(this, comments)
        listView.adapter = adapter
    }
}

/*class Comments : AppCompatActivity() {

    private lateinit var comment: EditText

    var comments = Vector<UserComment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_comments)

        comments = intent.getSerializableExtra("PostComments") as Vector<UserComment>

        val mToast = Toast.makeText(this,"posted", Toast.LENGTH_SHORT)

        comment = findViewById<EditText>(R.id.editTextTextMultiLine)

        findViewById<Button>(R.id.sendButton).setOnClickListener {
            if (comment.text.toString() != EMPTY_COMMENT) {

                val intent = Intent()

                mToast.show()
                getComment()

                setResult(Activity.RESULT_CANCELED, intent)

                intent.putExtra("Commented", comments)
                finish()
            }
        }

        val listView = findViewById<ListView>(R.id.commentView)
        val adapter = CommentsAdapter(this, comments)

        listView.adapter = adapter

    }

    private fun getComment() {
        if(comment.text.toString() != EMPTY_COMMENT){
            val userCom = UserComment(
                getUsername(),
                comment.text.toString(),
                getUserImage()
            )

            comments.add(userCom)
            Requests.addComment(userCom, 0)

            updateComments()
            comment.setText(EMPTY_COMMENT)
        }
    }

    private fun getUserImage(): String? {
        return "https://www.pinclipart.com/picdir/big/193-1931067_pixel-clipart-finn-50-x-50-px-png.png" //ToDO: pedir del server
    }

    private fun getUsername(): String {
        return "anonimo" //ToDO: pedir del server
    }

    private fun updateComments() {
        val listView = findViewById<ListView>(R.id.commentView)
        val adapter = CommentsAdapter(this, comments)

        listView.adapter = adapter
    }
}*/