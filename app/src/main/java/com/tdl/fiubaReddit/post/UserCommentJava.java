package com.tdl.fiubaReddit.post;


public class UserCommentJava {

    private String username = "";
    private String text = "";
    private String userImage = "https://www.pinclipart.com/picdir/big/193-1931067_pixel-clipart-finn-50-x-50-px-png.png";

   public String getUsername(){
       return  username;
   }

   public String getUserText(){
       return text;
   }

   public String getUserImage(){
       return userImage;
   }

   public void setUsername(String newUsername){
       username = newUsername;
   }

   public void setUserText(String newText){
       text = newText;
   }

   public void setUserImage(String newUserImage){
       userImage = newUserImage;
   }

   @Override public boolean equals(Object object){
       if(this == object) return true;

       if(object == null || getClass() != object.getClass()) return false;

       UserCommentJava comment = (UserCommentJava) object;
       if(username != null && comment.getUsername()!= null && username != comment.getUsername()) return false;
       if(text != null && comment.getUserText()!= null && text != comment.getUserText()) return false;
       if(userImage != null && comment.getUserImage()!= null && userImage != comment.getUserImage()) return false;
       return true;
   }

   @Override public int hashCode(){
       int result = username != null ? username.hashCode():0;
       result = 31*result+(text != null ? text.hashCode():0);
       result = 31*result+(userImage != null ? userImage.hashCode():0);
       return  result;
   }

   @Override public String toString(){
       return "UserCommentJava{" +
               "name=" + username +
               ",text=" + text +
               ",Image = " + userImage + '}';
   }

}
