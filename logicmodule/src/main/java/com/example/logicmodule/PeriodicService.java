package com.example.logicmodule;

import android.app.Service;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class PeriodicService extends Service {

    private String TAG = "PeriodicService";
    SingletonDataClass singletonDataClass;

    public PeriodicService()
    {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        destroyScheduler();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(TAG,"onStartCommand");
        singletonDataClass = SingletonDataClass.getInstance();
        setupSchedulerService();
        return super.onStartCommand(intent, flags, startId);

    }

    Timer timer;
    private void setupSchedulerService() {
        Log.v(TAG, "setupSchedulerService");

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Log.v(TAG,"counter :" + counter++);
                singletonDataClass.getLiveData().postValue(counter);
            }
        },1000,2000);

    }

    //To stop timer
    public void destroyScheduler() {
        Log.v(TAG, "destroyScheduler");
        if(timer != null){
            timer.cancel();
        }


    }

    int counter = 0;


}
