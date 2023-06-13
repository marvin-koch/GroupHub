package com.example.grouphub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.grouphub.component.FirebaseUtils;
import com.example.grouphub.component.Hub;
import com.example.grouphub.component.User;

import org.w3c.dom.Text;

public class joined_groups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joined_groups);
        ImageButton return_to_profile = findViewById(R.id.return_to_main);
        Button leave_group = findViewById(R.id.leave_group);
        Hub hub = (Hub) getIntent().getSerializableExtra("hub");
        User user = (User) getIntent().getSerializableExtra("user");
        TextView name = findViewById(R.id.current_username);
        TextView desc = findViewById(R.id.personal_desc_text);
        TextView part = findViewById(R.id.contact_information_text);
        name.setText(hub.getName());
        desc.setText(hub.getDescription());
        part.setText(String.join(",", hub.getParticipants()));


        return_to_profile.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent Intent = new Intent(joined_groups.this, profile.class);
                Intent.putExtra("user", user);
                startActivity(Intent);
            }
        });

        leave_group.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //implement leave group
                user.leaveHub(hub);
                FirebaseUtils.addHub(hub);
                FirebaseUtils.addUser(user);
                Intent Intent = new Intent(joined_groups.this, profile.class);
                Intent.putExtra("user", user);
                startActivity(Intent);
            }
        });
    }
}