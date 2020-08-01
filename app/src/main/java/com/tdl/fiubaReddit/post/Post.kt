package com.tdl.fiubaReddit.post

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

class Post(val title: String, val text: String? = null, val image: String? = null) {

    var votes: Int = 0

    operator fun unaryPlus() = votes++

    operator fun unaryMinus() = votes--

}
