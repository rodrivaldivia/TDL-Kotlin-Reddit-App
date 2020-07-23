package com.tdl.fiubaReddit.postsList


import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.tdl.fiubaReddit.R
import com.tdl.fiubaReddit.post.Post
import kotlinx.android.synthetic.main.list_comment.*
import java.util.*

class Comments : AppCompatActivity() {

    private lateinit var comment: EditText
    private var commentsSize = 1

    private val unComment = UserComment(
        "Un gatito",
        "Esta es una foto de un gatito OwO",
        "https://www.pinclipart.com/picdir/big/193-1931067_pixel-clipart-finn-50-x-50-px-png.png"
    )
    private val otroComment = UserComment(
        "Otro gatito",
        "Esta es otra foto de un gatito OwO",
        "https://www.pinclipart.com/picdir/big/193-1931067_pixel-clipart-finn-50-x-50-px-png.png"
    )

    private var comments:  Vector<UserComment> = Vector<UserComment>(1,1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_comments)

        findViewById<Button>(R.id.sendButton).setOnClickListener {
            val mToast = Toast.makeText(this,"posted", Toast.LENGTH_SHORT)
            mToast.show()
            getComment()
        }
        comment = findViewById<EditText>(R.id.editTextTextMultiLine)

    }

    private fun getComment() {
        if(comment.text.toString() != ""){
            comments.ensureCapacity(commentsSize);
            comments.add(UserComment("anonimo",comment.text.toString(),"https://www.pinclipart.com/picdir/big/193-1931067_pixel-clipart-finn-50-x-50-px-png.png"))
            updateComments()
            commentsSize++
            comment.setText("")
        }
    }

    private fun updateComments() {
        val listView = findViewById<ListView>(R.id.commentView)
        val adapter = CommentsAdapter(this, comments)
        listView.adapter = adapter
    }
}