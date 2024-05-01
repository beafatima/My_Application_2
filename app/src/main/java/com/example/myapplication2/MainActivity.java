package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView heart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //fav clicked
        heart = findViewById(R.id.heart_border);
        heart.setOnClickListener(v -> openFavorites());
    }
    private void openFavorites(){
        Intent intent = new Intent(this, Favorites.class);
        startActivity(intent);
    }
}