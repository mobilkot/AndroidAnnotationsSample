package com.example.aatest;

import java.util.Date;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;

import android.app.Activity;
import android.view.Menu;

@EActivity(R.layout.main_activity)
public class MainActivity extends Activity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity, menu);
        return true;
    }
    
    @AfterViews
    protected void afterViews(){
    	TestActivity_.intent(this).myMessage(new Date(System.currentTimeMillis()).toLocaleString()).start();
    }
}
