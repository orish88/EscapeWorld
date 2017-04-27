package com.sh.ori.escapeworld;


/**
 * A Quest has a list of places that the player can visit. The player can only see revealed locations. At
 * the beginning of the Quest, only the first location is revealed.
 */
public class Quest {

    private int id;
    private String name;
    private String description;
    private Place[] places;
    private Item[] items;

    public Quest(int id, String name, String description, Place[] places, Item[] items) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.places = places;
        this.places[0].revealLoc();
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
        return places[i];
    }

    public Item getItems(int i) {
        return items[i];
    }
}
