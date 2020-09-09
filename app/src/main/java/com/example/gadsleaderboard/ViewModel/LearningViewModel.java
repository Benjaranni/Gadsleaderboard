package com.example.gadsleaderboard.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gadsleaderboard.Retrofit.ApiClient;
import com.example.gadsleaderboard.Retrofit.ApiInterface;
import com.example.gadsleaderboard.Models.LearnLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningViewModel  extends ViewModel {





    private MutableLiveData<List<LearnLeaders>> mLeaders;
    private ApiInterface apiInterface;

    //we will call this method to get the data
    public LiveData<List<LearnLeaders>> getLearnLeaders(){
        
        //if the list is null
        if(mLeaders==null){
            mLeaders = new MutableLiveData<>();
            
            //load the data asynchronously from server in this method
            loadLearnLeaders();
        }
        
        return  mLeaders;
    }

    private void loadLearnLeaders() {
        
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call <List<LearnLeaders>>  call = apiInterface.getLearningLeaders();
        
        call.enqueue(new Callback<List<LearnLeaders>>() {
            @Override
            public void onResponse(Call<List<LearnLeaders>> call, Response<List<LearnLeaders>> response) {

                mLeaders.setValue(response.body());


            }

            @Override
            public void onFailure(Call<List<LearnLeaders>> call, Throwable t) {

            }
        });
        
    }
}
