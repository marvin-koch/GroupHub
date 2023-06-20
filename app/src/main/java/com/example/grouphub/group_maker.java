package com.example.grouphub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.grouphub.component.FirebaseUtils;
import com.example.grouphub.component.Hub;
import com.example.grouphub.component.User;

import java.util.ArrayList;
import java.util.Random;

public class group_maker extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_maker);
        User user = (User) getIntent().getSerializableExtra("user");

        Button buttonSignup = findViewById(R.id.buttonSignup);

        buttonSignup.setOnClickListener(v -> {
            EditText editTextUsername = findViewById(R.id.editname);
            String usernameInput = editTextUsername.getText().toString();

            EditText editTextPassword = findViewById(R.id.editgroupdesc);
            String passwordInput = editTextPassword.getText().toString();

            EditText eloc = findViewById(R.id.location);
            String location = eloc.getText().toString();

            EditText tagedit = findViewById(R.id.tag);
            String tag = tagedit.getText().toString();

            EditText categoryedut = findViewById(R.id.category);
            String category = categoryedut.getText().toString();

            ArrayList<String> part = new ArrayList<>();
            part.add(user.getName());

            Random rand = new Random();

            Hub newhub = new Hub(usernameInput,category,tag,passwordInput,20,1,location,5,part, Integer.toString(rand.nextInt(1000)));
            user.createHub(newhub);

            FirebaseUtils.addUser(user);
            FirebaseUtils.addHub(newhub);

            Intent intent = new Intent(group_maker.this, MainActivity.class);
            intent.putExtra("currentuser", user);

            startActivity(intent);

        });

            View textViewLogin = findViewById(R.id.groupgoback);
            textViewLogin.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
//                    Intent intent = new Intent(group_maker.this, MainActivity.class);
//                    startActivity(intent);
                    finish();
                }
            });

    }

}

