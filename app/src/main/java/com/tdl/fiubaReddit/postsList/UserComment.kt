package com.tdl.fiubaReddit.postsList

import java.io.Serializable

private const val DEFAULT_IMAGE = "https://www.pinclipart.com/picdir/big/193-1931067_pixel-clipart-finn-50-x-50-px-png.png"

data class UserComment (val username: String , val text: String? = "", val userImage: String? = DEFAULT_IMAGE) :
    Serializable {
}
