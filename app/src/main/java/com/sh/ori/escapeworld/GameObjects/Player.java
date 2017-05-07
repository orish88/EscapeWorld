package com.sh.ori.escapeworld.GameObjects;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ori on 4/27/2017.
 */

public class Player {

    public static Quest curQuest;
    public static ArrayList<Quest> favoriteQuests = new ArrayList<Quest>();
    public static ArrayList<Quest> savedQuests = new ArrayList<Quest>();
    public static HashMap<Integer,Integer> currentGeofences = new HashMap<>();
    public static void loadSavedQuests(){


        //benthumi coordinates
//        LatLng ll0 = new LatLng(32.175, 34.835);
//        LatLng ll1 = new LatLng(32.176, 34.836);
//        LatLng ll2 = new LatLng(32.18, 34.803);
//        LatLng ll3 = new LatLng(32.164, 34.82);

        //kfar saba home coordiantes
//        LatLng ll0 = new LatLng(32.181214, 34.913564);
//        LatLng ll1 = new LatLng(32.181250, 34.913181);
//        LatLng ll2 = new LatLng(32.18, 34.803);
//        LatLng ll3 = new LatLng(32.164, 34.82);

        //meonot zwieg
//        LatLng ll0 = new LatLng(31.768909, 35.198552);
//        LatLng ll1 = new LatLng(31.769011, 35.198555);
//        LatLng ll2 = new LatLng(31.768815, 35.198452);
//        LatLng ll3 = new LatLng(31.768649, 35.198613);


        LatLng ll0 = new LatLng(31.756890, 35.176645);

        LatLng ll1 = new LatLng(31.756798, 35.176387);
        LatLng ll2 = new LatLng(31.768815, 35.198452);
        LatLng ll3 = new LatLng(31.768649, 35.198613);

        ArrayList<String> answerList0 = new ArrayList<String>();
        answerList0.add("answer0");
        answerList0.add("answer1");

        Riddle rid2 = new Riddle("r2","r2 question bla bla bla?",new ArrayList<Integer>(),new ArrayList<Integer>() ,"reward Text 2",answerList0,false);

        Riddle rid3 = new Riddle("r3","r3 question bla bla bla?",new ArrayList<Integer>(),
                new ArrayList<Integer>(), "reward Text 3",answerList0,false);


        ArrayList<Riddle> riddles1 = new ArrayList<Riddle>();
        riddles1.add(rid2);
        riddles1.add(rid3);
        Place p1 = new Place("p1","p1 desc","p1 ended!! gz", riddles1  , new ArrayList<Item>(), false, ll1 );

        //String name, String description, ArrayList<Integer> itemRewardIds,
        //ArrayList<Integer> placeRewardIds, String txtReward, ArrayList<String> answers, boolean answered
        ArrayList<Integer> placeList1 = new ArrayList<Integer>();
        placeList1.add(p1.getId());

        Riddle rid0 = new Riddle("r0","r0 question bla bla bla?",new ArrayList<Integer>(),placeList1 ,"reward Text 0",answerList0,false);

        Riddle rid1 = new Riddle("r1","r1 question bla bla bla?",new ArrayList<Integer>(),
                new ArrayList<Integer>(), "reward Text 1",answerList0,false);


        Riddle rid4 = new Riddle("r4","r4 question bla bla bla?",new ArrayList<Integer>(),
                new ArrayList<Integer>(), "reward Text 4",answerList0,false);

        //PLACE: String title, String enterDescription, String exitDescription, ArrayList<Riddle> riddles, ArrayList<Item> items,
        //boolean revealed, LatLng location, ArrayList<Integer> itemRewardIds, ArrayList<Integer> placeRewardIds
        ArrayList<Riddle> riddles0 = new ArrayList<Riddle>();
        riddles0.add(rid0);
        riddles0.add(rid1);
        riddles0.add(rid4);
        Place p0 = new Place("p0","p0 desc","p0 ended!! gz", riddles0 , new ArrayList<Item>(), true, ll0 );

        ArrayList<Place> places0 = new ArrayList<Place>();
        places0.add(p0);
        places0.add(p1);
        //public Quest(String name,String description, ArrayList<Place> places, ArrayList<Item> inventory,  ArrayList<String> questLog)
        Quest q0 = new Quest("Quest0", "Quest 0 bla bla bla bla",places0, new ArrayList<Item>(), new ArrayList<String>());


        Place p2 = new Place("p2","p2 desc","p2 ended!! gz", riddles0 , new ArrayList<Item>(), true, ll2 );
        Place p3 = new Place("p3","p3 desc","p3 ended!! gz", riddles0 , new ArrayList<Item>(), false, ll3 );
        ArrayList<Place> places1 = new ArrayList<Place>();
        places1.add(p2);
        places1.add(p3);
        Quest q1 = new Quest("Quest1", "Quest 1 bla bla bla bla",places1, new ArrayList<Item>(), new ArrayList<String>());
        savedQuests.add(q0);
        savedQuests.add(q1);
        return;

    }

    public static Quest getQuestFromID(int id){
        for(Quest q:savedQuests){
            if(q.getId() == id){
                return q;
            }
        }
        return null;
    }
    public static Place getPlaceFromID(int id){
        for(Place p:curQuest.getPlaces()){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public static void saveRiddle(int placeID, Riddle newRiddle){
        for(Place p : curQuest.getPlaces()){
            if(p.getId() == placeID) {
                for (Riddle r : p.getRiddles()) {
                    if(r.getId() == newRiddle.getId()) {
                        Log.d("notes", "Player: save riddle: "+ r.getDescription());
                        r = newRiddle;
                    }
                }
            }
        }
    }
    public static void savePlace(Place newPlace){
        for(Place p : curQuest.getPlaces()){
            if(p.getId() == newPlace.getId()){
                p = newPlace;
            }
        }
    }

    public static void revealLoc(int placeId){
        if(curQuest == null){
            return;
        }
        for (Place p: curQuest.getPlaces()){
            if(p.getId() == placeId){
                p.setRevealed(true);
            }
        }
    }

//    //todo: delete(its for debug )
//    public static void addQuests(){
//        // Quest(int id, String name, String description, ArrayList<Place> places, ArrayList<Item> items)
//        //Place(int id, String name, String enterDescription, String exitDescription,int riddleId, int itemId, LatLng location) {
////        LatLng sydney = new LatLng(-34, 151);
//
//
//        savedQuests.add(setQ0());
//        Place p1 = new Place(11,"p1","desc p1","exit desc p1",null,21,new LatLng(37,35));
//        Place p2 = new Place(12,"p2","desc p2","exit desc p2",null,31, new LatLng(37,34) );
//        Place p3 = new Place(13,"p3","desc p3","exit desc p3",null,41,new LatLng(37,36));
//        Place p4 = new Place(13,"p4","desc p4","exit desc p4",null,41,new LatLng(37,38));
//
//        Place p5 = new Place(11,"p1","desc p1","exit desc p1",null,21,new LatLng(37,40));
//        Place p6 = new Place(12,"p2","desc p2","exit desc p2",null,31, new LatLng(37,41) );
//        Place p7 = new Place(13,"p3","desc p3","exit desc p3",null,41,new LatLng(37,42));
//        Place p8 = new Place(13,"p4","desc p4","exit desc p4",null,41,new LatLng(37,43));
//
//
//        ArrayList<Place> pList1 = new ArrayList<Place>();
//        ArrayList<Place> pList2 = new ArrayList<Place>();
//        ArrayList<Place> pList3 = new ArrayList<Place>();
//        ArrayList<Place> pList4 = new ArrayList<Place>();
//
//        pList1.add(p1);
//        pList1.add(p2);
//        pList1.add(p3);
//
//        pList2.add(p3);
//        pList2.add(p4);
//        pList2.add(p7);
//
//        pList3.add(p6);
//        pList3.add(p8);
//        pList3.add(p5);
//
//        pList4.add(p2);
//        pList4.add(p4);
//        pList4.add(p7);
//
//        savedQuests.add(new Quest(1,"Q1","Best quest ever",pList1, null ));
//        savedQuests.add(new Quest(2,"Q2","Best quest ever2",pList2, null ));
//        savedQuests.add(new Quest(3,"Q3","Best quest ever2",pList3, null ));
//        savedQuests.add(new Quest(4,"Q4","Best quest ever2",pList4, null ));
//
//
//    }
//    public static Quest setQ0(){
//        //It is important that the id is the location in the ArrayList
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

}
