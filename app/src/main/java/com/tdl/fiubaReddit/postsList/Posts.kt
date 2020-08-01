package com.tdl.fiubaReddit.postsList

import android.os.Bundle
import android.widget.*
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.tdl.fiubaReddit.post.Post
import com.tdl.fiubaReddit.R

class Posts() : AppCompatActivity() {

    private val posts: ArrayList<Post> = Requests.getPosts(this); // arrayListOf(unPost, otroPost, unPost);

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