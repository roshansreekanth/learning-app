package com.roshan.project1_roshan_sreekanth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    //TODO: Move the titles and the images to a separate java class
    String[] wildAnimalTitles;
    String[] wildAnimalFacts;
    String[] wildAnimalFactsTwo;
    int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        wildAnimalTitles = new String[]{"Bear", "Deer", "Elephant", "Fox", "Giraffe", "Kangaroo", "Lion", "Monkey", "Shark", "Wolf"};
        wildAnimalFacts = getResources().getStringArray(R.array.wild_animal_facts);
        wildAnimalFactsTwo = getResources().getStringArray(R.array.wild_animal_facts_two);

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(this, wildAnimalTitles, wildAnimalFacts, wildAnimalFactsTwo, images);
        recyclerView.setAdapter(myRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
