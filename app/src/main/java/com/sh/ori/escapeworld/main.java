package com.sh.ori.escapeworld;



import java.util.Arrays;
import java.util.Scanner;

/**
 * An example of how to use the game
 */
public class main {
    public static void main(String[] argv){

    }

    Quest setUp(){
        Riddle riddle0 = new Riddle(0, "Riddle 0", "What Has Four Legs and Flies?",
                "A horse", "Congratulations");
        Riddle riddle1 = new Riddle(1, "Riddle 1", "What brand are the cookies?",
                "Merba", "Congratulations");
        Riddle riddle2 = new Riddle(2, "Riddle 2", "What color is the arch in the arch bridge? Blue, " +
                "Yellow, white, or all?", "all", "Congratulations");
        Item key = new Item(0, "key", "A key");
        riddle1.setItemReward(key);
        Item coin = new Item(2, "coin", "A coin");
        riddle2.setItemReward(coin);
        Item chest = new Item(1, "chest", "A chest", coin, null,
                "take a coin and go to the beach", null);
        Place Start = new Place(0, "Start", "Go to the IDC"
                , "Go to the Entrepreneurship Building", riddle0, chest, 15.32);
        Place IDC = new Place(1, "IDC", "Look for the cookies. "
                , null, riddle1, chest, 12.71);
        riddle1.setPlaceReward(IDC);
        Place Beach = new Place(2, "Beach", "A nice place to swim and get a tan", "Go to the train",
                null, null, 82.9);
        chest.setPlaceReward(Beach);
        Place end = new Place(3, "end", "Congratulations, you won", null, null, null, 53.91);
        Place[] places = {Start, IDC, Beach, end};
        Item[] items = {chest, key, coin};
        Quest quest = new Quest(0, "Lets have fun", "Play the hack IDC game", places, items);
        return quest;
    }

    void playQuest(Quest quest){

    }

    boolean answerRiddle(Riddle riddle, String answer){
        if(riddle.tryAnswer(answer))
        {
            System.out.println(riddle.getTxtReward());
            if(riddle.getItemReward() != null){
                System.out.println("You got a " + riddle.getItemReward());
                riddle.getItemReward().revealItem();
            }
            if(riddle.getPlaceReward() != null){
                System.out.println("You can go to " + riddle.getPlaceReward());
                riddle.getPlaceReward().revealLoc();
            }
            return true;
        }
        System.out.println("Wrong");
        return false;
    }

    boolean useItem(Item active, Item passive){
        if(passive.getInteration(active)){
            System.out.println(passive.getTxtReward());
            if(passive.getItemReward() != null){
                System.out.println("You got a " + passive.getItemReward());
                passive.getItemReward().revealItem();
            }
            if(passive.getPlaceReward() != null){
                System.out.println("You can go to " + passive.getPlaceReward());
                passive.getPlaceReward().revealLoc();
            }
            return true;
        }
        return false;
    }

    void goToPlace(Place place, Item[] items){
        Scanner reader = new Scanner(System.in);
        System.out.println(place.getEnterDescriptionescription());
        String input;
        if(place.getItem() != null){
            if(place.getItem().isPassive()){
                Item passive = place.getItem();
                System.out.println("You see a " + place.getItem().getName());
                System.out.println("Would you like to use an item on it, y/n?");
                input = reader.nextLine();
                while(input.equals("y")){
                    System.out.println("What item would you like to use?");
                    input = reader.nextLine();
                    Item active = findItem(input, items);
                    if(active != null){
                        if(passive.getInteration(active)){
                            System.out.println(passive.getTxtReward());
                            if(passive.getItemReward() != null){
                                System.out.println("You got a " + passive.getItemReward());
                                passive.getItemReward().revealItem();
                            }
                            if(passive.getPlaceReward() != null){
                                System.out.println("Go to " + passive.getPlaceReward());
                                passive.getPlaceReward().revealLoc();
                            }
                        }
                        break;
                    }
                    System.out.println("error. try again, y/n?");
                    input = reader.nextLine();
                }

            }
            System.out.println("You got a ");
            input = reader.nextLine();
            while (true){
                if(answerRiddle(place.getRiddle(), input)){
                    System.out.println(place.getExitDescriptionescription());
                    break;
                } else {
                    System.out.println("wrong, try again");
                }
            }
        }

        if(place.getRiddle() != null){
            System.out.println("Would you like to answer the riddle, y/n?");
            input = reader.nextLine();
            while (input.equals("y")){
                if(answerRiddle(place.getRiddle(), input)){
                    System.out.println(place.getExitDescriptionescription());
                    break;
                } else {
                    System.out.println("wrong, try again");
                }
            }
        }



    }

    Item findItem(String name, Item[] items){
        for(int i = 0;i<items.length;i++){
            if(items[i].getName().equals(name)){
                return items[i];
            }
        }
        return null;
    }

}
