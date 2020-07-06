package com.tdl.fiubaReddit

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Post(val title: String, val text: String? = null, val image: String? = null) {

    var votes: Int = 0

    operator fun unaryPlus() = votes++

    operator fun unaryMinus() = votes--

}
