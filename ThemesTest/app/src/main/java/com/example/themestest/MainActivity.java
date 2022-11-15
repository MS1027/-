package com.example.themestest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private int mTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            mTheme = savedInstanceState.getInt("mTheme", R.style.AppTheme);
            setTheme(mTheme);
        }
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("mTheme", mTheme);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.item1:
                mTheme = R.style.AppTheme;
                recreate();
                return true;
            case R.id.item2:
                mTheme = R.style.DarkTheme;
                recreate();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}