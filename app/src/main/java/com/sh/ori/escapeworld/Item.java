package com.sh.ori.escapeworld;

/**
 * Created by Ori on 4/27/2017.
 */

public class Item {

    protected static int idGen = 200000;
    int id;
    String name;
    String description;
    String rewardTxt;
    int rewardBoxId; //optional

    public int getId() {
        return id;
    }

    public Item(String name, String description, int rewardBoxId, String rewardTxt) {
        this.name = name;
        this.description = description;
        this.rewardBoxId = rewardBoxId;
        this.rewardTxt = rewardTxt;

        this.id = idGen++;
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

    public String getRewardTxt() {
        return rewardTxt;
    }

    public void setRewardTxt(String rewardTxt) {
        this.rewardTxt = rewardTxt;
    }

    public int getRewardBoxId() {
        return rewardBoxId;
    }

    public void setRewardBoxId(int rewardBoxId) {
        this.rewardBoxId = rewardBoxId;
    }
}
