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

import com.example.gadsleaderboard.Adapters.LearningLeadersAdapter;
import com.example.gadsleaderboard.Models.LearnLeaders;
import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.Retrofit.ApiInterface;
import com.example.gadsleaderboard.ViewModel.LearningViewModel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LearningLeadersFragment extends Fragment {

    private RecyclerView learningLeaders;
     private LearningLeadersAdapter adapter;
     private List<LearnLeaders> mLeaders;
     private ApiInterface apiInterface;



    public LearningLeadersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        learningLeaders = view.findViewById(R.id.learningLead);
        learningLeaders.setHasFixedSize(true);
        learningLeaders.setLayoutManager(new LinearLayoutManager(getActivity()));


        LearningViewModel model = ViewModelProviders.of(requireActivity()).get(LearningViewModel.class);
        model.getLearnLeaders().observe(getViewLifecycleOwner(), new Observer<List<LearnLeaders>>() {
            @Override
            public void onChanged(List<LearnLeaders> learnLeaders) {
                adapter = new LearningLeadersAdapter(learnLeaders);
                learningLeaders.setAdapter(adapter);
            }
        });








        return view;
    }




}
