package com.sh.ori.escapeworld;

import android.media.Image;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.plus.model.people.Person;

/**
 * Created by Ori on 4/27/2017.
 */

public class MarkerInfo {

    String title;
    LatLng position;
//    Image icon;

    public MarkerInfo(String title, LatLng position) {
        this.title = title;
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LatLng getPosition() {
        return position;
    }

    public void setPosition(LatLng position) {
        this.position = position;
    }

}
