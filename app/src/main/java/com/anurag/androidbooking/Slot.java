package com.anurag.androidbooking;

public class Slot {
    private String name;
    private String email;
    private String uniqueId;

    // Add a no-argument constructor
    public Slot() {
        // Required empty constructor for Firestore deserialization
    }

    public Slot(String name, String email, String uniqueId) {
        this.name = name;
        this.email = email;
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUniqueId() {
        return uniqueId;
    }
}
