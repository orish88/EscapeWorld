package com.sh.ori.escapeworld.GameObjects;


import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A place on the map. Every place has a riddle and an item.
 */
public class Place implements Serializable{

    private static int idGen = 4000000;
    private int id;
    private String title;
    private String enterDescription;
    private String exitDescription;
    private ArrayList<Riddle> riddles;
    private ArrayList<Item> items;
    private boolean revealed;
    private LatLng location;
    private ArrayList<Integer> itemRewardIds;
    private ArrayList<Integer> placeRewardIds;

    public Place(String title, String enterDescription, String exitDescription, ArrayList<Riddle> riddles, ArrayList<Item> items,
                 boolean revealed, LatLng location, ArrayList<Integer> itemRewardIds, ArrayList<Integer> placeRewardIds) {
        this.id = idGen++;
        this.title = title;
        this.enterDescription = enterDescription;
        this.exitDescription = exitDescription;
        this.riddles = riddles;
        this.items = items;
        this.revealed = revealed;
        this.location = location;
        this.itemRewardIds = itemRewardIds;
        this.placeRewardIds = placeRewardIds;
    }

    public Place(String title, String enterDescription, String exitDescription,
                 ArrayList<Riddle> riddles, ArrayList<Item> items, boolean revealed, LatLng location) {
        this.id = idGen++;
        this.title = title;
        this.enterDescription = enterDescription;
        this.exitDescription = exitDescription;
        this.riddles = riddles;
        this.items = items;
        this.revealed = revealed;
        this.location = location;
        this.itemRewardIds = new ArrayList<Integer>();
        this.placeRewardIds = new ArrayList<Integer>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnterDescription() {
        return enterDescription;
    }

    public void setEnterDescription(String enterDescription) {
        this.enterDescription = enterDescription;
    }

    public String getExitDescription() {
        return exitDescription;
    }

    public void setExitDescription(String exitDescription) {
        this.exitDescription = exitDescription;
    }

    public ArrayList<Riddle> getRiddles() {
        return riddles;
    }

    public void setRiddles(ArrayList<Riddle> riddles) {
        this.riddles = riddles;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public void addPrizePlace(int idToAdd){
        if(this.placeRewardIds != null){
            this.placeRewardIds.add(idToAdd);
        }
    }
    public void removePrizePlace(int idToAdd){
        if(this.placeRewardIds != null){
            this.placeRewardIds.remove(idToAdd);
        }
    }

    public void addPrizeItem(int idToAdd){
        if(this.itemRewardIds != null){
            this.itemRewardIds.add(idToAdd);
        }
    }
    public void removePrizeItem(int idToAdd){
        if(this.itemRewardIds != null){
            this.itemRewardIds.remove(idToAdd);
        }
    }
}
