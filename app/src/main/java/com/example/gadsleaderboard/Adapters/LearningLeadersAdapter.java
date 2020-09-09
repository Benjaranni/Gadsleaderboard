package com.example.gadsleaderboard.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.gadsleaderboard.Models.LearnLeaders;
import com.example.gadsleaderboard.R;
import com.squareup.picasso.Picasso;


import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.MyViewHolder>{


    private List<LearnLeaders> mLeaders;
    private static final int LIMIT = 20;


    public LearningLeadersAdapter(List<LearnLeaders> mLeaders){
        this.mLeaders = mLeaders;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name = mLeaders.get(position).getName();
        int  hours = mLeaders.get(position).getHours();
        String country = mLeaders.get(position).getCountry();
        String badgeUrl = mLeaders.get(position).getBadgeUrl();
        String hoursNew = String.valueOf(hours);
        String statement=hoursNew+" "+"learning hours"+","+" "+country+".";

        holder.Name.setText(name);
        holder.Hours.setText(statement);

        try{
            Picasso.get()
                    .load(badgeUrl).placeholder(R.drawable.badge_learner).into(holder.badge);


        }catch (Exception e){
            Picasso.get().load(R.drawable.badge_learner).into(holder.badge);

        }



    }

    @Override
    public int getItemCount() {

        if(mLeaders.size() > LIMIT){
            return  LIMIT;
        }else {
            return mLeaders.size();

        }


    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView badge;
        TextView Name,Hours;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            Hours = itemView.findViewById(R.id.hours);
            badge = itemView.findViewById(R.id.badge);


        }
    }
}
