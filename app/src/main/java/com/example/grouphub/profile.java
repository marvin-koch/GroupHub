package com.example.grouphub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
    Button myButton = findViewById(R.id.edit_profile);
    myButton.setOnClickListener(new View.OnClickListener() {

    public void onClick(View v) {
        // Display a pop-up dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(profile.this);
        builder.setTitle("Button Clicked")
                .setMessage("You clicked the button!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Perform any additional actions or dismiss the dialog
                        dialog.dismiss();
                    }
                })
                .show();
        }
    });
}}