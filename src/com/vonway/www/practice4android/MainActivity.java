
package com.vonway.www.practice4android;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button btn_component = null;
    private Button btn_activity = null;
    private Button btn_layout = null;
    private Button layout_app = null;
    private Button other_app = null;
    private Button notification = null;
    private Button serviceButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findbutton();
    }

    private void findbutton() {
        // TODO Auto-generated method stub
        btn_component = (Button) findViewById(R.id.btn_component);
        btn_activity = (Button) findViewById(R.id.btn_activity);
        btn_layout = (Button) findViewById(R.id.btn_layout);
        layout_app = (Button) findViewById(R.id.layout_app);
        other_app = (Button) findViewById(R.id.other_app);
        notification = (Button) findViewById(R.id.notification);
        serviceButton=(Button)findViewById(R.id.service);
        
        btn_component.setOnClickListener(BtnListener);
        btn_activity.setOnClickListener(BtnListener);
        btn_layout.setOnClickListener(BtnListener);
        layout_app.setOnClickListener(BtnListener);
        other_app.setOnClickListener(BtnListener);
        notification.setOnClickListener(BtnListener);
        serviceButton.setOnClickListener(BtnListener);
    }

    OnClickListener BtnListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.btn_component:
                    startActivity(new Intent(MainActivity.this, component.class));
                    break;
                case R.id.btn_activity:
                    startActivity(new Intent(MainActivity.this, app.class));
                    break;
                case R.id.btn_layout:
                    startActivity(new Intent(MainActivity.this, provider.class));
                    break;
                case R.id.layout_app:
                    startActivity(new Intent(MainActivity.this, layout.class));
                    break;
                case R.id.other_app:
                    startActivity(new Intent(MainActivity.this, other.class));
                    break;
                case R.id.notification:
                    startActivity(new Intent(MainActivity.this, notification.class));
                    break;
                case R.id.service:
                    startActivity(new Intent(MainActivity.this, mp3.class));
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "setting is selected.", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.action_exit:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
