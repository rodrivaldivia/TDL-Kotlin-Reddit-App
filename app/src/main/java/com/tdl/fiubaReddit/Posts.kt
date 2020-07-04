package com.tdl.fiubaReddit

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class Posts : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        // Load views
        val textTitle: TextView = findViewById(R.id.Title)
        val textBody: TextView = findViewById(R.id.Body)
        val imageView: ImageView = findViewById(R.id.imageView)

        // Create a post
        val unPost = Post("Un gatito", "Esta es una foto de un gatito OwO", getString(R.string.cat_photo1))

        // Display
        textTitle.text = unPost.title
        Glide.with(this).load(unPost.image).into(imageView)
        textBody.text = unPost.text
    }
}