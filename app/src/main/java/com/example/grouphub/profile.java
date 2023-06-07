package com.example.grouphub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
    Button edit_profile = findViewById(R.id.edit_profile);
    Button edit_desc = findViewById(R.id.edit);
    Button edit_contact = findViewById(R.id.edit2);
    Button group_list = findViewById(R.id.group_list);
    Button return_to_main = findViewById(R.id.return_to_main);
    edit_profile.setOnClickListener(new View.OnClickListener() {

    public void onClick(View v) {
        // Display a pop-up dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(profile.this);
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
    edit_desc.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Display a pop-up dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(profile.this);
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
    edit_contact.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Display a pop-up dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(profile.this);
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

    group_list.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            Intent Intent = new Intent(profile.this, profile_view_groups.class);
            startActivity(Intent);
        }
    });
    return_to_main.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            finish();
        }
    });
    }
}