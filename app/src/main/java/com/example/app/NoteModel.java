package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

public class NoteModel extends AppCompatActivity {
    private final String title;
    private final String detail;
    private final int image;

    public NoteModel(String title,String detail, int image){
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