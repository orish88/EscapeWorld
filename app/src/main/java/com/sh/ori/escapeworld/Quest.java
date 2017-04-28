package com.sh.ori.escapeworld;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A Quest has a list of places that the player can visit. The player can only see revealed locations. At
 * the beginning of the Quest, only the first location is revealed.
 */
public class Quest implements Serializable {

    private int id;
    private String name;
    private String description;
    private ArrayList<Place> places;
    private ArrayList<Item> items;

    public Quest(int id, String name, String description,
                 ArrayList<Place> places, ArrayList<Item> items) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.places = places;
        this.places.get(0).revealLoc();
        this.items = items;
    }

//    protected Quest(Parcel in) {
//        id = in.readInt();
//        name = in.readString();
//        description = in.readString();
//    }

//    public static final Creator<Quest> CREATOR = new Creator<Quest>() {
//        @Override
//        public Quest createFromParcel(Parcel in) {
//            return new Quest(in);
//        }
//
//        @Override
//        public Quest[] newArray(int size) {
//            return new Quest[size];
//        }
//    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Place getPlace(int i) {
        return places.get(i);
    }

    public Item getItems(int i) {
        return items.get(i);
    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }

//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt(id);
//        dest.writeString(name);
//        dest.writeString(description);
//        dest.writeTypedList(places);
//        dest.writeSerializable(items);
//        return;
//    }
}
