package com.sh.ori.escapeworld;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sh.ori.escapeworld.GameObjects.Player;
import com.sh.ori.escapeworld.GameObjects.Quest;

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
        Player.loadSavedQuests();
        quests = Player.savedQuests;
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
//        LatLng sydney = new LatLng(-34, 151);
//        LatLng sydney2 = new LatLng(-34, 152);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Quest curQuest = (Quest) marker.getTag();
                Intent questDialogAct = new Intent(getApplicationContext(),QuestInfoDialog.class);
//                questDialogAct.putExtra("quest",curQuest.getId());
                Player.curQuest = curQuest;
                Log.d("notes","before quest dialog: "+curQuest.getName());
                startActivity(questDialogAct);
                return false;
            }
        });

        for(Quest q: quests) {
            addQuestMarker(q);
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(q.getPlaces().get(0).getLocation()));
        }
    }

    public void addQuestMarker(Quest quest){
        Marker curMark = mMap.addMarker(new MarkerOptions().position(quest.getPlaces().get(0).getLocation()).title(quest.getName())
                .icon(BitmapDescriptorFactory.fromBitmap( BitmapFactory.decodeResource(getResources(), R.drawable.hiking32))));
        curMark.setTag(quest);
    }
}
