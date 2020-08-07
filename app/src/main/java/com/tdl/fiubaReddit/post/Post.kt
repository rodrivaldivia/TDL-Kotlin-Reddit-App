package com.tdl.fiubaReddit.post

import java.io.Serializable
import java.util.*

class Post(val title: String, val text: String? = null, val image: String? = null, val postId: Int) : Serializable{

    var comments: Vector<UserComment> = Vector<UserComment>(1,1)

    var votes: Int = Random().nextInt(1000)-500

    private var upVoteWasClicked = false;
    private var downVoteWasClicked = false;


    fun addVotes(){
        if(downVoteWasClicked){
            votes++
            downVoteWasClicked = false
        }else{
            if(upVoteWasClicked){
                votes--
                upVoteWasClicked = false
            }else{
                votes++
                upVoteWasClicked = true
            }
        }


    }

     fun reduceVotes(){
         if(upVoteWasClicked){
             votes--
             upVoteWasClicked = false
         }else{
             if(downVoteWasClicked){
                 votes++
                 downVoteWasClicked = false
             }else{
                 votes--
                 downVoteWasClicked = true
             }
         }
     }

}
