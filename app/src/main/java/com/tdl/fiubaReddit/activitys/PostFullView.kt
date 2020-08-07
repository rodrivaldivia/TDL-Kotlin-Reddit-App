package com.tdl.fiubaReddit.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide
import com.tdl.fiubaReddit.R
import com.tdl.fiubaReddit.post.Post
import com.tdl.fiubaReddit.adapters.CommentsAdapter
import com.tdl.fiubaReddit.requests.Requests
import kotlinx.android.synthetic.main.activity_post_full_view.*

class PostFullView : AppCompatActivity() {

    private var postId = 0
    private lateinit var post: Post

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_full_view)

        post = intent.getSerializableExtra("Post") as Post
        postId = post.postId
        val votes = findViewById<TextView>(R.id.postVotes)

        // Display
        val adapter = CommentsAdapter(this, post.comments)
        commentView.adapter = adapter

        post_title.text = post.title
        Glide.with(this).load(post.image).into(post_image)
        post_body.text = post.text
        votes.text = post.votes.toString()

        upvoteButton.setOnClickListener {
            val mToast = Toast.makeText(this,"upvoted", Toast.LENGTH_SHORT)
            mToast.show()
            post.addVotes();
            votes.setText(post.votes.toString())
        }

        downvoteButton.setOnClickListener { view ->
            val mToast = Toast.makeText(this,"downvoted", Toast.LENGTH_SHORT)
            mToast.show()
            post.reduceVotes()
            votes.setText(post.votes.toString())
        }

        messageButton.setOnClickListener {
            val intent = Intent(this, Comments::class.java)
            intent.putExtra("Post", post)
            startActivityForResult(intent, 1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            val comments = Requests.getPostComments(postId)

            val adapter = CommentsAdapter(this, comments)
            commentView.adapter = adapter
        }
    }
}