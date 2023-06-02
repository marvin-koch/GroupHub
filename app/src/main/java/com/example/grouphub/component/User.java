package com.example.grouphub.component;

import android.location.Location;
import android.media.Image;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class User {

    enum UserType {
        PARTICIPANT, FACILITATOR, NO_GROUP;
    }
    private String name;
    private String phoneNumber;
    private int age;
    private Hub hub;

    private String userId;
    private UserType role;

    public User(String name, String phoneNumber, int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        DatabaseReference userRef = FirebaseUtils.getDatabase().getReference("users");
        userId = userRef.push().getKey();
        userRef.child(userId).setValue(this);
    }

    public void getUserId(ObjectListener listener) {
        DatabaseReference hubRef = FirebaseDatabase.getInstance().getReference("users").child(userId).child("userId");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue(String.class);
                listener.onObjectRead(userId);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }
    public void getName(ObjectListener listener) {

        DatabaseReference hubRef = FirebaseDatabase.getInstance().getReference("users").child(userId).child("name");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue(String.class);
                listener.onObjectRead(name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }

    public void setName(String name) {
        this.name = name;
        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("users");
        hubsRef.child(userId).child("name").setValue(name);
    }

    public void getPhoneNumber(ObjectListener listener) {
        DatabaseReference hubRef = FirebaseDatabase.getInstance().getReference("users").child(userId).child("phoneNumber");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue(String.class);
                listener.onObjectRead(phoneNumber);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("users");
        hubsRef.child(userId).child("phoneNumber").setValue(phoneNumber);
    }

    public void getAge(ObjectListener listener) {
        DatabaseReference hubRef = FirebaseDatabase.getInstance().getReference("users").child(userId).child("age");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue(String.class);
                listener.onObjectRead(age);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }

    public void setAge(int age) {
        this.age = age;
        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("users");
        hubsRef.child(userId).child("age").setValue(age);
    }

    public void getHub(ObjectListener listener) {
        DatabaseReference hubRef = FirebaseDatabase.getInstance().getReference("users").child(userId).child("hub");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue(String.class);
                listener.onObjectRead(hub);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }

    public void joinHub(Hub hub) {
        this.hub = hub;
        hub.addUser(this);
    }

    public Hub createHub(String name, String category, String tag, String description, int maxParticipants, int currentParticipants, Location location, int rating, Image photo) {
        Hub hub = new Hub(name,category, tag,description, maxParticipants, currentParticipants, location, rating, photo, new ArrayList<>());
        this.hub = hub;
        hub.addUser(this);
        role = UserType.FACILITATOR;
        return hub;
    }

    public void rateHub(int rating) {
        if (hub != null) {
            hub.setRating(rating);
        }
    }

    public void remove_member(User participant){
        if (role == UserType.FACILITATOR){
            hub.removeUser(participant);
        }
    }

    public void accept_member(User participant){
        if (role == UserType.FACILITATOR){
            hub.addUser(participant);
        }
    }

    public void edit_group_info(String desc){
        if (role == UserType.FACILITATOR){
            hub.setDescription(desc);
        }
    }

    public void setRole(UserType role) {
        this.role = role;
        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("users");
        hubsRef.child(userId).child("tag").setValue(role);
    }

    public void getRole(ObjectListener listener){
        DatabaseReference hubRef = FirebaseDatabase.getInstance().getReference("users").child(userId).child("role");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue(String.class);
                listener.onObjectRead(role);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }

    public void transfer_leadership(User newLeader){
        if (role == UserType.FACILITATOR){
            this.setRole(UserType.PARTICIPANT);
            newLeader.setRole(UserType.FACILITATOR);
        }else {
            this.setRole(UserType.FACILITATOR);
            newLeader.setRole(UserType.PARTICIPANT);
        }
    }
}


