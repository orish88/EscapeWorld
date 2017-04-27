package com.sh.ori.escapeworld;

import java.util.ArrayList;

/**
 * Created by Ori on 4/27/2017.
 */

public class Riddle {


    protected static int idGen = 100000;
    int id;

    ArrayList<Integer> rewardBoxIds;
    ArrayList<Integer> rewardItemIds;
    String name;
    String quesion;
    String answer;
    ArrayList<Item> itemList;//why

    public Riddle(String name, String quesion, String answer) {
        this.name = name;
        this.quesion = quesion;
        this.answer = answer;
        this.id = idGen++;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuesion() {
        return quesion;
    }

    public void setQuesion(String quesion) {
        this.quesion = quesion;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Integer> getBox() {
        return rewardBoxIds;
    }

    public ArrayList<Integer> getItem() {
        return rewardItemIds;
    }

    public void addItem(Item item){
        itemList.add(item);
    }
    public void removeItem(Item item){
        itemList.remove(item);
    }
    public boolean checkAnswer(String userAnswer){

        return userAnswer.equals(answer);

    }
}
