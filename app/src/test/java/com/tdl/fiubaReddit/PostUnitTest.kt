package com.tdl.fiubaReddit

import com.tdl.fiubaReddit.post.Post
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PostUnitTest {
    @Test
    fun checkPostTitle() {

        val unPost = Post("My first post",null,null,0)

        assertEquals("My first post", unPost.title)
    }

    @Test
    fun checkGetUpVotes() {

        val unPost = Post("A post",null,null,0)

        unPost.addVotes()

        assertEquals(1, unPost.votes)
    }

    @Test
    fun checkGetDownVotes() {

        val unPost = Post("A post",null,null,0)

        unPost.reduceVotes()
        unPost.reduceVotes()

        assertEquals(-2, unPost.votes)
    }

    @Test
    fun checkGetTextNotNull() {

        val unPost = Post("A post", "Body of the post",null,0)

        assertEquals("Body of the post", unPost.text)
    }

    @Test
    fun checkGetTextNull() {

        val unPost = Post("A post",null,null,0)

        assertEquals(null, unPost.text)
    }

    @Test
    fun checkGetImageNotNull() {

        val unPost = Post(
            "A post",
            "Body of the post",
            "https://i.imgur.com/AHMWTFa.jpeg",
            10
        )

        assertEquals("https://i.imgur.com/AHMWTFa.jpeg", unPost.image)
    }

    @Test
    fun checkGetImageNull() {

        val unPost = Post("A post",null,null,0)

        assertEquals(null, unPost.image)
    }
}