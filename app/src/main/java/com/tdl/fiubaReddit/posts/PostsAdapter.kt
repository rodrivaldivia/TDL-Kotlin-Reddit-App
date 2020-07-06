package com.tdl.fiubaReddit.posts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.tdl.fiubaReddit.Post
import com.tdl.fiubaReddit.R

class PostsAdapter(private val context: Context,
                   private val dataSource: ArrayList<Post>): BaseAdapter() {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

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

        val post = getItem(position) as Post
        titleTextView.text = post.title
        Glide.with(context).load(post.image).into(postImageView)
        detailTextView.text = post.text
        return rowView
    }
}