package com.vonway.www.practice4android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class component extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_component);
        findComponent();
    }

    private void findComponent() {
          Button bt = (Button)findViewById(R.id.button);
          ToggleButton tbt = (ToggleButton)findViewById(R.id.tbutton);
          
          bt.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Toast.makeText(component.this, "Button is clicked.", Toast.LENGTH_SHORT).show();
                
            }
        });
          
          tbt.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(component.this, "Button is checked.", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(component.this, "Button is not checked.", Toast.LENGTH_SHORT).show();
                }
            }
        });
          
    }

    public void onRadioButtonClicked(View v) {
        boolean checked = ((RadioButton)v).isChecked();
        
           switch (v.getId()) {
            case R.id.rg1:
                if(checked)
                    Toast.makeText(this, "rg1 checked.", Toast.LENGTH_SHORT).show();
              
                break;
            case R.id.rg2:
                if(checked)
                    Toast.makeText(this, "rg2 checked.", Toast.LENGTH_SHORT).show();
               
                break;
            case R.id.rg3:
                if(checked)
                    Toast.makeText(this, "rg3 checked.", Toast.LENGTH_SHORT).show();
                
                break;
            case R.id.rg4:
                if(checked)
                    Toast.makeText(this, "rg4 checked.", Toast.LENGTH_SHORT).show();
                
                break;
            default:
                break;
        }
    }
    
}
