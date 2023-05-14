package com.example.grouphub;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.grouphub.databinding.ActivityMainBinding;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class group extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_info);

        // Inflate the layout to access its views
        // Replace "activity_main" with your actual layout file name
        // For example, if your layout file is "my_layout.xml", use R.layout.my_layout
        setContentView(R.layout.group_info);

        // Access the TextView using its id from the inflated layout
        TextView tv = findViewById(R.id.text_name);
        tv.setText("Group name here");
        TextView tv1 = findViewById(R.id.text_desc);
        tv1.setText("Group description here");
        TextView tv2 = findViewById(R.id.text_member);
        tv1.setText("Group members here");
    }




}

