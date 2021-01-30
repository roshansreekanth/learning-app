package com.roshan.project1_roshan_sreekanth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    //TODO: Set animal sound button as String resource value

    ImageView backgroundAnimalImage;
    Button animalTitleButton;
    Button animalSoundButton;
    TextView animalFactsTextView;

    String wildAnimalTitle ;
    String wildAnimalFact;
    String wildAnimalFactTwo;
    int wildAnimalImage;
    String wildAnimalUrl;
    String wildAnimalSound;

    ArrayList<String> facts;
    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        backgroundAnimalImage = findViewById(R.id.backgroundAnimalImage);
        animalTitleButton = findViewById(R.id.animalTitleButton);
        animalSoundButton = findViewById(R.id.animalSoundButton);
        facts = new ArrayList<String>();

        getData();
        setData();
    }

    private void getData()
    {
        if(getIntent().hasExtra("wildAnimalTitle") && getIntent().hasExtra("wildAnimalFact") && getIntent().hasExtra("wildAnimalImage") && getIntent().hasExtra("wildAnimalSound") && getIntent().hasExtra("wildAnimalUrl") && getIntent().hasExtra("wildAnimalFactTwo"))
        {
            wildAnimalTitle = getIntent().getStringExtra("wildAnimalTitle");
            wildAnimalFact = getIntent().getStringExtra("wildAnimalFact");
            wildAnimalFactTwo = getIntent().getStringExtra("wildAnimalFactTwo");
            wildAnimalImage = getIntent().getIntExtra("wildAnimalImage", 1);
            wildAnimalUrl= getIntent().getStringExtra("wildAnimalUrl");
            wildAnimalSound = getIntent().getStringExtra("wildAnimalSound");
            facts.add(wildAnimalFact);
            facts.add(wildAnimalFactTwo);
            viewPager2 = findViewById(R.id.viewpager);
            viewPagerAdapter = new ViewPagerAdapter(this, facts);
            viewPager2.setAdapter(viewPagerAdapter);
        }
        else
        {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData()
    {
        animalTitleButton.setText(wildAnimalTitle);
        backgroundAnimalImage.setImageResource(wildAnimalImage);
    }

    public void openWebsite(View view)
    {
        Uri webpage = Uri.parse(wildAnimalUrl);

        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Can't handle this intent!", Toast.LENGTH_SHORT).show();
        }
    }

    public void playSound(View view)
    {
        Uri sound = Uri.parse(wildAnimalSound);
        MediaPlayer mp = MediaPlayer.create(this, sound);
        mp.start();
    }
}
