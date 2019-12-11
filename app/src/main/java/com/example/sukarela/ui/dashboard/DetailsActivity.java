package com.example.sukarela.ui.dashboard;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sukarela.R;

public class DetailsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView name, about;
    String namee, birthh, jobb, aboutt;
    int image;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        imageView = findViewById(R.id.image);
        name = findViewById(R.id.name);

        about = findViewById(R.id.about);
        namee = getIntent().getStringExtra("name");

        aboutt=getIntent().getStringExtra("about");
        image=getIntent().getIntExtra("image",0);
        name.setText(namee);

        about.setText(aboutt);
        imageView.setImageResource(image);


    }
}
