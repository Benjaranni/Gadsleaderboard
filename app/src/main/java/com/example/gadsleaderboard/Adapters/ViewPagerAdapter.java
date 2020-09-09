package com.example.gadsleaderboard.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gadsleaderboard.View.LearningLeadersFragment;
import com.example.gadsleaderboard.View.SkillIqLeadersFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    private int numOfTabs;

    public ViewPagerAdapter( @NonNull FragmentManager fm,int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  new LearningLeadersFragment();

            case 1:
                return  new SkillIqLeadersFragment();

            default:
                return null;



        }


    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
