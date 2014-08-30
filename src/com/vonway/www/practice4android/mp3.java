
package com.vonway.www.practice4android;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

import java.io.IOException;

public class mp3 extends Activity {

    private MediaPlayer mediaPlayer = null;
    private SeekBar seekBar;
    private Button playButton;
    private Button pauseButton;
    private Button stopButton;
    private Intent itIntent;
    private Thread td;
    private boolean NEXT=false;
    private int progressnow;
    private int progresslast;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mp3);

        playButton = (Button) findViewById(R.id.play);
        pauseButton = (Button) findViewById(R.id.pause);
        stopButton = (Button) findViewById(R.id.stop);
        nextButton =(Button)findViewById(R.id.next);
        seekBar = (SeekBar) findViewById(R.id.seekbar);

        playButton.setOnClickListener(clickListener);
        pauseButton.setOnClickListener(clickListener);
        stopButton.setOnClickListener(clickListener);
        nextButton.setOnClickListener(clickListener);
        mediaPlayer = MediaPlayer.create(this, R.raw.ge);

        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(
                new OnSeekBarChangeListener() {

                   

                    private int progresslocal;

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // TODO Auto-generated method stub
                        progressnow =progresslocal;
                        if(progressnow==progresslast){
                            
                        }else {
                            if (mediaPlayer.isPlaying()) {
                                mediaPlayer.seekTo(progressnow);
                            }
                            
                            progresslast=progressnow;
                           
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        // TODO Auto-generated method stub
                        progresslocal = progress;
                    }
                });

        td = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        td.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    if (mediaPlayer.isPlaying()) {
                        seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    }
                    
                }
            }
        });

    }

    OnClickListener clickListener = new OnClickListener() {
       

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.play:
                    if (!td.isAlive()) {
                        td.start();
                    }
                    
                    if (mediaPlayer!=null) {
                        
                        if (!mediaPlayer.isPlaying()) {
                            try {
                                if (NEXT) {
                                    mediaPlayer = MediaPlayer.create(mp3.this, R.raw.ge2);
                                }else {
                                    mediaPlayer = MediaPlayer.create(mp3.this, R.raw.ge);
                                }
                                
                            } catch (IllegalStateException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            mediaPlayer.start();
                        }
                        
                    }
                    break;
                case R.id.pause:
                    if (mediaPlayer!=null) {
                        mediaPlayer.pause();
                    }
                    break;
                case R.id.next:
                    if (mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    NEXT=!NEXT;
                    if (NEXT) {
                        mediaPlayer = MediaPlayer.create(mp3.this, R.raw.ge2);
                    }else {
                        mediaPlayer = MediaPlayer.create(mp3.this, R.raw.ge);
                    }
                    mediaPlayer.start();
                    break;
                case R.id.stop:
                    if (mediaPlayer!=null) {
                        mediaPlayer.stop();
                    }
                    break;
                default:
                    break;
            }
        }
    };

}
