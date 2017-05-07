//package com.sh.ori.escapeworld;
//
//
//
//import com.google.android.gms.maps.model.LatLng;
//import com.sh.ori.escapeworld.GameObjects.Item;
//import com.sh.ori.escapeworld.GameObjects.Place;
//import com.sh.ori.escapeworld.GameObjects.Quest;
//import com.sh.ori.escapeworld.GameObjects.Riddle;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//
///**
// * An example of how to use the game
// */
//public class main {
//    public static void main(String[] argv){
//    }
//
//    Quest setUp(){
//        //It is important that the id is the location in the ArrayList
//        LatLng ll0 = new LatLng(32.175, 34.835);
//        LatLng ll1 = new LatLng(32.176, 34.836);
//        LatLng ll2 = new LatLng(32.18, 34.803);
//        LatLng ll3 = new LatLng(32.164, 34.82);
//        Riddle riddle0 = new Riddle(0, "Riddle 0", "What Has Four Legs and Flies?",0,1,
//                "A horse", "Congratulations");
//        Riddle riddle1 = new Riddle(1, "Riddle 1", "What brand are the cookies?",
//                1,2,"Merba", "Congratulations");
//        Riddle riddle2 = new Riddle(2, "Riddle 2", "What color is the arch in the arch bridge? Blue, " +
//                "Yellow, white, or all?",0,3, "all", "Congratulations");
//        Item key = new Item(0, "key", "A key");
//        riddle1.setItemReward(key.getId());
//        Item coin = new Item(2, "coin", "A coin");
//        riddle2.setItemReward(coin.getId());
//        Item chest = new Item(1, "chest", "A chest", coin.getId(), -1,
//                "take a coin and go to the beach", -1);
//        Place Start = new Place(0, "Start", "Go to the IDC"
//                , "Go to the Entrepreneurship Building", riddle0, chest.getId(), ll0);
//        Place IDC = new Place(1, "IDC", "Look for the cookies. "
//                , null, riddle1, chest.getId(), ll1);
//        riddle1.setPlaceReward(IDC.getId());
//        Place Beach = new Place(2, "Beach", "A nice place to swim and get a tan", "Go to the train",
//                null, -1, ll2);
//        chest.setPlaceRewardId(Beach.getId());
//        Place end = new Place(3, "end", "Congratulations, you won", null, null, -1, ll3);
//        ArrayList<Place> places = new ArrayList<>();
//        places.add(Start);
//        places.add(IDC);
//        places.add(Beach);
//        places.add(end);
//        ArrayList<Item> items = new ArrayList<>();
//        items.add(chest);
//        items.add(key);
//        items.add(coin);
//        Quest quest = new Quest(0, "Lets have fun", "Play the hack IDC game", places, items);
//        return quest;
//    }
//
//    void playQuest(Quest quest){
//
//    }
//
//    boolean answerRiddle(Riddle riddle, String answer, ArrayList<Place> places, ArrayList<Item> items){
//        if(riddle.tryAnswer(answer))
//        {
//            System.out.println(riddle.getRewardTxt());
//            if(riddle.getItemRewardId() != -1){
//                System.out.println("You got a " + items.get(riddle.getItemRewardId()).getName());
//                items.get(riddle.getItemRewardId()).revealItem();
//            }
//            if(riddle.getPlaceRewardId() != -1){
//                System.out.println("You can go to " + riddle.getPlaceRewardId());
//                places.get(riddle.getPlaceRewardId()).revealLoc();
//            }
//            return true;
//        }
//        System.out.println("Wrong");
//        return false;
//    }
//
//    boolean useItem(Item active, Item passive, ArrayList<Item> items, ArrayList<Place> places){
//        if(passive.getInteration(active.getId())){
//            System.out.println(passive.getTxtReward());
//            if(passive.getItemRewardId() != -1){
//                System.out.println("You got a " + items.get(passive.getItemRewardId()).getName());
//                items.get(passive.getItemRewardId()).revealItem();
//            }
//            if(passive.getPlaceRewardId() != -1){
//                System.out.println("You can go to " + places.get(passive.getPlaceRewardId()).getTitle());
//                places.get(passive.getPlaceRewardId()).revealLoc();
//            }
//            return true;
//        }
//        return false;
//    }
//
//    void goToPlace(Place place, ArrayList<Item> items, ArrayList<Place> places, ArrayList<Riddle> riddles){
//        Scanner reader = new Scanner(System.in);
//        System.out.println(place.getEnterDescriptionescription());
//        String input;
//        if(place.getItemId() != -1){
//            if(items.get(place.getItemId()).isPassive()){
//                Item passive = items.get(place.getItemId());
//                System.out.println("You see a " + items.get(place.getItemId()).getName());
//                System.out.println("Would you like to use an item on it, y/n?");
//                input = reader.nextLine();
//                while(input.equals("y")){
//                    System.out.println("What item would you like to use?");
//                    input = reader.nextLine();
//                    Item active = findItem(input, items);
//                    if(active != null){
//                        if(passive.getInteration(active.getId())){
//                            System.out.println(passive.getTxtReward());
//                            if(items.get(passive.getId()).getItemRewardId() != -1){
//                                System.out.println("You got a " +
//                                        items.get(passive.getItemRewardId()).getName());
//                                items.get(passive.getItemRewardId()).revealItem();
//                            }
//                            if(items.get(passive.getId()).getPlaceRewardId() != -1){
//                                System.out.println("Go to " + items.get(passive.getPlaceRewardId()).getName());
//                                places.get(passive.getPlaceRewardId()).revealLoc();
//                            }
//                        }
//                        break;
//                    }
//                    System.out.println("error. try again, y/n?");
//                    input = reader.nextLine();
//                }
//
//            }
//            System.out.println("You got a ");
//            input = reader.nextLine();
//            while (true){
//                if(answerRiddle(place.getRiddle(), input, places, items)){
//                    System.out.println(place.getExitDescriptionescription());
//                    break;
//                } else {
//                    System.out.println("wrong, try again");
//                }
//            }
//        }
//
//        if(place.getRiddle() != null){
//            System.out.println("Would you like to answer the riddle, y/n?");
//            input = reader.nextLine();
//            while (input.equals("y")){
//                if(answerRiddle(place.getRiddle(), input, places, items)){
//                    System.out.println(place.getExitDescriptionescription());
//                    break;
//                } else {
//                    System.out.println("wrong, try again");
//                }
//            }
//        }
//
//
//
//    }
//
//    Item findItem(String name, ArrayList<Item> items){
//        for(int i = 0;i<items.size(); i++){
//            if(items.get(i).getName().equals(name)){
//                return items.get(i);
//            }
//        }
//        return null;
//    }
//
//
//
//}
