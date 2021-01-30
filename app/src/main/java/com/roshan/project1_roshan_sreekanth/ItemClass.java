package com.roshan.project1_roshan_sreekanth;

import android.content.Context;

public class ItemClass
{
    private Context context;
    private String animalTitle;
    private String webUrl;
    private String soundUrl;
    private int image;

    public ItemClass(Context context, String animalTitle)
    {
        this.context = context;
        this.animalTitle = animalTitle;
        this.image = context.getResources().getIdentifier(this.animalTitle.toLowerCase(), "drawable", context.getPackageName());
        this.webUrl = "https://en.wikipedia.org/wiki/" + this.animalTitle;
        this.soundUrl = "android.resource://" + context.getPackageName() + "/raw/" + this.animalTitle.toLowerCase();
    }

    public String getAnimalTitle()
    {
        return this.animalTitle;
    }

    public int getAnimalImage()
    {
        System.out.println(this.animalTitle);
        return this.image;
    }

    public String getAnimalUrl()
    {
        return this.webUrl;
    }

    public String getAnimalSound()
    {
        return this.soundUrl;
    }
}
