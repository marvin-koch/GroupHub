package com.example.grouphub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class profile_change_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_change_password);

        ImageButton return_to_profile = findViewById(R.id.return_to_main);
        Button change_password = findViewById(R.id.update_password);

        return_to_profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        change_password.setOnClickListener(v -> {
            //check whether current password match and
            //check whether new password and confirm password match
            //update new password to db
            EditText editTextPassword = findViewById(R.id.current_password);
            EditText new_password = findViewById(R.id.editTextPassword);
            EditText confirm_password = findViewById(R.id.editTextPhone);
            String old_password = editTextPassword.getText().toString();
            String current_password = "!Test123";
            String passwordInput = new_password.getText().toString();
            String passwordConfirm = confirm_password.getText().toString();
            if (!old_password.equals(current_password)) {
                editTextPassword.setError("Incorrect password");
            } else if (passwordInput.length() < 8) {
                new_password.setError("Password must be at least 8 characters long");
            } else if (!passwordInput.matches(".*[a-z].*")) {
                new_password.setError("Password must contain at least one lowercase letter");
            } else if (!passwordInput.matches(".*[A-Z].*")) {
                new_password.setError("Password must contain at least one uppercase letter");
            } else if (!passwordInput.matches(".*[0-9].*")) {
                new_password.setError("Password must contain at least one number");
            } else if (!passwordInput.matches(".*[!@#$%^&*()].*")) {
                new_password.setError("Password must contain at least one special character (!@#$%^&*())");
            } else if (!passwordInput.equals(passwordConfirm)){
                confirm_password.setError("Does not match with new password");
            } else {
                // new password is valid
                // update password change to db
                finish();
            }

        });

    }
}