package com.sh.ori.escapeworld;


/**
 * This represents an item. Items have descriptions and can be used with other items. Some items can
 * actively be used and others can be used. Upon successfully being used, the main should request xReward.
 */
public class Item {
    private int id;
    private String name;
    private String description;
    private int itemRewardId;
    private int placeRewardId;
    private String txtReward;
    private int reactItemId;
    private boolean revealed;
    private boolean passive;

    /**
     * Constructor for passive item. (Like a chest)
     * @param id id
     * @param name name
     * @param description description
     * @param itemRewardId itemReward
     * @param placeRewardId placeReward
     * @param txtReward txtReward
     * @param reactItemId reactItem
     */
    public Item(int id, String name, String description, int itemRewardId,
                int placeRewardId, String txtReward, int reactItemId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.itemRewardId = itemRewardId;
        this.placeRewardId = placeRewardId;
        this.txtReward = txtReward;
        this.reactItemId = reactItemId;
        this.revealed = false;
        this.passive = true;
    }

    /**
     * Constructor for an active item. (Like a key)
     * @param id id
     * @param name name
     * @param description description
     */
    public Item(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.revealed = false;
        this.passive = false;
    }


    public void revealItem(){
        this.revealed = true;
    }

    public boolean isRevealed(){
        return this.revealed;
    }

    public boolean isPassive(){
        return this.passive;
    }

    /**
     * Attempts to use and item on another one
     * @param itemId the active item
     * @return duh
     */
    public boolean getInteration(int itemId) {
        return this.reactItemId == itemId;
    }

    public boolean equals(Item item){
        return this.id == item.id;
    }

    public int getItemRewardId(){
        return itemRewardId;
    }

    public int getPlaceRewardId(){
        return placeRewardId;
    }

    public void setPlaceRewardId(int placeId){
        this.placeRewardId = placeId;
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
