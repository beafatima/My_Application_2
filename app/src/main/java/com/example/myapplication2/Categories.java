package com.example.myapplication2;

import android.content.Intent;
import android.media.audiofx.AudioEffect;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class Categories extends AppCompatActivity {

    CategoriesBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = CategoriesBinding.inflate(getLayoutInflater());

        int[] imageList = {R.drawable.tops, R.drawable.jeans, R.drawable.denim};
        String[] descriptionList = {"Description"};
        String[] nameList = {"Item 1", "Item 2", "Item 3"};

        for (int i = 0; i < imageList.length; i++){
            listData = new ListData(nameList[i], descriptionList[i], imageList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(Categories.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.setClickable(true);

        binding.listview.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(Categories.this, AudioEffect.Descriptor.class);
            intent.putExtra("name", nameList[i]);
            intent.putExtra("description", descriptionList[i]);
            intent.putExtra("image", imageList);
            startActivity(intent);
        });

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_categories);

    }
    private void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}