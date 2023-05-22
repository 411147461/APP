package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

public class shoppingcartNoteModel extends AppCompatActivity {
    private final String title;
    private final String detail;
    private final int image;

    public shoppingcartNoteModel(String title,String detail, int image){
        this.title=title;
        this.detail=detail;
        this.image=image;
    }
        public String gettitle() {return title;}
        public String getDetail(){
        return detail;
    }
        public int getImage(){ return image; }
}
