package com.example.user.apptivateskeleton;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by user on 17/10/2015.
 */
public class BaseActivity extends AppCompatActivity {

    static final String APPTIVATE_QUERY = "APPTIVATE_QUERY";
    private Toolbar mToolbar;

    protected Toolbar activateToolbar(){
        if(null == mToolbar){
            mToolbar = (Toolbar) findViewById(R.id.app_bar);
            if(null != mToolbar){
                setSupportActionBar(mToolbar);
            }
        }
        return mToolbar;
    }

    protected Toolbar activateToolbarWithHomeEnabled(){
        activateToolbar();
        if(null != mToolbar){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        return  mToolbar;
    }
}
