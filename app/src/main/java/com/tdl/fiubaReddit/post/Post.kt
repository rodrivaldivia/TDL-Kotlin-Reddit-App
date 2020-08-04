package com.tdl.fiubaReddit.post

import java.io.Serializable
import java.util.*

class Post(val title: String, val text: String? = null, val image: String? = null, val postId: Int) : Serializable{

    var comments: Vector<UserComment> = Vector<UserComment>(1,1)

    var votes: Int = 0

    operator fun unaryPlus() = votes++

    operator fun unaryMinus() = votes--

}
