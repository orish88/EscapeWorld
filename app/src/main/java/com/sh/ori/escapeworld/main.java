package com.sh.ori.escapeworld;

/**
 * An example of how to use the game
 */
public class main {
    public static void main(String[] argv){

    }

    Quest setUp(){
        Riddle riddle0 = new Riddle(0, "Riddle 0", "What Has Four Legs and Flies?",
                "A horse");
        Riddle riddle1 = new Riddle(1, "Riddle 1", "What brand are the cookies?",
                "Merba");
        Riddle riddle2 = new Riddle(2, "Riddle 2", "What color is the arch in the arch bridge? Blue, " +
                "Yellow, white, or all?",
                "all");
        Item key = new Item(0, "key", "A key");
        riddle1.setItemReward(key);
        Item coin = new Item(2, "coin", "A coin");
        riddle2.setItemReward(coin);
        Item chest = new Item(1, "chest", "A chest", coin, null,
                "take a coin", null);
        Place Start = new Place(0, "Start", "Go to the IDC"
                , "Go to the Entrepreneurship Building", riddle0, chest, 15.32);
        Place IDC = new Place(1, "IDC", "Look for the cookies. "
                , "Go to the beach", riddle1, chest, 12.71);
        riddle1.setPlaceReward(IDC);
        Place Beach = new Place(2, "Beach", "A nice place to swim and get a tan", "Go to the train",
                null, null, 82.9);
        chest.setPlaceReward(Beach);
        Place end = new Place(3, "end", "Congradulation, you won", null, null, null, 53.91);
        Place[] places = {Start, IDC, Beach, end};
        Item[] items = {chest, key, coin};
        Quest game = new Quest(0, "Lets have fun", "Play the hack IDC game", places, items);
        return game;
    }

    void playQuest(Quest quest){

    }

    boolean answerRiddle(Riddle riddle, String answer){
        if(true)
            return true;
        return false;
    }

}
