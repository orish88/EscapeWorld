package com.sh.ori.escapeworld.GameObjects;


import java.io.Serializable;
import java.util.ArrayList;



/**
 * This represents a riddle. You can try to answer the riddle. If you successfully answer the riddle then
 * the main should request the xReward.
 */
public class Riddle implements Serializable {

    private static int idGen = 3000000;
    private int id;
    private String name;
    private String description;
    private ArrayList<Integer> itemRewardIds;
    private ArrayList<Integer> placeRewardIds;
    private String rewardTxt;
    private ArrayList<String> answers;
    private boolean answered;

    public Riddle(String name, String description, ArrayList<Integer> itemRewardIds,
                  ArrayList<Integer> placeRewardIds, String txtReward, ArrayList<String> answers, boolean answered) {
        this.id = idGen++;
        this.name = name;
        this.description = description;
        this.itemRewardIds = itemRewardIds;
        this.placeRewardIds = placeRewardIds;
        this.rewardTxt = txtReward;
        this.answers = answers;
        this.answered = answered;
    }

    public int getId() {
        return id;
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

    public ArrayList<Integer> getItemRewardIds() {
        return itemRewardIds;
    }

    public void setItemRewardIds(ArrayList<Integer> itemRewardIds) {
        this.itemRewardIds = itemRewardIds;
    }

    public ArrayList<Integer> getPlaceRewardIds() {
        return placeRewardIds;
    }

    public void setPlaceRewardIds(ArrayList<Integer> placeRewardIds) {
        this.placeRewardIds = placeRewardIds;
    }

    public String getRewardTxt() {
        return rewardTxt;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public void setRewardTxt(String rewardTxt) {
        this.rewardTxt = rewardTxt;
    }

    public boolean equals(Riddle riddle){
        return this.id == riddle.id;
    }

    /**
     * Attempts to answer the riddle
     * @param answer the attempted answer
     * @return duh
     */
    public boolean tryAnswer(String answer){

        if(this.answers != null && this.answers.contains(answer))
        {
            this.answered = true;
            return true;
        }
        return false;
    }

    public void addAnswer(String answerToAdd){
        if(this.answers != null){
            this.answers.add(answerToAdd);
        }
    }
    public void removeAnswer(String answerToAdd){
        if(this.answers != null){
            this.answers.remove(answerToAdd);
        }
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
