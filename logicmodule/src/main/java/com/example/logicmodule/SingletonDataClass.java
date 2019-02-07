package com.example.logicmodule;

import android.arch.lifecycle.MutableLiveData;

public class SingletonDataClass {

    private static SingletonDataClass ourInstance;

    public static SingletonDataClass getInstance() {
        if (ourInstance == null) {
            ourInstance = new SingletonDataClass();
        }

        return ourInstance;
    }

    private SingletonDataClass() {
        liveData = new MutableLiveData<>();
    }



    private MutableLiveData<Integer> liveData;

    public MutableLiveData<Integer> getLiveData() {
        return liveData;
    }

}
