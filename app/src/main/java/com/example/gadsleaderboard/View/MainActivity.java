package com.example.gadsleaderboard.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.Adapters.ViewPagerAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private TabLayout mTabLayout;
    private TabItem learningLeaders;
    private TabItem skillIqLeaders;
    private Button btnSubmit;
    private Toolbar mMToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mMToolbar);




        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubmitActivity.class);
                startActivity(intent);

            }
        });

        mTabLayout = findViewById(R.id.tabLayout);
        learningLeaders = findViewById(R.id.learningLeaders);
        skillIqLeaders = findViewById(R.id.skilliq);

        mViewPager = findViewById(R.id.pager);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),mTabLayout.getTabCount());
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0){
                    mViewPagerAdapter.notifyDataSetChanged();
                }else if(tab.getPosition()==1){
                    mViewPagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

    }



}
