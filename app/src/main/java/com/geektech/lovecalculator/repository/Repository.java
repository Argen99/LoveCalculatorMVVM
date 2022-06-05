package com.geektech.lovecalculator.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.geektech.lovecalculator.App;
import com.geektech.lovecalculator.network.LoveApi;
import com.geektech.lovecalculator.network.LoveModel;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    final String HOST = "love-calculator.p.rapidapi.com";
    final String KEY = "2611949ba1msha3bd1bac2be828cp1e93bejsn05be3f998e60";
    LoveApi api;

    @Inject
    public Repository(LoveApi loveApi) {
        api = loveApi;
    }

    public MutableLiveData<LoveModel> getData(String first, String second){

        MutableLiveData<LoveModel> localMutableLiveData = new MutableLiveData<>();

        api.loveCalculate(first,second,HOST,KEY).enqueue(new Callback<LoveModel>() {
            @Override
            public void onResponse(Call<LoveModel> call, Response<LoveModel> response) {
                if (response.isSuccessful()){
                    localMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<LoveModel> call, Throwable t) {
                Log.e("ololo", "onFailure " + t.getLocalizedMessage());

            }
        });

        return localMutableLiveData;
    }
}
