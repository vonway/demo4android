package com.vonway.www.practice4android;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class service extends IntentService{
    private MediaPlayer mediaPlayer;
    
    public service() {
        super("com.vonway.www.practice4android.service");
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // TODO Auto-generated method stub
        
    }

    
    
   
}
