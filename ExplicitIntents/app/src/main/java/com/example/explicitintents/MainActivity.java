package com.example.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mOnClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.btnTest1:
                intent = new Intent(this, SubActivity.class);
                startActivity(intent);
                break;
            case R.id.btnTest2:
                intent = new Intent();
                intent.setClassName("com.android.settings", "com.android.settings.Settings");
                startActivity(intent);
                break;
        }
    }
}