package com.tdl.fiubaReddit.postsList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.tdl.fiubaReddit.R
import java.util.*

class CommentsAdapter(private val context: Context, private val dataSource: Vector<UserComment>): BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

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
        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_comment, parent, false)
        // Get title element
        val usernameTextView = rowView.findViewById(R.id.username) as TextView

        // Get subtitle element
        val commentTextView = rowView.findViewById(R.id.userComment) as TextView

        // Get thumbnail element
        val userImageView = rowView.findViewById(R.id.userImage) as ImageView

        val comment = getItem(position) as UserComment


        usernameTextView.text = comment.username
        commentTextView.text = comment.text

        Glide.with(context).load(comment.userImage).into(userImageView)

        return rowView
    }

}