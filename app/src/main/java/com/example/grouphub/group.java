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
import com.example.grouphub.component.LoginHandler;
import com.example.grouphub.component.ObjectListener;
import com.example.grouphub.component.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class group extends Activity {
// SOLVE PROBLEM BY PASSING CURRENT USER IN INTENT

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_info);

        Intent intent = getIntent();
        Hub currentHub = (Hub)intent.getSerializableExtra("hub");
        User currentuser = (User) intent.getSerializableExtra("currentuser");
        Log.d("group debug", currentHub.getHubId());
        // Inflate the layout to access its views
        // Replace "activity_main" with your actual layout file name
        // For example, if your layout file is "my_layout.xml", use R.layout.my_layout
        setContentView(R.layout.group_info);

        // Access the TextView using its id from the inflated layout
        TextView tv = findViewById(R.id.text_name);
        tv.setText(currentHub.getName());
        TextView tv1 = findViewById(R.id.text_desc);
        tv1.setText(currentHub.getDescription());
        TextView tv2 = findViewById(R.id.text_member);
        tv2.setText(Integer.toString(currentHub.getCurrentParticipants()));
        ImageView Iv = findViewById(R.id.imageView3);
        Iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_black_24dp));
        Button myButton = findViewById(R.id.button4);








        myButton.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                /**
                LoginHandler.currentUser.joinHub(currentHub);
                FirebaseUtils.addUser(LoginHandler.currentUser);
                FirebaseUtils.addHub(currentHub);
                 */
                currentuser.joinHub(currentHub);
                FirebaseUtils.addUser(currentuser);
                FirebaseUtils.addHub(currentHub);

                // Display a pop
                AlertDialog.Builder builder = new AlertDialog.Builder(group.this);
                builder.setTitle("Button Clicked")
                        .setMessage("You have successfully joined!")
                        .setPositiveButton("Close", new DialogInterface.OnClickListener() {
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

