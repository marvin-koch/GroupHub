package com.example.grouphub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;

import com.example.grouphub.component.Hub;
import com.example.grouphub.component.LoginHandler;

public class profile extends AppCompatActivity {
    // globally


//in your OnCreate() method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        TextView profile_username = (TextView)findViewById(R.id.profile_username);
        TextView description = (TextView)findViewById(R.id.personal_desc_text);
        TextView info = (TextView)findViewById(R.id.contact_information_text);
        Button edit_profile = findViewById(R.id.edit_profile);
        Button edit_desc = findViewById(R.id.edit);
        Button edit_contact = findViewById(R.id.edit2);
        Button group_list = findViewById(R.id.group_list);
        ImageButton return_to_main = findViewById(R.id.return_to_main);


        profile_username.setText(LoginHandler.currentUser.getName());
        description.setText(LoginHandler.currentUser.getDescription());
        info.setText(LoginHandler.currentUser.getPhoneNumber());
    edit_profile.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            Intent Intent = new Intent(profile.this, profile_edit.class);
            startActivity(Intent);
        }
    });

    edit_desc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Display a pop-up dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(profile.this);
                final View desc_popup = getLayoutInflater().inflate(R.layout.profile_edit_desc, null);
                builder.setView(desc_popup);
                builder.setTitle("Edit description");
                builder.setPositiveButton("Apply", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // set change to db if apply is clicked
                        dialog.dismiss();
                        Toast.makeText(profile.this, "Changes applied", Toast.LENGTH_SHORT).show();
                        // "change applied" message will pop up
                        // should probably refresh profile page to apply changes
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // abort pop up if cancel is clicked
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
    edit_contact.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Display a pop-up dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(profile.this);
                final View desc_popup = getLayoutInflater().inflate(R.layout.profile_edit_contact, null);
                builder.setView(desc_popup);
                builder.setTitle("Edit contact information");
                builder.setPositiveButton("Apply", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // set change to db if apply is clicked
                        dialog.dismiss();
                        Toast.makeText(profile.this, "Changes applied", Toast.LENGTH_SHORT).show();
                        // "change applied" message will pop up
                        // should probably refresh profile page to apply changes
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // abort pop up if cancel is clicked
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });

    group_list.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            if (LoginHandler.currentUser.getHub() != null){
                Intent Intent = new Intent(profile.this, profile_view_groups.class);
                getIntent().putExtra("hub", LoginHandler.currentUser.getHub());
                startActivity(Intent);
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(profile.this);
                builder.setTitle("Button Clicked")
                        .setMessage("You haven't joined a group")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Perform any additional actions or dismiss the dialog
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        }
    });
    return_to_main.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            finish();
        }
    });
    }
}