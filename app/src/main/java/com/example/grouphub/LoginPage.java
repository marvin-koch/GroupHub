package com.example.grouphub;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.grouphub.component.LoginHandler;

public class LoginPage extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aribah);

        Button buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(v -> {
            EditText editTextUsername = findViewById(R.id.editkeywords);
            String usernameInput = editTextUsername.getText().toString();
            if (usernameInput.matches(".*[\\\\/:*?|<>\"].*")) {
                // The username contains invalid characters
                editTextUsername.setError("Username cannot contain \\ / : * ? | < > \"");
            } else {
                // The username is valid
                // send username to DB
            }

            EditText editTextPassword = findViewById(R.id.editgroupdesc);
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

                LoginHandler.loginUser(this, usernameInput, passwordInput, new LoginHandler.OnLoginCompleteListener() {
                    @Override
                    public void onLoginSuccess() {
                        // User registration success

                        Intent intent = new Intent(LoginPage.this, MainActivity.class);
                        intent.putExtra("currentuser", LoginHandler.currentUser);

                        startActivity(intent);

                        // Additional user data is already stored in the database
                    }

                    @Override
                    public void onLoginFailure(String errorMessage) {
                        // User registration failed
                    }
                });
            }
        });

        View textViewCreateAccount = findViewById(R.id.textViewCreateAccount);
        textViewCreateAccount.setOnClickListener(v -> {
            Intent intent = new Intent(LoginPage.this, SignupPage.class);
            startActivity(intent);
        });
    }

}


