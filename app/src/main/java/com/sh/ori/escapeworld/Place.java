package com.sh.ori.escapeworld;


import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

/**
 * A place on the map. Every place has a riddle and an item.
 */
public class Place implements Serializable{
    private int id;
    private String name;
    private String enterDescription;
    private String exitDescription;
    private Riddle riddle;
    private int itemId;
    private boolean revealed;
    private LatLng location;


    public Place(int id, String name, String enterDescription, String exitDescription,
                 Riddle riddle, int itemId, LatLng location) {
        this.id = id;
        this.name = name;
        this.enterDescription = enterDescription;
        this.exitDescription = exitDescription;
        this.riddle = riddle;
        this.itemId = itemId;
        this.revealed = false;
        this.location = location;

    }

    public boolean isRevealed(){
        return this.revealed;
    }

    public LatLng getLocation(){
        return this.location;
    }

    public int getId() {
        return id;
    }

    public void revealLoc(){
        this.revealed = true;
    }

    public String getName() {
        return name;
    }

    public String getEnterDescriptionescription() {
        return enterDescription;
    }

    public String getExitDescriptionescription() {
        return exitDescription;
    }

    public Riddle getRiddle() {
        return riddle;
    }

    public int getItemId() {
        return itemId;
    }

}
