package com.tdl.fiubaReddit.activitys

import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.tdl.fiubaReddit.post.Post
import com.tdl.fiubaReddit.R
import com.tdl.fiubaReddit.postsList.PostsAdapter

class Posts() : AppCompatActivity() {

    //private val nada: Unit = Requests.postPost(this,"un titulo","un texto","https://i.imgur.com/F0cpTWT.jpg")
    private val posts: ArrayList<Post> = Requests.getPostsOFFLINE(); // getPosts(this)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, NewPost::class.java)
            ContextCompat.startActivity(this, intent, null)

            /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()*/
        }
        val listView = findViewById<ListView>(R.id.posts_list_view);
        val adapter = PostsAdapter(this, posts)
        listView.adapter = adapter
    }


}