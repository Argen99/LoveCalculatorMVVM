package com.geektech.lovecalculator.viewmodel;

import android.app.appsearch.ReportSystemUsageRequest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.lovecalculator.network.LoveModel;
import com.geektech.lovecalculator.repository.Repository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {

    Repository repository;

    @Inject
    public MainViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<LoveModel> getLoveModelLiveData(String first, String second){
        return repository.getData(first, second);
    }
}
