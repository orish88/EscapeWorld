package com.sh.ori.escapeworld;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Ori on 4/27/2017.
 */

public class Player {




    public static ArrayList<Quest> savedQuests = new ArrayList<Quest>();

    //todo: delete(its for debug )
    public static void addQuests(){
        // Quest(int id, String name, String description, ArrayList<Place> places, ArrayList<Item> items)
        //Place(int id, String name, String enterDescription, String exitDescription,int riddleId, int itemId, LatLng location) {
//        LatLng sydney = new LatLng(-34, 151);


        savedQuests.add(setQ0());
        Place p1 = new Place(11,"p1","desc p1","exit desc p1",12,21,new LatLng(37,35));
        Place p2 = new Place(12,"p2","desc p2","exit desc p2",13,31, new LatLng(37,34) );
        Place p3 = new Place(13,"p3","desc p3","exit desc p3",14,41,new LatLng(37,36));
        Place p4 = new Place(13,"p4","desc p4","exit desc p4",14,41,new LatLng(37,38));

        Place p5 = new Place(11,"p1","desc p1","exit desc p1",12,21,new LatLng(37,40));
        Place p6 = new Place(12,"p2","desc p2","exit desc p2",13,31, new LatLng(37,41) );
        Place p7 = new Place(13,"p3","desc p3","exit desc p3",14,41,new LatLng(37,42));
        Place p8 = new Place(13,"p4","desc p4","exit desc p4",14,41,new LatLng(37,43));


        ArrayList<Place> pList1 = new ArrayList<Place>();
        ArrayList<Place> pList2 = new ArrayList<Place>();
        ArrayList<Place> pList3 = new ArrayList<Place>();
        ArrayList<Place> pList4 = new ArrayList<Place>();

        pList1.add(p1);
        pList1.add(p2);
        pList1.add(p3);

        pList2.add(p3);
        pList2.add(p4);
        pList2.add(p7);

        pList3.add(p6);
        pList3.add(p8);
        pList3.add(p5);

        pList4.add(p2);
        pList4.add(p4);
        pList4.add(p7);

        savedQuests.add(new Quest(1,"Q1","Best quest ever",pList1, null ));
        savedQuests.add(new Quest(2,"Q2","Best quest ever2",pList2, null ));
        savedQuests.add(new Quest(3,"Q3","Best quest ever2",pList3, null ));
        savedQuests.add(new Quest(4,"Q4","Best quest ever2",pList4, null ));


    }
    public static Quest setQ0(){
        //It is important that the id is the location in the ArrayList
        LatLng ll0 = new LatLng(32.175, 34.835);
        LatLng ll1 = new LatLng(32.176, 34.836);
        LatLng ll2 = new LatLng(32.18, 34.803);
        LatLng ll3 = new LatLng(32.164, 34.82);
        Riddle riddle0 = new Riddle(0, "Riddle 0", "What Has Four Legs and Flies?",
                "A horse", "Congratulations");
        Riddle riddle1 = new Riddle(1, "Riddle 1", "What brand are the cookies?",
                "Merba", "Congratulations");
        Riddle riddle2 = new Riddle(2, "Riddle 2", "What color is the arch in the arch bridge? Blue, " +
                "Yellow, white, or all?", "all", "Congratulations");
        Item key = new Item(0, "key", "A key");
        riddle1.setItemReward(key.getId());
        Item coin = new Item(2, "coin", "A coin");
        riddle2.setItemReward(coin.getId());
        Item chest = new Item(1, "chest", "A chest", coin.getId(), -1,
                "take a coin and go to the beach", -1);
        Place Start = new Place(0, "Start", "Go to the IDC"
                , "Go to the Entrepreneurship Building", riddle0.getId(), chest.getId(), ll0);
        Place IDC = new Place(1, "IDC", "Look for the cookies. "
                , null, riddle1.getId(), chest.getId(), ll1);
        riddle1.setPlaceReward(IDC.getId());
        Place Beach = new Place(2, "Beach", "A nice place to swim and get a tan", "Go to the train",
                -1, -1, ll2);
        chest.setPlaceRewardId(Beach.getId());
        Place end = new Place(3, "end", "Congratulations, you won", null, -1, -1, ll3);
        ArrayList<Place> places = new ArrayList<>();
        places.add(Start);
        places.add(IDC);
        places.add(Beach);
        places.add(end);
        ArrayList<Item> items = new ArrayList<>();
        items.add(chest);
        items.add(key);
        items.add(coin);
        Quest quest = new Quest(0, "Lets have fun", "Play the hack IDC game", places, items);
        return quest;
    }

}
