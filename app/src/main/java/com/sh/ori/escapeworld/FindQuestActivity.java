package com.sh.ori.escapeworld;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class FindQuestActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<Quest> quests = new ArrayList<Quest>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_quest);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        addQuests();



    }
    //todo: delete(its for debug )
    public void addQuests(){
        // Quest(int id, String name, String description, ArrayList<Place> places, ArrayList<Item> items)
        //Place(int id, String name, String enterDescription, String exitDescription,int riddleId, int itemId, LatLng location) {
        LatLng sydney = new LatLng(-34, 151);
        LatLng sydney2 = new LatLng(-34, 152);
        LatLng sydney3 = new LatLng(-34, 153);

        Place p = new Place(11,"p1","desc p1","exit desc p1",12,21,sydney);
        Place p2 = new Place(12,"p2","desc p2","exit desc p2",13,31,sydney2);
        Place p3 = new Place(13,"p3","desc p3","exit desc p3",14,41,sydney3);

        ArrayList<Place> pList = new ArrayList<Place>();
        pList.add(p);
        pList.add(p2);
        pList.add(p3);
        ArrayList<Place> pList2 = new ArrayList<Place>();
        pList2.add(p2);
        pList2.add(p);
        pList2.add(p3);
        quests.add(new Quest(1,"Q1","Best quest ever",pList, null ));
        quests.add(new Quest(2,"Q2","Best quest ever2",pList2, null ));

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        LatLng sydney2 = new LatLng(-34, 152);

        mMap.addMarker(new MarkerOptions().position(sydney).title("title1"));
        mMap.addMarker(new MarkerOptions().position(sydney2).title("title2"));

//        mMap.addMarker(new MarkerOptions().position(quest.getPlace(0).getLocation()).title(quest.getName()));

////        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        for(Quest q: quests) {
//            addQuestMarker(q);
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(q.getPlace(0).getLocation()));
//        }
    }

    public void addQuestMarker(Quest quest){
        mMap.addMarker(new MarkerOptions().position(quest.getPlace(0).getLocation()).title(quest.getName()));
    }
}
