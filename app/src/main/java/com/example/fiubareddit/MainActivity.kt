package com.example.fiubareddit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Specify the layout you are using.
        setContentView(R.layout.activity_main)

        // Load views
        val textTitle: TextView = findViewById(R.id.Title)
        val textBody: TextView = findViewById(R.id.Body)
        val imageView: ImageView = findViewById(R.id.imageView)

        // Create a post
        val unPost = Post("Un gatito", "Esta es una foto de un gatito OwO", "https://i.imgur.com/F0cpTWT.jpg")

        // Display
        textTitle.text = unPost.title
        Glide.with(this).load(unPost.image).into(imageView)
        textBody.text = unPost.text
    }

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }*/
}