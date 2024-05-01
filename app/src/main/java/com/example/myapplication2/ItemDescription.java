package com.example.myapplication2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ItemDescription extends AppCompatActivity {

    ItemDescriptionBinding binding;

    //back arrow
    ImageView back_desc;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ItemDescriptionBinding.inflate(getLayoutInflater());

        //back arrow
        back_desc = findViewById(R.id.back_arrow_desc);
        back_desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCategories();
            }
        });


        //items
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item_description);

        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            String description = intent.getStringExtra("description");
            int image = intent.getIntExtra("image", R.drawable.tops);

            binding.detailName.setText(name);
            binding.detailImage.setImageResource(image);
            binding.detailDesc.setText(description);


        }
    }
    private void openCategories(){
        Intent intent = new Intent(this, Categories.class);
        startActivity(intent);
    }
}