package com.bilgic.landmarkbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import com.bilgic.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Landmark> landmarkArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.bilgic.landmarkbook.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landmarkArrayList = new ArrayList<>();
        landmarkArrayList.add(new Landmark("Pisa", "Italy", R.drawable.pisa));
        landmarkArrayList.add(new Landmark("Eiffel", "France", R.drawable.eiffel));
        landmarkArrayList.add(new Landmark("Colosseum", "Italy", R.drawable.colosseum));
        landmarkArrayList.add(new Landmark("London Bridge", "England", R.drawable.londonbridge));

        List<String> landmarkNames = landmarkArrayList.stream().map(landmark -> landmark.name).collect(Collectors.toList());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, landmarkNames);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("landmark", landmarkArrayList.get(position));
            startActivity(intent);
        });

    }
    }
