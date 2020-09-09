package com.example.gadsleaderboard.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.Models.SkillLeaders;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SkillLeadersAdapter extends RecyclerView.Adapter<SkillLeadersAdapter.MyViewHolder2> {


    private List<SkillLeaders> skillLeaders;
    private static final int LIMITS = 20;

    public SkillLeadersAdapter(List<SkillLeaders> skillLeaders){

        this.skillLeaders = skillLeaders;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_skill,parent,false);
        return new MyViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        String name = skillLeaders.get(position).getName();
        int score = skillLeaders.get(position).getScore();
        String country = skillLeaders.get(position).getCountry();
        String badgeUrls = skillLeaders.get(position).getBadgeUrl();
        String finalScore = String.valueOf(score);
        String skillStatement = finalScore+" "+"skill IQ Score"+","+" "+country+".";

        holder.NameSkill.setText(name);
        holder.Skill.setText(skillStatement);


        try{
            Picasso.get()
                    .load(badgeUrls).placeholder(R.drawable.iq_badge).into(holder.SkillBadge);


        }catch (Exception e){
            Picasso.get().load(R.drawable.badge_learner).into(holder.SkillBadge);

        }


    }

    @Override
    public int getItemCount() {

        if(skillLeaders.size() > 20){
            return LIMITS;
        }
        else {
           return skillLeaders.size();
        }


    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder{

        ImageView SkillBadge;
        TextView NameSkill,Skill;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            SkillBadge = itemView.findViewById(R.id.skillBadge);
            NameSkill = itemView.findViewById(R.id.NameIq);
            Skill = itemView.findViewById(R.id.skill);
        }
    }
}
