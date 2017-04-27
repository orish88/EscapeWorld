package com.sh.ori.escapeworld;


/**
 * This represents a riddle. You can try to answer the riddle. If you successfully answer the riddle then
 * the main should request the xReward.
 */
public class Riddle {
    private int id;
    private String name;
    private String description;
    private int itemRewardId;
    private int placeRewardId;
    private String txtReward;
    private String answer;
    private boolean answered;

    /**
     * Constructor for a riddle
     * @param id Id is generated by the main
     * @param name The name of the riddle
     * @param description a description of the riddle
     * @param itemRewardId the item given upon answering riddle
     * @param placeRewardId the place given upon answering riddle
     * @param txtReward the text written upon answering riddle
     * @param answer the answer to the riddle
     */
    public Riddle(int id, String name, String description, int itemRewardId,
                  int placeRewardId, String txtReward, String answer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.itemRewardId = itemRewardId;
        this.placeRewardId = placeRewardId;
        this.txtReward = txtReward;
        this.answer = answer;
        this.answered = false;
    }

    /**
     * Constructor for a riddle, without rewards yet.
     * @param id Id is generated by the main
     * @param name The name of the riddle
     * @param description a description of the riddle
     * @param txtReward the text written upon answering riddle
     * @param answer the answer to the riddle
     */
    public Riddle(int id, String name, String description, String answer, String txtReward) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.answer = answer;
        this.answered = false;
        this.txtReward = txtReward;
        this.placeRewardId = -1;
    }

    public void setItemReward(int itemRewardId) {
        this.itemRewardId = itemRewardId;
    }

    public void setPlaceReward(int placeRewardId) {
        this.placeRewardId = placeRewardId;
    }

    public void setTxtReward(String txtReward) {
        this.txtReward = txtReward;
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
        if(this.answer.equals(answer))
        {
            this.answered = true;
            return true;
        }
        return false;
    }

    /**
     * True if riddle was answered
     * @return duh
     */
    public boolean getAnswered(){
        return this.answered;
    }

    public int getPlaceReward(){
        return placeRewardId;
    }

    public int getItemRewardId(){
        return itemRewardId;
    }

    public String getTxtReward(){
        return txtReward;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getId(){
        return id;
    }
}
