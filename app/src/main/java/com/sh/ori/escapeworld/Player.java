package com.sh.ori.escapeworld;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;

import java.util.ArrayList;

/**
 * Created by Ori on 4/27/2017.
 */

public class Player {


    ArrayList<Quest> favoriteQuests = new ArrayList<Quest>();


    public Player(ArrayList<Quest> favoriteQuests) {
        this.favoriteQuests = favoriteQuests;
        addQuests();
    }

    //todo: delete(its for debug )
    public void addQuests(){
        // Quest(int id, String name, String description, ArrayList<Place> places, ArrayList<Item> items)
        //Place(int id, String name, String enterDescription, String exitDescription,int riddleId, int itemId, LatLng location) {
        LatLng sydney = new LatLng(-34, 151);
        Place p = new Place(11,"p1","desc p1","exit desc p1",12,21,sydney);
        Place p2 = new Place(12,"p2","desc p2","exit desc p2",13,31,sydney);
        Place p3 = new Place(13,"p3","desc p3","exit desc p3",14,41,sydney);

        ArrayList<Place> pList = new ArrayList<Place>();
        pList.add(p);
        pList.add(p2);
        pList.add(p3);
        favoriteQuests.add(new Quest(1,"Q1","Best quest ever",pList, null ));
        favoriteQuests.add(new Quest(2,"Q2","Best quest ever2",pList, null ));

    }

}
