package com.example.grouphub.component;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpHandler {

    private static FirebaseAuth mAuth;

    public static void signUpUser(Activity activity, String email, String password, String phoneNumber, final OnSignUpCompleteListener listener) {
        mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // User registration success
                            String userId = mAuth.getCurrentUser().getUid();
                            Log.d("sign", userId);
                            FirebaseUtils.addUser(new User(email, email, phoneNumber,"Hi, I'm new to GroupHub", userId));
                            listener.onSignUpSuccess();
                        } else {
                            // User registration failed
                            listener.onSignUpFailure(task.getException().getMessage());
                        }
                    }
                });
    }

    public interface OnSignUpCompleteListener {
        void onSignUpSuccess();
        void onSignUpFailure(String errorMessage);
    }
}
