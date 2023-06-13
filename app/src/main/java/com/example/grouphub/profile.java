package com.example.grouphub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;

import com.example.grouphub.component.FirebaseUtils;
import com.example.grouphub.component.Hub;
import com.example.grouphub.component.LoginHandler;
import com.example.grouphub.component.ObjectListener;
import com.example.grouphub.component.User;

public class profile extends AppCompatActivity {
    // globally


//in your OnCreate() method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        User user = (User) getIntent().getSerializableExtra("user");

        TextView profile_username = (TextView)findViewById(R.id.profile_username);
        TextView description = (TextView)findViewById(R.id.personal_desc_text);
        TextView info = (TextView)findViewById(R.id.contact_information_text);
        Button edit_profile = findViewById(R.id.edit_profile);
        Button edit_desc = findViewById(R.id.edit);
        Button edit_contact = findViewById(R.id.edit2);
        Button group_list = findViewById(R.id.group_list);
        ImageButton return_to_main = findViewById(R.id.return_to_main);


        profile_username.setText(user.getName());
        description.setText(user.getDescription());
        info.setText(user.getPhoneNumber());
    edit_profile.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            Intent Intent = new Intent(profile.this, profile_edit.class);
            Intent.putExtra("user", user);
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
                final EditText newdesc = desc_popup.findViewById(R.id.edit_desc_popup);
                builder.setPositiveButton("Apply", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // set change to db if apply is clicked
                        String desc = newdesc.getText().toString();
                        user.setDescription(desc);
                        description.setText(user.getDescription());
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
                final EditText newdesc = desc_popup.findViewById(R.id.edit_contact_popup);
                builder.setPositiveButton("Apply", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // set change to db if apply is clicked
                        String number = newdesc.getText().toString();
                        user.setPhoneNumber(number);
                        info.setText(user.getPhoneNumber());
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
            String hubId = user.getHub();
            FirebaseUtils.getHub(new ObjectListener() {
                @Override
                public void onObjectRead(Object o) {
                    Hub hub = (Hub) o;

                    if (hubId != ""){
                        Intent Intent = new Intent(profile.this, profile_view_groups.class);
                        Intent.putExtra("hub", hub);
                        Intent.putExtra("user", user);

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

                @Override
                public void onObjectReadError(Object o) {

                }


            }, hubId);

        }
    });
    return_to_main.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            //finish();
            Intent Intent = new Intent(profile.this, MainActivity.class);
            Intent.putExtra("currentuser", user);
            FirebaseUtils.addUser(user);
            startActivity(Intent);
        }
    });
    }
}