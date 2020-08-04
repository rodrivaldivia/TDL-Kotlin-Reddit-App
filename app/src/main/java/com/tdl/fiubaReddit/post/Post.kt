package com.tdl.fiubaReddit.post

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.tdl.fiubaReddit.postsList.UserComment
import java.io.Serializable
import java.util.*

class Post(val title: String, val text: String? = null, val image: String? = null) : Serializable{

    var comments: Vector<UserComment> = Vector<UserComment>(1,1)

    var votes: Int = 0

    operator fun unaryPlus() = votes++

    operator fun unaryMinus() = votes--

}
