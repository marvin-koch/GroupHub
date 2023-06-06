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

import java.util.ArrayList;
import java.util.List;

/**
public class Hub {
    private String name;
    private String category;
    private String tag;
    private String description;
    private int maxParticipants;
    private int currentParticipants;
    private String location;
    private int rating;
    private List<User> participants;

    private String hubId;


    public Hub(String name, String category, String tag, String description, int maxParticipants, int currentParticipants, String location, int rating, List<User> participants) {
        this.name = name;
        this.category = category;
        this.tag = tag;
        this.description = description;
        this.maxParticipants = maxParticipants;
        this.currentParticipants = currentParticipants;
        this.location = location;
        this.rating = rating;
        this.participants = participants;
        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("hubs");
        hubId = hubsRef.push().getKey();
        hubsRef = FirebaseUtils.getDatabase().getReference("hubs").child(hubId);

        /**hubsRef.child(hubId).setValue(this);*/
/**

        hubsRef.child("name").setValue(name);
        hubsRef.child("category").setValue(category);
        hubsRef.child("tag").setValue(tag);
        hubsRef.child("description").setValue(description);
        hubsRef.child("maxParticipants").setValue(maxParticipants);
        hubsRef.child("currentParticipants").setValue(currentParticipants);
        hubsRef.child("location").setValue(location);
        hubsRef.child("rating").setValue(rating);
        hubsRef.child("participants").setValue(participants);
        hubsRef.child("hubId").setValue(hubId);

    }

    public void getHubId(ObjectListener listener) {
        DatabaseReference hubRef = FirebaseDatabase.getInstance().getReference("hubs").child(hubId).child("hubId");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String hubId = dataSnapshot.getValue(String.class);
                listener.onObjectRead(hubId);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }
    public void getName(ObjectListener listener) {
        DatabaseReference hubRef = FirebaseDatabase.getInstance().getReference("hubs").child(hubId).child("name");

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

    public void getCategory(ObjectListener listener) {
        DatabaseReference hubRef = FirebaseDatabase.getInstance().getReference("hubs").child(hubId).child("category");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String category = dataSnapshot.getValue(String.class);
                listener.onObjectRead(category);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }

    public void setCategory(String category) {
        this.category = category;
        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("hubs");
        hubsRef.child(hubId).child("category").setValue(category);
    }

    public void getTag(ObjectListener listener) {
        DatabaseReference hubRef = FirebaseDatabase.getInstance().getReference("hubs").child(hubId).child("tag");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String tag = dataSnapshot.getValue(String.class);
                listener.onObjectRead(tag);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });

    }

    public void setTag(String tag) {
        this.tag = tag;
        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("hubs");
        hubsRef.child(hubId).child("tag").setValue(tag);

    }

    public void getDescription(ObjectListener listener) {
        DatabaseReference hubRef = FirebaseDatabase.getInstance().getReference("hubs").child(hubId).child("description");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String description = dataSnapshot.getValue(String.class);
                listener.onObjectRead(description);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }

    public void setDescription(String description) {
        this.description = description;
        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("hubs");
        hubsRef.child(hubId).child("description").setValue(description);
    }

    public void getMaxParticipants(ObjectListener listener) {
        DatabaseReference hubRef = FirebaseDatabase.getInstance().getReference("hubs").child(hubId).child("maxParticipants");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String maxParticipants = dataSnapshot.getValue(String.class);
                listener.onObjectRead(maxParticipants);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });

    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("hubs");
        hubsRef.child(hubId).child("maxParticipants").setValue(rating);
    }

    public void getCurrentParticipants(ObjectListener listener) {
        DatabaseReference hubRef = FirebaseDatabase.getInstance().getReference("hubs").child(hubId).child("currentParticipants");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int participants = dataSnapshot.getValue(int.class);
                listener.onObjectRead(participants);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }

    public void setCurrentParticipants(int currentParticipants) {
        this.currentParticipants = currentParticipants;
        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("hubs");
        hubsRef.child(hubId).child("currentParticipants").setValue(currentParticipants);
    }

    public void getLocation(ObjectListener listener) {
        DatabaseReference hubRef = FirebaseDatabase.getInstance().getReference("hubs").child(hubId).child("location");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String location = dataSnapshot.getValue(String.class);
                listener.onObjectRead(location);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }

    public void setLocation(String location) {
        this.location = location;
        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("hubs");
        hubsRef.child(hubId).child("location").setValue(location);
    }

    public void setRating(int rating) {
        this.rating = rating;
        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("hubs");
        hubsRef.child(hubId).child("rating").setValue(rating);
    }


    public void getRating(ObjectListener listener) {
        DatabaseReference hubRef = FirebaseDatabase.getInstance().getReference("hubs").child(hubId).child("rating");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int rating = dataSnapshot.getValue(int.class);
                listener.onObjectRead(rating);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }


    public void getParticipants(ObjectListener listener) {

        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("hubs").child((hubId)).child("users");
        hubsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                ArrayList<String> participants = new ArrayList<>();
                // Get the children of the snapshot
                Iterable<DataSnapshot> children = snapshot.getChildren();

                // Loop through each child
                for (DataSnapshot childSnapshot : children) {
                    Object childValue = childSnapshot.getValue();

                    // Add child value to the list
                    participants.add((String)childValue);
                }
                listener.onObjectRead(participants);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Handle potential error scenarios
                System.out.println("Error: " + error.getMessage());
            }
        });

    }


    public void addUser(User user) {

        ObjectListener listener = new ObjectListener() {
            @Override
            public void onObjectRead(Object id) {
                // Store the description value in the variable
                String userId = (String) id;

                if (currentParticipants - 1 == maxParticipants) {
                    System.out.println("Max capacity reached");
                }else{

                    participants.add(user);
                    currentParticipants++;
                    setCurrentParticipants(currentParticipants);

                    Log.d("add", userId);
                    DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("hubs");
                    hubsRef.child(hubId).child("users").child(userId).setValue(userId);
                }
            }

            @Override
            public void onObjectReadError(Object errorMessage) {
                // Handle any errors while reading the description
                return;
            }
        };
        user.getUserId(listener);


    }

    public void removeUser(User user) {
        participants.remove(user);
        currentParticipants--;
        setCurrentParticipants(currentParticipants);

        ObjectListener listener = new ObjectListener() {
            @Override
            public void onObjectRead(Object id) {
                // Store the description value in the variable
                String userId = (String) id;
                DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("hubs");
                hubsRef.child(hubId).child("users").child(userId).removeValue();
            }

            @Override
            public void onObjectReadError(Object errorMessage) {
                // Handle any errors while reading the description
                return;
            }
        };
        user.getUserId(listener);

    }



}
*/
public class Hub {
    private String name;
    private String category;
    private String tag;
    private String description;
    private int maxParticipants;
    private int currentParticipants;
    private String location;
    private int rating;
    private ArrayList<User> participants;

    private String hubId;

    public Hub(String name, String category, String tag, String description, int maxParticipants, int currentParticipants, String location, int rating, ArrayList<User> participants, String hubId) {
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

    public ArrayList<User> getParticipants() {
        ArrayList<User> participantNames = new ArrayList<>();
        for (User participant : participants) {
            participantNames.add(participant);
        }
        return participantNames;
    }

    public void addUser(User user) {
        if (currentParticipants - 1 == maxParticipants) {
            System.out.println("Max capacity reached");
        } else {
            participants.add(user);
            currentParticipants++;
            setCurrentParticipants(currentParticipants);
        }
    }

    public void removeUser(User user) {
        participants.remove(user);
        currentParticipants--;
        setCurrentParticipants(currentParticipants);
    }
}
