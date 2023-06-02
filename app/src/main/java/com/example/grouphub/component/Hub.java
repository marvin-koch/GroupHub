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

    private String hubId;


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

        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("hubs");
        hubId = hubsRef.push().getKey();
        hubsRef.child(hubId).setValue(this);
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
                String category = dataSnapshot.getValue(String.class);
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
                Location location = dataSnapshot.getValue(Location.class);
                listener.onObjectRead(location);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }

    public void setLocation(Location location) {
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

    public void getPhoto(ObjectListener listener) {
        DatabaseReference hubRef = FirebaseDatabase.getInstance().getReference("hubs").child(hubId).child("photo");

        hubRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Image photo = dataSnapshot.getValue(Image.class);
                listener.onObjectRead(photo);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onObjectReadError(databaseError.getMessage());
            }
        });
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("hubs");
        hubsRef.child(hubId).child("photo").setValue(photo);


    }

    public List<User> getParticipants() {
        List<User> participants = new ArrayList<>();
        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("hubs").child((hubId)).child("users");
        hubsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                // Get the children of the snapshot
                Iterable<DataSnapshot> children = snapshot.getChildren();

                // Loop through each child
                for (DataSnapshot childSnapshot : children) {
                    Object childValue = childSnapshot.getValue();

                    // Add child value to the list
                    participants.add((User)childValue);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Handle potential error scenarios
                System.out.println("Error: " + error.getMessage());
            }
        });

        return participants;
    }


    public void addUser(User user) {
        if (currentParticipants - 1 == maxParticipants) {
            System.out.println("Max capacity reached");
        }else{
            participants.add(user);
            currentParticipants++;
            setCurrentParticipants(currentParticipants);

            final String[] userId = new String[1];
            ObjectListener listener = new ObjectListener() {
                @Override
                public void onObjectRead(Object id) {
                    // Store the description value in the variable
                    userId[0] = (String) id;
                }

                @Override
                public void onObjectReadError(Object errorMessage) {
                    // Handle any errors while reading the description
                    return;
                }
            };
            DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("hubs");
            hubsRef.child(hubId).child("users").child(userId[0]).setValue(userId[0]);
        }

    }

    public void removeUser(User user) {
        participants.remove(user);
        currentParticipants--;
        setCurrentParticipants(currentParticipants);

        final String[] userId = new String[1];
        ObjectListener listener = new ObjectListener() {
            @Override
            public void onObjectRead(Object id) {
                // Store the description value in the variable
                userId[0] = (String) id;
            }

            @Override
            public void onObjectReadError(Object errorMessage) {
                // Handle any errors while reading the description
                return;
            }
        };

        user.getUserId(listener);
        DatabaseReference hubsRef = FirebaseUtils.getDatabase().getReference("hubs");
        hubsRef.child(hubId).child("users").child(userId[0]).removeValue();
    }



}
