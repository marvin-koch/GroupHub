package com.example.grouphub.component;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

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
        getDatabase().getReference("hubs").child("hub").child(hub.getHubId()).setValue(hub);
    }

    public static void getUser(ObjectListener listener, String userId){
        getDatabase().getReference("users").child(userId).addValueEventListener(new ValueEventListener() {
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
        getDatabase().getReference("hubs").child("hub").child(hubId).addValueEventListener(new ValueEventListener() {
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

    public static void getHubs(ObjectListener listener){
        Log.d("gethubs", "getHubs: 1");
        getDatabase().getReference("hubs").child("hub").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.d("fire", "onDataChange: 1");
                ArrayList<Hub> hubs = new ArrayList<>();
                // Get the children of the snapshot
                Iterable<DataSnapshot> children = snapshot.getChildren();
                Log.d("fire", "onDataChange: 2");
                // Loop through each child
                for (DataSnapshot childSnapshot : children) {
                    Object childValue = childSnapshot.getValue(Hub.class);

                    // Add child value to the list
                    hubs.add((Hub)childValue);
                }
                Log.d("fire", "onDataChange: 3");
                listener.onObjectRead(hubs);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Handle potential error scenarios
                System.out.println("Error: " + error.getMessage());
            }
        });
    }

}
