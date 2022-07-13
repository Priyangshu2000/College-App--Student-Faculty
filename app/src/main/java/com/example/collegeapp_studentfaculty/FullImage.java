package com.example.collegeapp_studentfaculty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

public class FullImage extends AppCompatActivity {
PhotoView imageView;
//    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        imageView=findViewById(R.id.fullimageView);

        String imageUrl=getIntent().getStringExtra("imageUrl");
        Picasso.get().load(imageUrl).into(imageView);
    }
}