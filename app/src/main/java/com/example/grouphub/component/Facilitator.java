package com.example.grouphub.component;

public class Facilitator extends User{
    public Facilitator(String name, String phoneNumber, int age) {
        super(name, phoneNumber, age);
    }

    public void remove_member(User participant){
        getHub().removeUser(participant);
    }

    public void accept_member(User participant){
        getHub().addUser(participant);
    }

    public void edit_group_info(String desc){
        getHub().setDescription(desc);
    }

    public void transfer_leadership(self, User newLeader){
        newLeader.getClass().cast(Facilitator);

    }
}
