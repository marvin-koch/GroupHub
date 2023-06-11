package com.example.grouphub;

import android.os.Bundle;

import com.example.grouphub.component.FirebaseUtils;
import com.example.grouphub.component.Hub;
import com.example.grouphub.component.LoginHandler;
import com.example.grouphub.component.ObjectListener;
import com.example.grouphub.component.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.grouphub.databinding.ActivityMainBinding;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        ObjectListener hubslistener = new ObjectListener() {

            @Override
            public void onObjectRead(Object id) {
                // Store the description value in the variable
                Log.d("main", "onObjectRead: 6");
                setContentView(binding.getRoot());
                ArrayList<Hub> hubs = (ArrayList<Hub>) id;
                Hub firsthub = hubs.get(0);
                Hub secondhub = hubs.get(1);
                Hub thirdhub = hubs.get(2);
                TextView name1 = (TextView) findViewById(R.id.group_name);
                TextView name2 = (TextView) findViewById(R.id.group_name_2);
                TextView name3 = (TextView) findViewById(R.id.group_name_3);
                TextView rating1 = (TextView) findViewById(R.id.rating);
                TextView rating2 = (TextView) findViewById(R.id.rating_2);
                TextView rating3 = (TextView) findViewById(R.id.rating_3);
                TextView tag1 = (TextView) findViewById(R.id.tags);
                TextView tag2 = (TextView) findViewById(R.id.tags_2);
                TextView tag3 = (TextView) findViewById(R.id.tags_3);

                name1.setText(firsthub.getName());
                name2.setText(secondhub.getName());
                name3.setText(thirdhub.getName());
                rating1.setText(Integer.toString(firsthub.getRating()));
                rating2.setText(Integer.toString(secondhub.getRating()));
                rating3.setText(Integer.toString(thirdhub.getRating()));
                tag1.setText(firsthub.getTag());
                tag2.setText(secondhub.getTag());
                tag3.setText(thirdhub.getTag());

                //BottomNavigationView navView = findViewById(R.id.nav_view);
                // Passing each menu ID as a set of Ids because each
                // menu should be considered as top level destinations.
                AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                        R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                        .build();
                //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
                //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
                //NavigationUI.setupWithNavController(binding.navView, navController);

                name1.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        User current = (User) getIntent().getSerializableExtra("currentuser");
                        Log.d("main", current.getName());
                        Intent intent = new Intent(MainActivity.this, group.class);
                        intent.putExtra("hub", firsthub);
                        intent.putExtra("currentuser", current);
                        startActivity(intent);

                    }

                });
                name2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(MainActivity.this, group.class);
                        intent.putExtra("hub", secondhub);
                        startActivity(intent);

                    }

                });
                 name3.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(MainActivity.this, group.class);
                        intent.putExtra("hub", thirdhub);
                        startActivity(intent);

                    }

                });


                CircleImageView profileImage = findViewById(R.id.profile_image);
                profileImage.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent Intent = new Intent(MainActivity.this, profile.class);
                        startActivity(Intent);

                    }
                });


            }

            @  Override
            public void onObjectReadError(Object errorMessage) {
                // Handle any errors while reading the description
                return;
            }
        };

        FirebaseUtils.getHubs(hubslistener);





    }
}