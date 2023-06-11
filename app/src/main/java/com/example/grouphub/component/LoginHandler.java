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
                            FirebaseUtils.addHub(new Hub("Exciting Football Match", "sport", "football", "join us for an exhilarating match", 22, 0, "Seoul Stadium", 3, new ArrayList<>(), "11233"));
                            FirebaseUtils.addHub(new Hub("Grand Piano Concert", "music", "piano", "experience the magic of piano melodies", 22, 0, "Symphony Hall", 5, new ArrayList<>(), "13234"));
                            FirebaseUtils.addHub(new Hub("Group Study Session", "study", "revision", "improve your knowledge with us", 22, 0, "Seoul Library", 4, new ArrayList<>(), "10002"));
                            FirebaseUtils.addHub(new Hub("Summer Football Tournament", "sport", "football", "join the ultimate football tournament", 16, 0, "City Stadium", 8, new ArrayList<>(), "45671"));
                            FirebaseUtils.addHub(new Hub("Rock & Roll Extravaganza", "music", "concert", "experience the energy of live music", 20, 0, "Music Arena", 5, new ArrayList<>(), "7890"));
                            FirebaseUtils.addHub(new Hub("Math Study Group", "study", "mathematics", "enhance your math skills with us", 18, 0, "Study Center", 3, new ArrayList<>(), "2345"));
                            FirebaseUtils.addHub(new Hub("Web Development Workshop", "coding", "web development", "learn the essentials of building websites", 10, 0, "Tech Center", 4, new ArrayList<>(), "1111"));
                            FirebaseUtils.addHub(new Hub("Python Coding Bootcamp", "coding", "python", "master Python programming language in just 4 weeks", 25, 0, "Code Academy", 5, new ArrayList<>(), "2222"));
                            FirebaseUtils.addHub(new Hub("AI Hackathon", "coding", "artificial intelligence", "collaborate and build innovative AI solutions", 48, 0, "Innovation Center", 7, new ArrayList<>(), "3333"));
                            FirebaseUtils.addHub(new Hub("Modern Art Exhibition", "art", "exhibition", "explore captivating modern artworks", 22, 0, "Art Gallery", 4, new ArrayList<>(), "100088"));
                            FirebaseUtils.addHub(new Hub("Oil Painting Workshop", "art", "painting", "unleash your creativity with oil painting techniques", 18, 0, "Art Studio", 3, new ArrayList<>(), "100000"));
                            FirebaseUtils.addHub(new Hub("Sculpture Making Class", "art", "sculpture", "learn the art of sculpting with expert guidance", 20, 0, "Art Academy", 5, new ArrayList<>(), "100023"));




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
