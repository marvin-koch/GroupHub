package com.example.grouphub.component;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseUtils {

    private static FirebaseDatabase mDatabase;

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }
        return mDatabase;
    }

    public static void addUser(User user){
        getDatabase().getReference("users").child(user.getUserId()).setValue(user);
    }
    public static void addHub(Hub hub){
        getDatabase().getReference("hubs").child(hub.getHubId()).setValue(hub);
    }

    public static void getUser(ObjectListener listener, String userId){
        getDatabase().getReference("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                listener.onObjectRead(user);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }
    public static void getHub(ObjectListener listener, String hubId){
        getDatabase().getReference("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Hub hub = dataSnapshot.getValue(Hub.class);
                listener.onObjectRead(hub);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }

}
