package com.sh.ori.escapeworld;


import java.util.ArrayList;

/**
 * A Quest has a list of places that the player can visit. The player can only see revealed locations. At
 * the beginning of the Quest, only the first location is revealed.
 */
public class Quest {

    private int id;
    private String name;
    private String description;
    private ArrayList<Place> places;
    private ArrayList<Item> items;

    public Quest(int id, String name, String description,
                 ArrayList<Place> places, ArrayList<Item> items) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.places = places;
        this.places.get(0).revealLoc();
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Place getPlace(int i) {
        return places.get(i);
    }

    public Item getItems(int i) {
        return items.get(i);
    }
}
