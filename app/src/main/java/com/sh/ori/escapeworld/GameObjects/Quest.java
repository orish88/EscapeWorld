package com.sh.ori.escapeworld.GameObjects;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * A Quest has a list of places that the player can visit. The player can only see revealed locations. At
 * the beginning of the Quest, only the first location is revealed.
 */
public class Quest implements Serializable {

    private static int idGen = 5000000;
    private int id;
    private String name;
    private String description;
    private ArrayList<Place> places;
    private ArrayList<Item> inventory;
    private ArrayList<String> questLog;

    public Quest(String name, String description, ArrayList<Place> places, ArrayList<Item> inventory, ArrayList<String> questLog) {
        this.id = idGen++;
        this.name = name;
        this.description = description;
        this.places = places;
        this.inventory = inventory;
        this.questLog = questLog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public ArrayList<String> getQuestLog() {
        return questLog;
    }

    public void setQuestLog(ArrayList<String> questLog) {
        this.questLog = questLog;
    }

    public void addPlace(Place placeToAdd){
        if(this.places != null){
            this.places.add(placeToAdd);
        }
    }
    public void removePlace(Place placeToRemove){
        if(this.places != null){
            this.places.remove(placeToRemove);
        }
    }


    public void addItemToInventory(Item itemToAdd){
        if(this.inventory != null){
            this.inventory.add(itemToAdd);
        }
    }
    public void removeItemToInventory(Item itemToRemove){
        if(this.inventory != null){
            this.inventory.remove(itemToRemove);
        }
    }

    public void addToLog(String logToAdd){
        if(this.questLog != null){
            this.questLog.add(logToAdd);
        }
    }

}


