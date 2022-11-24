package com.example.startedservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.d("test", "onCreate() 호출!");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        if(intent.getAction().equals("com.example.PLAYMUSIC")){
            new MusicThread().start();
        } else if (intent.getAction().equals("com.example.DOWNLOAD")){
            new DownloadThread().start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("test", "onDestroy() 호출!");
    }
}

class MusicThread extends Thread {
    @Override
    public void run(){
        Log.d("test", "음악 재생 시작!");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        Log.d("test", "음악 재생 종료!");
    }
}

class DownloadThread extends Thread{
    @Override
    public void run(){
        Log.d("test", "파일 다운로드 시작!");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        Log.d("test", "파일 다운로드 종료!");
    }
}