package com.example.grouphub.component;

import android.location.Location;
import android.media.Image;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hub implements Serializable {
    private String name;
    private String category;
    private String tag;
    private String description;
    private int maxParticipants;
    private int currentParticipants;
    private String location;
    private int rating;
    private ArrayList<String> participants;

    private String hubId;

    public Hub(){
        name = "";
        category = "";
        tag = "";
        description = "";
        maxParticipants = 0;
        currentParticipants = 0;
        location = "";
        rating = 0;
        participants = new ArrayList<>();
        hubId = "";

    }

    public Hub(String name, String category, String tag, String description, int maxParticipants, int currentParticipants, String location, int rating, ArrayList<String> participants, String hubId) {
        this.name = name;
        this.category = category;
        this.tag = tag;
        this.description = description;
        this.maxParticipants = maxParticipants;
        this.currentParticipants = currentParticipants;
        this.location = location;
        this.rating = rating;
        this.participants = participants;
        this.hubId = hubId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public int getCurrentParticipants() {
        return currentParticipants;
    }

    public void setCurrentParticipants(int currentParticipants) {
        this.currentParticipants = currentParticipants;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getHubId() {
        return hubId;
    }

    public ArrayList<String> getParticipants() {
        ArrayList<String> participantNames = new ArrayList<>();
        for (String participant : participants) {
            participantNames.add(participant);
        }
        return participantNames;
    }

    public void addUser(User user) {
        if (currentParticipants - 1 == maxParticipants) {
            System.out.println("Max capacity reached");
        } else {
            participants.add(user.getName());
            currentParticipants++;
            setCurrentParticipants(currentParticipants);
        }
    }

    public void removeUser(User user) {
        participants.remove(user.getName());
        currentParticipants--;
        setCurrentParticipants(currentParticipants);
    }
}
