package com.tdl.fiubaReddit.adapters

import android.content.Context
import android.content.Intent
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.tdl.fiubaReddit.activitys.PostFullView
import com.tdl.fiubaReddit.post.Post
import com.tdl.fiubaReddit.R
import com.tdl.fiubaReddit.activitys.Comments
import java.lang.Thread.sleep

class PostsAdapter(private val context: Context,
                   private val dataSource: ArrayList<Post>): BaseAdapter() {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //private  val votes:TextView

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = inflater.inflate(R.layout.post_view, parent, false)
        val titleTextView = rowView.findViewById(R.id.post_title) as TextView
        val detailTextView = rowView.findViewById(R.id.post_body) as TextView
        val postImageView = rowView.findViewById(R.id.post_image) as ImageView
        val votes = rowView.findViewById(R.id.postVotes) as TextView

        val post = getItem(position) as Post
        votes.text = post.votes.toString()

        rowView.findViewById<ImageButton>(R.id.upvoteButton).setOnClickListener {
            val mToast = Toast.makeText(context,"upvoted", Toast.LENGTH_SHORT)
            mToast.show()
            post.addVotes();
            votes.setText(post.votes.toString())
        }

        rowView.findViewById<ImageButton>(R.id.downvoteButton).setOnClickListener {
            val mToast = Toast.makeText(context,"downvoted", Toast.LENGTH_SHORT)
            mToast.show()
            post.reduceVotes()
            votes.setText(post.votes.toString())
        }

        rowView.findViewById<ImageButton>(R.id.messageButton).setOnClickListener {
            val intent = Intent(context, Comments::class.java)
            intent.putExtra("Post", post)
            startActivity(context,intent,null)
        }

        rowView.findViewById<Button>(R.id.change_view).setOnClickListener {
            val intent = Intent(context, PostFullView::class.java)
            intent.putExtra("Post", post)
            startActivity(context, intent,null)
        }

        titleTextView.text = post.title
        Glide.with(context).load(post.image).into(postImageView)
        detailTextView.text = post.text
        return rowView
    }

}