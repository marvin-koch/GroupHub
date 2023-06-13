package com.example.grouphub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.grouphub.component.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class profile_change_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_change_password);
        User user = (User) getIntent().getSerializableExtra("user");

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
            String passwordInput = new_password.getText().toString();
            String passwordConfirm = confirm_password.getText().toString();

            if (passwordInput.length() < 8) {
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
                FirebaseUser firebaseuser = FirebaseAuth.getInstance().getCurrentUser();
                AuthCredential credential = EmailAuthProvider.getCredential(firebaseuser.getEmail(), old_password);
                firebaseuser.reauthenticate(credential)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    // User reauthenticated successfully
                                    // Proceed to change the password

                                    firebaseuser.updatePassword(passwordInput)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        // Password updated successfully
                                                        // Inform the user about the password change
                                                        Intent Intent = new Intent(profile_change_password.this, profile_edit.class);
                                                        Intent.putExtra("user", user);
                                                        startActivity(Intent);

                                                    } else {
                                                        // Password update failed
                                                        // Handle the error
                                                    }
                                                }
                                            });
                                } else {
                                    // Reauthentication failed
                                    // Handle the error
                                    editTextPassword.setError("Incorrect password");
                                }
                            }
                        });
            }

        });

    }
}