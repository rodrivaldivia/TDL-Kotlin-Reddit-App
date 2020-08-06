package com.tdl.fiubaReddit.activitys


import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.tdl.fiubaReddit.R
import com.tdl.fiubaReddit.post.Post
import com.tdl.fiubaReddit.adapters.CommentsAdapter
import com.tdl.fiubaReddit.post.UserComment
import com.tdl.fiubaReddit.requests.Requests
import kotlinx.android.synthetic.main.app_comments.*
import java.util.*

const val EMPTY_COMMENT = ""

class Comments : AppCompatActivity() {

    private var comments = Vector<UserComment>()

    private var postId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_comments)

        val post = intent.getSerializableExtra("Post") as Post
        postId = post.postId
        comments = post.comments

        sendButton.setOnClickListener {
            val mToast = Toast.makeText(this,"posted", Toast.LENGTH_SHORT)
            mToast.show()
            getComment()
        }

        val adapter = CommentsAdapter(this, comments)
        commentView.adapter = adapter

    }

    private fun getComment() {
        if(!editTextTextMultiLine.text.isNullOrEmpty()){
            val userCom = UserComment(
                getUsername(),
                editTextTextMultiLine.text.toString(),
                getUserImage()
            )

            Requests.addComment(userCom, postId)
            comments.add(userCom)
            updateComments()
            editTextTextMultiLine.setText(EMPTY_COMMENT)
        }
    }

    private fun getUserImage(): String? {
        return "https://www.pinclipart.com/picdir/big/193-1931067_pixel-clipart-finn-50-x-50-px-png.png" //ToDO: pedir del server
    }

    private fun getUsername(): String {
        return "anonimo" //ToDO: pedir del server
    }

    private fun updateComments() {

        val adapter = CommentsAdapter(this, comments)
        commentView.adapter = adapter
    }
}