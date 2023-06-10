package com.example.grouphub.component;
import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginHandler {
    public static User currentUser;

    public static void setCurrentUser(User user) {
       currentUser = user;
    }

    public static void loginUser(Activity activity, String email, String password, final OnLoginCompleteListener listener) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // User login success
                            String userId = mAuth.getCurrentUser().getUid();
                            Log.d("log", userId);
                            Log.d("log", "onObjectRead: 1");

                            ObjectListener Olistener = new ObjectListener() {
                                @Override
                                public void onObjectRead(Object id) {
                                    // Store the description value in the variable
                                    User current = (User) id;

                                    Log.d("log", "onObjectRead: 2");
                                    setCurrentUser(current);
                                    Log.d("log", "onObjectRead: 3");
                                    listener.onLoginSuccess();

                                }

                                @  Override
                                public void onObjectReadError(Object errorMessage) {
                                    // Handle any errors while reading the description
                                    return;
                                }
                            };
                            FirebaseUtils.getUser(Olistener, userId);

                        } else {
                            // User login failed
                            listener.onLoginFailure(task.getException().getMessage());
                        }
                    }
                });
    }

    public interface OnLoginCompleteListener {
        void onLoginSuccess();
        void onLoginFailure(String errorMessage);
    }
}
