package com.example.grouphub.component;

public class User {
    private String name;
    private String phoneNumber;
    private int age;
    private Hub hub;

    private UserType role;

    public User(String name, String phoneNumber, int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Hub getHub() {
        return hub;
    }

    public void joinHub(Hub hub) {
        this.hub = hub;
        hub.addUser(this);
    }

    public Hub createHub(String name) {
        Hub hub = new Hub(name);
        this.hub = hub;
        hub.addUser(this);
        return hub;
    }

    public void rateHub(int rating) {
        if (hub != null) {
            hub.addRating(rating);
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

    public void transfer_leadership(User newLeader){
        if (role == UserType.FACILITATOR){
            role = UserType.PARTICIPANT;
            newLeader.role = UserType.FACILITATOR;
        }else{
            newLeader.role = UserType.PARTICIPANT;
            role = UserType.FACILITATOR;
        
    }
}

enum UserType {
    PARTICIPANT, FACILITATOR, NO_GROUP;
}
