package com.sh.ori.escapeworld;

import java.util.ArrayList;

/**
 * Created by Ori on 4/27/2017.
 */

public class Quest {


    protected static int idGen = 400000;
    int id;
    Box firstBox;
    ArrayList<Box> boxes;
    ArrayList<Item> inventory;
    //todo: quest log?
    String introTxt;

    public Quest(ArrayList<Box> boxes, ArrayList<Item> inventory, String introTxt, String exitText, Box firstBox) {
        this.boxes = boxes;
        this.inventory = inventory;
        this.introTxt = introTxt;
        this.exitText = exitText;
        this.firstBox = firstBox;
    }

    String exitText;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Box getFirstBox() {
        return firstBox;
    }

    public void setFirstBox(Box firstBox) {
        this.firstBox = firstBox;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public String getIntroTxt() {
        return introTxt;
    }

    public void setIntroTxt(String introTxt) {
        this.introTxt = introTxt;
    }

    public String getExitText() {
        return exitText;
    }

    public void setExitText(String exitText) {
        this.exitText = exitText;
    }
}
