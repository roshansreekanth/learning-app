package com.roshan.project1_roshan_sreekanth;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>
{

    ItemClass animal;
    String[] wildAnimalTitles;
    String[] wildAnimalFacts;
    String[] wildAnimalFactsTwo;
    Context context;

    public MyRecyclerViewAdapter(Context context, String[] wildAnimalTitles, String[] wildAnimalFacts, String[] wildAnimalFactsTwo, int[] images)
    {
        this.context = context;
        this.wildAnimalTitles = wildAnimalTitles;
        this.wildAnimalFacts = wildAnimalFacts;
        this.wildAnimalFactsTwo = wildAnimalFactsTwo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position)
    {
        animal = new ItemClass(context, wildAnimalTitles[position]);
        holder.cardTextTitle.setText(animal.getAnimalTitle());
        holder.cardImageAnimal.setImageResource(animal.getAnimalImage());

        Random rand = new Random();
        int red = rand.nextInt(256);
        int green = rand.nextInt(256);
        int blue = rand.nextInt(256);

        int randomColour = Color.argb(80, red, green, blue);
        holder.cardLayout.setBackgroundColor(randomColour);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animal = new ItemClass(context, wildAnimalTitles[position]);
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("wildAnimalTitle", animal.getAnimalTitle());
                intent.putExtra("wildAnimalFact", wildAnimalFacts[position]);
                intent.putExtra("wildAnimalFactTwo", wildAnimalFactsTwo[position]);
                intent.putExtra("wildAnimalImage", animal.getAnimalImage());
                intent.putExtra("wildAnimalSound", animal.getAnimalSound());
                intent.putExtra("wildAnimalUrl", animal.getAnimalUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return wildAnimalTitles.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView cardTextTitle;
        ImageView cardImageAnimal;
        CardView cardLayout;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            cardTextTitle = itemView.findViewById(R.id.cardTextTitle);
            cardImageAnimal = itemView.findViewById(R.id.cardImageAnimal);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            cardLayout = itemView.findViewById(R.id.cardLayout);
        }
    }
}
