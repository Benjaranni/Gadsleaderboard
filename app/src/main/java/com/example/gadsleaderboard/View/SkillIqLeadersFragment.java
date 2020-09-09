package com.example.gadsleaderboard.View;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadsleaderboard.Adapters.SkillLeadersAdapter;
import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.Models.SkillLeaders;
import com.example.gadsleaderboard.ViewModel.SkillViewModel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SkillIqLeadersFragment extends Fragment {

    private RecyclerView skillRecyclerView;
    private SkillLeadersAdapter skillAdapter;
    private List<SkillLeaders> skillLeaders;



    public SkillIqLeadersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_skill_iq_leaders, container, false);

        skillRecyclerView = view.findViewById(R.id.skillLead);
        skillRecyclerView.setHasFixedSize(true);
        skillRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        SkillViewModel model = ViewModelProviders.of(requireActivity()).get(SkillViewModel.class);
        model.getSkillLeaders().observe(getViewLifecycleOwner(), new Observer<List<SkillLeaders>>() {
            @Override
            public void onChanged(List<SkillLeaders> skillLeaders) {
                skillAdapter = new SkillLeadersAdapter(skillLeaders);
                skillRecyclerView.setAdapter(skillAdapter);
            }
        });


        return view;
    }

}
