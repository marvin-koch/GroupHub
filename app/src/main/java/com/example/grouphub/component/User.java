package com.example.grouphub.component;

import android.location.Location;
import android.media.Image;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**

public class User {
    private String name;
    private String phoneNumber;
    private int age;
    private String hub;
    private String userId;
    private String role;

    public User(String name, String phoneNumber, int age, String userId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.userId = userId;
        DatabaseReference userRef = FirebaseUtils.getDatabase().getReference("users").child(userId);
        /**userId = userRef.push().getKey();
        userRef.child(userId).setValue(this);*/
/**
        userRef.child("name").setValue(name);
        userRef.child("phoneNumber").setValue(phoneNumber);
        userRef.child("age").setValue(age);
        userRef.child("userId").setValue(userId);


    }

    public void getUserId(ObjectListener listener) {
        DatabaseReference hubRef = FirebaseUtils.getDatabase().getReference("users").child(userId).child("userId");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String userId = dataSnapshot.getValue(String.class);
                listener.onObjectRead(userId);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }
    public void getName(ObjectListener listener) {

        DatabaseReference hubRef = FirebaseUtils.getDatabase().getReference("users").child(userId).child("name");
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
        /**
        String[] l = new String[1];
        String a = "";
         */

        /**
        hubRef.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull
                                   Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    Log.d("ch", "chhhh");
                    l[0] = (String) task.getResult().getValue();
                }
            }
        });


        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("changed", dataSnapshot.getValue(String.class));
                l[0] = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                throw databaseError.toException(); // Don't ignore errors
            }
        });


        return l[0];
         */
        /**
    }

    /**
    public void setName(String name) {
        this.name = name;
        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("users");
        Log.d("set","set");
        hubsRef.child(userId).child("name").setValue(name);
    }

    public void getPhoneNumber(ObjectListener listener) {
         DatabaseReference hubRef = FirebaseUtils.getDatabase().getReference("users").child(userId).child("phoneNumber");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String phoneNumber = dataSnapshot.getValue(String.class);
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
                String age = dataSnapshot.getValue(String.class);
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
                String hub = dataSnapshot.getValue(String.class);
                listener.onObjectRead(hub);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }

    public void setHub(Hub hub) {

        ObjectListener listener = new ObjectListener() {
            @Override
            public void onObjectRead(Object id) {
                // Store the description value in the variable
                String hubId = (String) id;
                DatabaseReference userRef = FirebaseUtils.getDatabase().getReference("users");
                userRef.child("hub").setValue(hubId);
            }

            @Override
            public void onObjectReadError(Object errorMessage) {
                // Handle any errors while reading the description
                return;
            }
        };
        hub.getHubId(listener);

    }
    public void joinHub(Hub hub) {
        setHub(hub);
        hub.addUser(this);
    }

    public void createHub(String name, String category, String tag, String description, int maxParticipants, int currentParticipants, String location, int rating) {
        Hub hub = new Hub(name,category, tag,description, maxParticipants, currentParticipants, location, rating, new ArrayList<>());
        setHub(hub);
        hub.addUser(this);
        role = "FACILITATOR";
    }

    /**
    public void rateHub(int rating) {
        if (hub != null) {
            hub.setRating(rating);
        }
    }

    public void remove_member(User participant){
        if (role == "FACILITATOR"){
            hub.removeUser(participant);
        }
    }

    public void accept_member(User participant){
        if (role == "FACILITATOR"){
            hub.addUser(participant);
        }
    }

    public void edit_group_info(String desc){
        if (role == "FACILITATOR"){
            hub.setDescription(desc);
        }
    }
     */

    /**
    public void setRole(String role) {
        this.role = role;
        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("users");
        hubsRef.child(userId).child("tag").setValue(role);
    }

    public void getRole(ObjectListener listener){
        DatabaseReference hubRef = FirebaseDatabase.getInstance().getReference("users").child(userId).child("role");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String role = dataSnapshot.getValue(String.class);
                listener.onObjectRead(role);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }

    public void transfer_leadership(User newLeader){
        if (role == "FACILITATOR"){
            this.setRole("PARTICIPANT");
            newLeader.setRole("FACILITATOR");
        }else {
            this.setRole("FACILITATOR");
            newLeader.setRole("PARTICIPANT");
        }
    }
}
*/
public class User implements Serializable {
    private String name;
    private String phoneNumber;
    private String hub;
    private String userId;
    private String email;
    private String description;

    private String role;

    public User(){
        name = "";
        email = "";
        phoneNumber = "";
        userId = "";
        description = "";
        hub = "";

    }
    public User(String email, String name, String phoneNumber, String description, String userId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.description = description;
        this.userId = userId;
        hub = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getHub() {
        return hub;
    }

    public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
}

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setHub(String hub) {
        this.hub = hub;
    }

    public void joinHub(Hub hub) {
        setHub(hub.getHubId());
        hub.addUser(this);
    }

    public void createHub(String name, String category, String tag, String description, int maxParticipants, int currentParticipants, String location, int rating, String hubId) {
        Hub hub = new Hub(name, category, tag, description, maxParticipants, currentParticipants, location, rating, new ArrayList<>(), hubId);
        setHub(hub.getHubId());
        hub.addUser(this);
        role = "FACILITATOR";
    }

    public String getDescription() {
        return description;
    }

    public void setRole(String role) {
    this.role = role;
}

    public String getRole() {
        return role;
    }

    public String getUserId() {
        return userId;
    }

    public void transferLeadership(User newLeader) {
        if (role.equals("FACILITATOR")) {
            this.setRole("PARTICIPANT");
            newLeader.setRole("FACILITATOR");
        } else {
            this.setRole("FACILITATOR");
            newLeader.setRole("PARTICIPANT");
        }
    }
}


