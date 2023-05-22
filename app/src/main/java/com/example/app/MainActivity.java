package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {


    ArrayList<NoteModel> noteModels = new ArrayList<>();
    Note_RecyclerViewAdapter adapter;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView); //與Layout中的元件做綁定
        setUpNoteModel();
        adapter = new Note_RecyclerViewAdapter(this, noteModels,this);  //引用我們寫好的Adapter
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpNoteModel() {
        String[] title = getResources().getStringArray(R.array.note_title_text);
        String[] detail = getResources().getStringArray(R.array.note_detail_text);
        int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.images3, R.drawable.images4,R.drawable.images5};

        for (int i = 0; i < title.length; i++ ) {
            noteModels.add(new NoteModel(title[i], detail[i],images[i]));
        }
    }

    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(MainActivity.this, ItemActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", noteModels.get(position).gettitle());
        bundle.putString("DETAIL", noteModels.get(position).getDetail());
        bundle.putInt("IMAGE",noteModels.get(position).getImage());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(int position) {
        noteModels.remove(position);
        adapter.notifyItemRemoved(position);
    }
    @Override
    public void onButtonClick(int position){
        Intent intent = new Intent(MainActivity.this, sopping_cart.class);
        Bundle bundle = new Bundle();
        bundle.putInt("count",count);
        bundle.putString("TITLE", noteModels.get(position).gettitle());
        bundle.putString("DETAIL", noteModels.get(position).getDetail());
        bundle.putInt("IMAGE",noteModels.get(position).getImage());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}