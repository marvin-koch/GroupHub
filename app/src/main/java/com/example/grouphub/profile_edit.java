package com.example.grouphub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grouphub.component.User;

public class profile_edit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_edit);
        User user = (User) getIntent().getSerializableExtra("user");

        ImageButton return_to_profile = findViewById(R.id.return_to_main);
        TextView change_photo = findViewById(R.id.change_picture);
        Button change_username = findViewById(R.id.change_username);
        Button change_password = findViewById(R.id.change_password);


        return_to_profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Intent = new Intent(profile_edit.this, profile.class);
                Intent.putExtra("user", user);
                startActivity(Intent);
                //finish();
            }
        });

        change_photo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Display a pop-up dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(profile_edit.this);
                final View desc_popup = getLayoutInflater().inflate(R.layout.profile_edit_desc, null);
                builder.setView(desc_popup);
                builder.setTitle("Edit description");
                builder.setPositiveButton("Apply", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // set change to db if apply is clicked
                        dialog.dismiss();
                        Toast.makeText(profile_edit.this, "Changes applied", Toast.LENGTH_SHORT).show();
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

        change_username.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Display a pop-up dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(profile_edit.this);
                final View desc_popup = getLayoutInflater().inflate(R.layout.profile_edit_username, null);
                builder.setView(desc_popup);
                builder.setTitle("Change Username");
                final EditText newname = desc_popup.findViewById(R.id.edit_desc_popup);

                builder.setPositiveButton("Apply", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // set change to db if apply is clicked
                        String username = newname.getText().toString();
                        user.setName(username);
                        dialog.dismiss();
                        Toast.makeText(profile_edit.this, "Changes applied", Toast.LENGTH_SHORT).show();
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


        change_password.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Intent = new Intent(profile_edit.this, profile_change_password.class);
                startActivity(Intent);
            }
        });

    }
}