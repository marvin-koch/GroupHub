package com.example.grouphub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class profile_view_groups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_view_groups);
    Button return_to_profile = findViewById(R.id.back_to_profile);

    TextView group_name1 = findViewById(R.id.group_name1);
    TextView category1 = findViewById(R.id.category1);
    TextView description1 = findViewById(R.id.description1);

    return_to_profile.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();
            }
        });

    group_name1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Intent = new Intent(profile_view_groups.this, joined_groups.class);
                startActivity(Intent);
            }
        });
    category1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Intent = new Intent(profile_view_groups.this, joined_groups.class);
                startActivity(Intent);
            }
        });
    description1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Intent = new Intent(profile_view_groups.this, joined_groups.class);
                startActivity(Intent);
            }
        });
    }
}