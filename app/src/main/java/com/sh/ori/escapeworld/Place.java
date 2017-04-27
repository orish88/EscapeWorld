package com.sh.ori.escapeworld;


/**
 * A place on the map. Every place has a riddle and an item.
 */
public class Place {
    private int id;
    private String name;
    private String enterDescription;
    private String exitDescription;
    private Riddle riddle;
    private Item item;
    private boolean revealed;
    private double location;


    public Place(int id, String name, String enterDescription, String exitDescription,
                 Riddle riddle, Item item, double location) {
        this.id = id;
        this.name = name;
        this.enterDescription = enterDescription;
        this.exitDescription = exitDescription;
        this.riddle = riddle;
        this.item = item;
        this.revealed = false;
        this.location = location;

    }

    public boolean isRevealed(){
        return this.revealed;
    }

    public double getLocation(){
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

    public Item getItem() {
        return item;
    }

}
