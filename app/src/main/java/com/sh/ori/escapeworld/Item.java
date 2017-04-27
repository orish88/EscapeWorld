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
    private Place placeReward;
    private String txtReward;
    private Item reactItem;
    private boolean revealed;
    private boolean passive;

    /**
     * Constructor for passive item. (Like a chest)
     * @param id id
     * @param name name
     * @param description description
     * @param itemRewardId itemReward
     * @param placeReward placeReward
     * @param txtReward txtReward
     * @param reactItem reactItem
     */
    public Item(int id, String name, String description, int itemRewardId,
                Place placeReward, String txtReward, Item reactItem) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.itemRewardId = itemRewardId;
        this.placeReward = placeReward;
        this.txtReward = txtReward;
        this.reactItem = reactItem;
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
     * @param item the active item
     * @return duh
     */
    public boolean getInteration(Item item) {
        return this.reactItem.equals(item);
    }

    public boolean equals(Item item){
        return this.id == item.id;
    }

    public int getItemRewardId(){
        return itemRewardId;
    }

    public Place getPlaceReward(){
        return placeReward;
    }

    public void setPlaceReward(Place place){
        this.placeReward = place;
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
