package com.sh.ori.escapeworld;

import java.util.ArrayList;

/**
 * Created by d on 4/27/17.
 */

public class Box {
    protected static int idGen = 300000;
    int id;

    ArrayList<Item> items;
    ArrayList<Riddle> riddles;



    boolean Exposed;


    double lat;
    double lon;
    double trigRadius;
    String introText;
    String exitText;
    ArrayList<Integer> rewardBoxIds;

    public Box(ArrayList<Integer> rewardBoxIds, ArrayList<Item> items, ArrayList<Riddle> riddles,
               boolean exposed, double lat, double lon, double trigRadius, String introText, String exitText) {
        this.rewardBoxIds = rewardBoxIds;
        this.items = items;
        this.riddles = riddles;
        Exposed = exposed;
        this.lat = lat;
        this.lon = lon;
        this.trigRadius = trigRadius;
        this.introText = introText;
        this.exitText = exitText;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Riddle> getRiddles() {
        return riddles;
    }

    public void setRiddles(ArrayList<Riddle> riddles) {
        this.riddles = riddles;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getTrigRadius() {
        return trigRadius;
    }

    public void setTrigRadius(double trigRadius) {
        this.trigRadius = trigRadius;
    }

    public String getIntroText() {
        return introText;
    }

    public void setIntroText(String introText) {
        this.introText = introText;
    }

    public String getExitText() {
        return exitText;
    }

    public void setExitText(String exitText) {
        this.exitText = exitText;
    }

    public ArrayList<Integer> getRewardBoxIds() {
        return rewardBoxIds;
    }

    public void setRewardBoxIds(ArrayList<Integer> rewardBoxIds) {
        this.rewardBoxIds = rewardBoxIds;
    }
    public boolean isExposed() {
        return Exposed;
    }

    public void setExposed(boolean exposed) {
        Exposed = exposed;
    }
    public int getId() {
        return id;
    }






}
