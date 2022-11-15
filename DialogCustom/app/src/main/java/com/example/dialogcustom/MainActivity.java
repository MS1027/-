package com.example.dialogcustom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String mName = "???";
    private String mPassword = "???";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateResult();
    }

    private void updateResult(){
        TextView textResult = (TextView) findViewById(R.id.textResult);
        textResult.setText("이름: " + mName + "\n" + "암호: " + mPassword);
    }

    public void mOnClick(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.dialog_login, null);
        builder.setView(layout);
        final EditText mEditName = (EditText) layout.findViewById(R.id.editName);
        final EditText mEditPassword = (EditText) layout.findViewById(R.id.editPassword);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mName = mEditName.getText().toString();
                mPassword = mEditPassword.getText().toString();
                updateResult();
            }
        });
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.create().show();
    }
}