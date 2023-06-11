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

    public void setDescription(String description) {
        this.description = description;
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


