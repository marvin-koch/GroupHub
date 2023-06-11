package com.example.grouphub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class joined_groups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joined_groups);
        ImageButton return_to_profile = findViewById(R.id.return_to_main);
        Button leave_group = findViewById(R.id.leave_group);


        return_to_profile.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();
            }
        });

        leave_group.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //implement leave group
                finish();
            }
        });
    }
}