package com.example.todo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ImageDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail); // Tạo layout cho activity này

        ImageView imageView = findViewById(R.id.detail_image_view);
        Intent intent = getIntent();
        String imageUriString = intent.getStringExtra("imageUri");

        if (imageUriString != null) {
            Uri imageUri = Uri.parse(imageUriString);
            Glide.with(this).load(imageUri).into(imageView);
        }
    }
}