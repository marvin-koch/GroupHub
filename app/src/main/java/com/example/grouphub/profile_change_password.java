package com.example.grouphub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class profile_change_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_change_password);

        ImageButton return_to_profile = findViewById(R.id.return_to_main);
        Button change_password = findViewById(R.id.update_password);

        return_to_profile.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();
            }
        });

        change_password.setOnClickListener(new View.OnClickListener() {
            //check whether current password match and
            //check whether new password and confirm password match
            //update new password to db
            public void onClick(View v) {
                finish();
            }
        });

    }
}