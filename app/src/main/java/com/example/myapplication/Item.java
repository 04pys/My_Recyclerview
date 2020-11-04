package com.example.myapplication;

public class Item {
    String topText,bottomText;

    public Item(String topText, String bottomText){
        this.topText = topText;
        this.bottomText = bottomText;
    }
    public String getTopText(){
        return topText;
    }
    public void setTopText(String topText){
        this.topText = topText;
    }
    public String getBottomText(){
        return bottomText;
    }
    public void setBottomText(String bottomText){
        this.bottomText = bottomText;
    }

}
