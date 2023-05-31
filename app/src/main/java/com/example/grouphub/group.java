package com.example.grouphub;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
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
        ImageView Iv = findViewById(R.id.imageView3);
        Iv.setImageDrawable(getResources().getDrawable(R.drawable.ic_dashboard_black_24dp));
        Button myButton = findViewById(R.id.button4);
        myButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Display a pop-up dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(group.this);
                builder.setTitle("Button Clicked")
                        .setMessage("You clicked the button!")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Perform any additional actions or dismiss the dialog
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });


    }




}

