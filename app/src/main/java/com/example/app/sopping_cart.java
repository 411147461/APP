package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class sopping_cart extends AppCompatActivity {

    ArrayList<shoppingcartNoteModel> noteModels = new ArrayList<>();
    soppingcartRecyerView adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sopping_cart);
        RecyclerView recyclerView = findViewById(R.id.RecyclerViewcart); //與Layout中的元件做綁定
        setUpNoteModel();
        adapter = new soppingcartRecyerView(this, noteModels);  //引用我們寫好的Adapter
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpNoteModel() {
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("TITLE");
        String detail = bundle.getString("DETAIL");
        int Image = bundle.getInt("IMAGE");
        int count = bundle.getInt("count");

        noteModels.add(new shoppingcartNoteModel(title, detail,Image));
    }
}