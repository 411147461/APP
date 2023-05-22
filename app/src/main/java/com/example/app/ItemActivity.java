package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("TITLE");
        String detail = bundle.getString("DETAIL");
        int Image = bundle.getInt("IMAGE");
        TextView titleTextView = findViewById(R.id.Title);
        TextView detailTextView = findViewById(R.id.Detail);
        ImageView imageView = findViewById(R.id.imageView);
        titleTextView.setText(title);
        detailTextView.setText(detail);
        imageView.setImageResource(Image);
    }
}