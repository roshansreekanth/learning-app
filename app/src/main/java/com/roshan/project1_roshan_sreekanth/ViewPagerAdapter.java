package com.roshan.project1_roshan_sreekanth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>
{
    Context context;
    ArrayList<String> facts;

    public ViewPagerAdapter(Context context, ArrayList<String> facts)
    {
        this.context = context;
        this.facts = facts;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_card, parent, false);
        return new ViewPagerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.factText.setText(facts.get(position));
    }

    @Override
    public int getItemCount() {
        return facts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView factText;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            factText = itemView.findViewById(R.id.factText);
        }
    }
}
