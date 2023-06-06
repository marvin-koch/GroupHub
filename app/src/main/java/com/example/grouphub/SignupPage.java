package com.example.grouphub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupPage extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        Button buttonSignup = findViewById(R.id.buttonSignup);

        buttonSignup.setOnClickListener(v -> {
            EditText editTextUsername = findViewById(R.id.editTextUsername);
            String usernameInput = editTextUsername.getText().toString();
            if (usernameInput.matches(".*[\\\\/:*?|<>\"].*")) {
                // The username contains invalid characters
                editTextUsername.setError("Username cannot contain \\ / : * ? | < > \"");
            } else {
                // the username should be checked with existing
                // usernames so that it is unique


                // then it is valid
                // send username to DB
            }

            EditText editTextPassword = findViewById(R.id.editTextPassword);
            String passwordInput = editTextPassword.getText().toString();
            if (passwordInput.length() < 8) {
                editTextPassword.setError("Password must be at least 8 characters long");
            } else if (!passwordInput.matches(".*[a-z].*")) {
                editTextPassword.setError("Password must contain at least one lowercase letter");
            } else if (!passwordInput.matches(".*[A-Z].*")) {
                editTextPassword.setError("Password must contain at least one uppercase letter");
            } else if (!passwordInput.matches(".*[0-9].*")) {
                editTextPassword.setError("Password must contain at least one number");
            } else if (!passwordInput.matches(".*[!@#$%^&*()].*")) {
                editTextPassword.setError("Password must contain at least one special character (!@#$%^&*())");
            } else {
                // The password is valid
                // send password to DB
            }

            EditText editTextPhone = findViewById(R.id.editTextPhone);
            String phoneInput = editTextPhone.getText().toString();
            // add phone number to DB

        });

        View textViewLogin = findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(v -> {
            Intent intent = new Intent(SignupPage.this, LoginPage.class);
            startActivity(intent);
        });
    }
}
