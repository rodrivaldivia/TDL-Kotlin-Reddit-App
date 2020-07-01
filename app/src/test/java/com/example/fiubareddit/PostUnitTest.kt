package com.example.fiubareddit

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

        val unPost = Post("My first post")

        assertEquals("My first post", unPost.title)
    }

    @Test
    fun checkGetUpVotes() {

        val unPost = Post("A post")

        +unPost

        assertEquals(1, unPost.votes)
    }

    @Test
    fun checkGetDownVotes() {

        val unPost = Post("A post")

        -unPost
        -unPost

        assertEquals(-2, unPost.votes)
    }

    @Test
    fun checkGetTextNotNull() {

        val unPost = Post("A post", "Body of the post")

        assertEquals("Body of the post", unPost.text)
    }

    @Test
    fun checkGetTextNull() {

        val unPost = Post("A post")

        assertEquals(null, unPost.text)
    }

    @Test
    fun checkGetImageNotNull() {

        val unPost = Post("A post", "Body of the post", "https://i.imgur.com/AHMWTFa.jpeg")

        assertEquals("https://i.imgur.com/AHMWTFa.jpeg", unPost.image)
    }

    @Test
    fun checkGetImageNull() {

        val unPost = Post("A post")

        assertEquals(null, unPost.image)
    }
}