package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mOnClick(View v){
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.btnTest1:
                intent.setAction("com.example.implicitintents.TEST1");
                break;
            case R.id.btnTest2:
                intent.setAction("com.example.implicitintents.TEST2");
                intent.setType("image/png");
                break;
            case R.id.btnTest3:
                intent.setAction(Intent.ACTION_MAIN);
                break;
            case R.id.btnTest4:
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:010-2222-3333"));
                break;
            case R.id.btnTest5:
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.android.com"));
                break;
            case R.id.btnTest6:
                intent.setAction(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                break;
        }
        startActivity(intent);
    }
}