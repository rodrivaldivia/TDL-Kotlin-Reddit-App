package com.tdl.fiubaReddit.activitys

import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import com.tdl.fiubaReddit.R
import com.tdl.fiubaReddit.adapters.PostsAdapter
import com.tdl.fiubaReddit.requests.Requests

class Posts() : AppCompatActivity() {

    private var posts =  Requests.getPostsOFFLINE() // arrayListOf(unPost, otroPost, unPost);

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, NewPost::class.java)
            startActivityForResult(intent, 2)
        }

        val listView = findViewById<ListView>(R.id.posts_list_view)
        val adapter = PostsAdapter(this, posts)
        listView.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 2 ) {
            if (resultCode == RESULT_FIRST_USER) {

                posts = Requests.getPostsOFFLINE()
                println("Result $resultCode, First_User:$RESULT_FIRST_USER")

                val listView = findViewById<ListView>(R.id.posts_list_view)
                val adapter = PostsAdapter(this, posts)
                listView.adapter = adapter
            }
        }
    }


}