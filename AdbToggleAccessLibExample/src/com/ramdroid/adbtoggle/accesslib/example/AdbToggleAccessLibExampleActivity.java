package com.ramdroid.adbtoggle.accesslib.example;

import com.ramdroid.adbtoggle.accesslib.AdbToggleAccess;
import com.ramdroid.adbtoggle.accesslib.AdbToggleAccess.OnAdbToggleListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.widget.ToggleButton;

public class AdbToggleAccessLibExampleActivity extends Activity {
		
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        boolean isEnabled = AdbToggleAccess.isEnabled(this);
        ((ToggleButton) findViewById(R.id.status)).setChecked(isEnabled);
        
        findViewById(R.id.enable).setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				enable();
			}      	
        });
        
        findViewById(R.id.disable).setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
        		disable();
        	}
        });
    }
    
    private void enable() {
    	
    	AdbToggleAccess adbToggle = new AdbToggleAccess();
    	boolean result = adbToggle.enable(this, new OnAdbToggleListener() {

			public void onFinished(boolean successful) {
				((ToggleButton) findViewById(R.id.status)).setChecked(true);
			}
    		
    	});
    	if (!result) {
    		Toast.makeText(this, "Failed to toggle debug settings!", Toast.LENGTH_SHORT).show();
    	}
    }
    
    private void disable() {

    	AdbToggleAccess adbToggle = new AdbToggleAccess();
    	boolean result = adbToggle.disable(this, new OnAdbToggleListener() {

			public void onFinished(boolean successful) {
				((ToggleButton) findViewById(R.id.status)).setChecked(false);				
			}
    		
    	});
    	if (!result) {
    		Toast.makeText(this, "Failed to toggle debug settings!", Toast.LENGTH_SHORT).show();
    	}
    }
}