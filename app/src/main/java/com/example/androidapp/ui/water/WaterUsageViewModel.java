package com.example.androidapp.ui.water;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidapp.APIAccess.RequestManager;
import com.example.androidapp.Database.CarbonEmissions;
import com.example.androidapp.Database.CarbonRepository;

import java.util.ArrayList;
import java.util.List;

public class WaterUsageViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<List<String>> spinnerData;
    RequestManager rm = RequestManager.getInstance();
    CarbonRepository cr;


    public WaterUsageViewModel(Application app) {
        super(app);
        cr = CarbonRepository.getInstance(app);
        mText = new MutableLiveData<>();
        spinnerData = new MutableLiveData<>();
        mText.setValue("Wait...");
        rm.getWaterUsageTypes();





    }

    public void getWaterUsage(String type,int times){
        rm.getWaterUsage(type,times);
    }


    public LiveData<String> getText() {

        mText = rm.getOutput();
        return mText;
    }

    public MutableLiveData<List<String>> getSpinnerData(){
        spinnerData= rm.getItemsLive() ;
        return spinnerData;
    }

    public LiveData<List<CarbonEmissions>> getAll() {
       return cr.getAllEmissions();
    }

    public void insert(CarbonEmissions carbonEmissions){
        cr.insert(carbonEmissions);
    }
}