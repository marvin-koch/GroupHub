package com.example.grouphub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class profile_view_groups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_view_groups);
    Button return_to_profile = findViewById(R.id.back_to_profile);
    return_to_profile.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //finish();
                AlertDialog.Builder builder = new AlertDialog.Builder(profile_view_groups.this);
                builder.setTitle("Button Clicked")
                        .setMessage("Don't!")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Perform any additional actions or dismiss the dialog
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });
    }
}