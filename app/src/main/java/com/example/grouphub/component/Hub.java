package com.example.grouphub.component;

import android.location.Location;
import android.media.Image;

import java.util.List;

public class Hub {
    private String name;
    private String category;
    private String tag;
    private String description;
    private int maxParticipants;
    private int currentParticipants;
    private Location location;
    private int rating;
    private Image photo;
    private List<User> participants;


    public Hub(String name, String category, String tag, String description, int maxParticipants, int currentParticipants, Location location, int rating, Image photo, List<User> participants) {
        this.name = name;
        this.category = category;
        this.tag = tag;
        this.description = description;
        this.maxParticipants = maxParticipants;
        this.currentParticipants = currentParticipants;
        this.location = location;
        this.rating = rating;
        this.photo = photo;
        this.participants = participants;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public int getRating(int rating) {
        return rating;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public void addUser(User user) {
        if (currentParticipants - 1 == maxParticipants) {
            System.out.println("Max capacity reached");
        }else{
            participants.add(user);
            currentParticipants++;
        }

    }

    public void removeUser(User user) {
        participants.remove(user);
        currentParticipants--;
    }



}
