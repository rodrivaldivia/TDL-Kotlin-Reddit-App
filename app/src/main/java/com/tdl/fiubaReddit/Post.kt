package com.tdl.fiubaReddit

class Post(val title: String, val text: String? = null, val image: String? = null) {

    var votes: Int = 0

    operator fun unaryPlus() = votes++

    operator fun unaryMinus() = votes--
}
