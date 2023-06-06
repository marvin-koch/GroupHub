package com.example.grouphub;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grouphub.component.FirebaseUtils;
import com.example.grouphub.component.Hub;
import com.example.grouphub.component.ObjectListener;
import com.example.grouphub.component.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
        ImageView Iv = findViewById(R.id.imageView3);
        Iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_black_24dp));
        Button myButton = findViewById(R.id.button4);
        User test = new User("mister", "092134902", 21, "788939");
        Hub hub = new Hub("huber", "cat", "dog", "it's a hub", 11, 0, "loc", 3, new ArrayList<>(), "1");
        test.joinHub(hub);
        ArrayList part = hub.getParticipants();
        for (Object p:part) {
            Log.d("user", ((User)p).getUserId());
        }

        FirebaseUtils.addUser(test);
        FirebaseUtils.addHub(hub);

        ObjectListener listener = new ObjectListener() {
            @Override
            public void onObjectRead(Object id) {
                // Store the description value in the variable
                User s = (User) id;
                Log.d("here", s.getUserId());

            }

            @  Override
            public void onObjectReadError(Object errorMessage) {
                // Handle any errors while reading the description
                return;
            }
        };






        myButton.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                /**
                ObjectListener listener = new ObjectListener() {
                    @Override
                    public void onObjectRead(Object id) {
                        // Store the description value in the variable
                        ArrayList part = (ArrayList) id;
                        Log.d("here", "here");
                        for (Object p:part) {
                            Log.d("user", (String) p);
                        }
                    }

                    @  Override
                    public void onObjectReadError(Object errorMessage) {
                        // Handle any errors while reading the description
                        return;
                    }
                };
                hub.getParticipants(listener);
                 */

                FirebaseUtils.getUser(listener, test.getUserId());
                // Display a pop
                AlertDialog.Builder builder = new AlertDialog.Builder(group.this);
                builder.setTitle("Button Clicked")
                        .setMessage("You want to join? Well, too bad you cannot ")
                        .setPositiveButton("Fuck off", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Perform any additional actions or dismiss the dialog
                                dialog.dismiss();
                            }
                        })
                        .show();



            }
        });
        ImageButton ib = findViewById(R.id.imageButton5);
        ib.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent Intent = new Intent(group.this, placeholder.class);
                startActivity(Intent);
            }
        });


    }




}

