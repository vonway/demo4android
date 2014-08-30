package com.vonway.www.practice4android;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.net.ContentHandler;

import javax.net.ssl.ManagerFactoryParameters;

public class notification extends Activity {

    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        Button notifyButton = (Button)findViewById(R.id.notify);
        Button cancelButton = (Button)findViewById(R.id.cancelnotify);
        Button update = (Button)findViewById(R.id.update);
        
        Button newnotifyButton = (Button)findViewById(R.id.newnotify);
        Button newcancelButton = (Button)findViewById(R.id.newcancelnotify);
        Button newupdate = (Button)findViewById(R.id.newupdate);
        Button newbig =(Button)findViewById(R.id.newbignotify);
        
        notifyButton.setOnClickListener(btnListener);
        cancelButton.setOnClickListener(btnListener);
        update.setOnClickListener(btnListener);
        
        newnotifyButton.setOnClickListener(newbtnListener);
        newcancelButton.setOnClickListener(newbtnListener);
        newupdate.setOnClickListener(newbtnListener);
        newbig.setOnClickListener(newbtnListener);
        
        
    }
    OnClickListener btnListener = new OnClickListener() {
        
        @Override
        public void onClick(View v) {
            
            PendingIntent intent = PendingIntent.getActivity(notification.this, 0, new Intent(notification.this, notification.class), PendingIntent.FLAG_UPDATE_CURRENT);
            NotificationManager manager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            //设置通知栏显示 内容 向上滚动消失
            Notification notification = new Notification(R.drawable.icon, "Notify now", System.currentTimeMillis());
            //设置通知栏下拉后的内容
            notification.setLatestEventInfo(notification.this,"Notify Title Here","Here is content ...",intent);
            
            
            switch (v.getId()) {
                case R.id.notify:
                    manager.notify(R.id.notification, notification);
                    break;
                case R.id.update:
                    Notification notifi = new Notification(R.drawable.icon, "Notify update", System.currentTimeMillis());
                    //更新通知栏的通知
                    notifi.setLatestEventInfo(notification.this,"Notify update Title Here","Here is updated content ...",intent);
                    manager.notify(R.id.notification, notifi);
                    break;
               
                case R.id.cancelnotify:
                    manager.cancel(R.id.notification);
                    break;
                default:
                    break;
            }
        }

    };
    
    OnClickListener newbtnListener = new OnClickListener() {
        
        private final int NEWID=100;
        private int i=0;
        @Override
        public void onClick(View v) {
            NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(notification.this);
            //nBuilder.setContentTitle("new Notification");
            //nBuilder.setContentText("new Notification text");
            //nBuilder.setContentInfo("info");
            //nBuilder.setNumber(3);
            nBuilder.setTicker("a new Notification");
            //nBuilder.setSubText("haha");
            nBuilder.setAutoCancel(true);
            nBuilder.setSmallIcon(R.drawable.icon);
            
            TaskStackBuilder tsBuilder = TaskStackBuilder.create(notification.this);
            tsBuilder.addParentStack(notification.class);
            tsBuilder.addNextIntent(new Intent(notification.this,notification.class));
            PendingIntent pIntent = tsBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            
            nBuilder.setContentIntent(pIntent);
            
            NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            
            switch (v.getId()) {
                case R.id.newnotify:
                    notificationManager.notify(NEWID, nBuilder.build());
                    break;
                case R.id.newupdate:
                    nBuilder.setContentTitle("new update notification");
                    nBuilder.setContentText("new Notification text updated");
                    notificationManager.notify(NEWID, nBuilder.build());
                    break;
                case R.id.newbignotify:
                    nBuilder.setProgress(100, 0, true);
                    nBuilder.setContentTitle("new download notification");
                    nBuilder.setContentText("new downloading...");
                    notificationManager.notify(NEWID, nBuilder.build());
                    i=i+10;
                    nBuilder.setProgress(100, i, false);
                    notificationManager.notify(NEWID, nBuilder.build());
                    if (i>=100) {
                        nBuilder.setContentText("new downloaded");
                        notificationManager.notify(NEWID, nBuilder.build());
                    }
                    
                    break;
                case R.id.newcancelnotify:
                    notificationManager.cancel(NEWID);
                    break;
                default:
                    break;
            }
            
        }
    };
    
}
