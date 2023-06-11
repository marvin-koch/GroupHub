package com.example.grouphub.component;
import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

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
                            FirebaseUtils.getDatabase().getReference("hubs").child("hub").setValue("hub");
                            FirebaseUtils.addHub(new Hub("Football game", "sport", "football","crazy game", 22, 0, "Sejeong", 3, new ArrayList<>(), "1123"));
                            FirebaseUtils.addHub(new Hub("Piano Playing", "music", "piano","come play piano", 22, 0, "KAIST", 5, new ArrayList<>(), "1323"));
                            FirebaseUtils.addHub(new Hub("Study with us", "study", "revision","come revise with us", 22, 0, "Seoul", 4, new ArrayList<>(), "1000"));
                            ObjectListener Olistener = new ObjectListener() {
                                @Override
                                public void onObjectRead(Object id) {
                                    // Store the description value in the variable
                                    User current = (User) id;
                                    setCurrentUser(current);


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
