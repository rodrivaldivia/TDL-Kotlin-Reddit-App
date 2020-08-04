package com.tdl.fiubaReddit.activitys

import android.app.VoiceInteractor
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.tdl.fiubaReddit.R
import com.tdl.fiubaReddit.post.Post
import com.tdl.fiubaReddit.post.UserComment
import com.tdl.fiubaReddit.postsList.CommentsAdapter
import java.util.*

class PostFullView : AppCompatActivity() {

    var postId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_full_view)

        val post = intent.getSerializableExtra("Post") as Post
        postId = post.postId

        // Load views
        val textTitle: TextView = findViewById(R.id.post_title)
        val textBody: TextView = findViewById(R.id.post_body)
        val imageView: ImageView = findViewById(R.id.post_image)
        val listView = findViewById<ListView>(R.id.commentView)

        // Display

        val adapter = CommentsAdapter(this, post.comments)
        listView.adapter = adapter

        textTitle.text = post.title
        Glide.with(this).load(post.image).into(imageView)
        textBody.text = post.text

        this.findViewById<ImageView>(R.id.upvoteButton).setOnClickListener {
            val mToast = Toast.makeText(this,"upvoted", Toast.LENGTH_SHORT)
            mToast.show()
            post.unaryPlus();
        }

        this.findViewById<ImageButton>(R.id.downvoteButton).setOnClickListener { view ->
            val mToast = Toast.makeText(this,"downvoted", Toast.LENGTH_SHORT)
            mToast.show()
            post.unaryMinus()
        }

        this.findViewById<ImageButton>(R.id.messageButton).setOnClickListener {
            val intent = Intent(this, Comments::class.java)
            intent.putExtra("Post", post)
            startActivityForResult(intent, 1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val listView = findViewById<ListView>(R.id.commentView)

        if (requestCode == 1) {
            val comments = Requests.getPostComments(postId)

            val adapter = CommentsAdapter(this, comments)
            listView.adapter = adapter
        }
    }
}