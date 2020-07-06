package com.tdl.fiubaReddit.posts

import android.os.Bundle
import android.widget.*
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.tdl.fiubaReddit.Post
import com.tdl.fiubaReddit.R

class Posts() : AppCompatActivity() {

    //private var listView: ListView =
    private val unPost = Post(
        "Un gatito",
        "Esta es una foto de un gatito OwO",
        "https://i.imgur.com/F0cpTWT.jpg"
    )
    private val otroPost = Post(
        "Otro gatito",
        "Esta es otra foto de un gatito OwO",
        "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/cute-cat-captions-1563551865.jpg?crop=0.668xw:1.00xh;0.199xw,0&resize=480:*"
    )

    private val posts: ArrayList<Post> = arrayListOf(unPost, otroPost, unPost);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val listView = findViewById<ListView>(R.id.posts_list_view);
        val adapter = PostsAdapter(this, posts)
        listView.adapter = adapter
    }
}