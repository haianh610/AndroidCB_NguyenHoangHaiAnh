package com.example.truyencuoi;

import static android.content.Intent.getIntent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryHolder> {
    private final ArrayList<Story> listStory;
    private final Context context;

    public StoryAdapter(ArrayList<Story> listStory, Context context) {
        this.listStory = listStory;
        this.context = context;
    }

    @NonNull
    @Override
    public StoryAdapter.StoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_splash,parent,false);
        return new StoryAdapter.StoryHolder(view);
    }

    public class StoryHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        public StoryHolder(View itemView){
            super(itemView);
            txtName = itemView.findViewById(R.id.tv_story);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }
}
