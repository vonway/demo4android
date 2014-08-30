package com.vonway.www.practice4android;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class app extends Activity implements OnClickListener{

    private Button appbtn1;
    private Button appbtn2;
    private Button appbtn3;
    private Button appbtn4;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app);
        findButton();
    }

    private void findButton() {
        // TODO Auto-generated method stub
        appbtn1 = (Button)findViewById(R.id.appbtn1);
        appbtn2 = (Button)findViewById(R.id.appbtn2);
        appbtn3 = (Button)findViewById(R.id.appbtn3);
        appbtn4 = (Button)findViewById(R.id.appbtn4);
        
        appbtn1.setOnClickListener(this);
        appbtn2.setOnClickListener(this);
        appbtn3.setOnClickListener(this);
        appbtn4.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Toast.makeText(app.this, "exit ---- exit", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent itIntent = new Intent(this,service.class);
        switch (v.getId()) {
            case R.id.appbtn1:
               startService(itIntent);
                break;
            case R.id.appbtn2:
               stopService(itIntent);
                break;
            case R.id.appbtn3:
               bindService(itIntent, conn,BIND_AUTO_CREATE );
                break;
            case R.id.appbtn4:
                unbindService(conn);
                break;
            default:
                break;
        }
    }
    ServiceConnection conn = new ServiceConnection() {
        
        @Override
        public void onServiceDisconnected(ComponentName name) {
            // TODO Auto-generated method stub
           
        }
        
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // TODO Auto-generated method stub
            Toast.makeText(app.this, "connected", Toast.LENGTH_SHORT).show();
        }
    };
}
