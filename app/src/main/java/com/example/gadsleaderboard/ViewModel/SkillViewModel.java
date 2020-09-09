package com.example.gadsleaderboard.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.gadsleaderboard.Retrofit.ApiClient;
import com.example.gadsleaderboard.Retrofit.ApiInterface;
import com.example.gadsleaderboard.Models.SkillLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillViewModel   extends ViewModel {

    private ApiInterface apiInterface;

    private MutableLiveData<List<SkillLeaders>> skillLeaders;

    public LiveData<List<SkillLeaders>>  getSkillLeaders(){
        if(skillLeaders==null){
            skillLeaders= new MutableLiveData<>();


            loadSkillLeaders();
        }

        return skillLeaders;
    }

    private void loadSkillLeaders() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<SkillLeaders>>  call  = apiInterface.getSkillLeaders();

        call.enqueue(new Callback<List<SkillLeaders>>() {
            @Override
            public void onResponse(Call<List<SkillLeaders>> call, Response<List<SkillLeaders>> response) {
                skillLeaders.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<SkillLeaders>> call, Throwable t) {

            }
        });





    }
}
