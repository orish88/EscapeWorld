package com.sh.ori.escapeworld;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sh.ori.escapeworld.GameObjects.Item;
import com.sh.ori.escapeworld.GameObjects.Place;
import com.sh.ori.escapeworld.GameObjects.Player;
import com.sh.ori.escapeworld.GameObjects.Quest;

import java.util.ArrayList;


public class GameplayActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, ResultCallback {

    private static final int RADIUS = 100;
    private GoogleMap mMap;
    private Button inventoryBt;
    public ArrayList<Item> itemsList;
    //    public Quest curQuest;
    GoogleApiClient mGoogleApiClient;
    ArrayList<Geofence> mGeofenceList;
    PendingIntent mGeofencePendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("notes", "GameplayActivity: on create called");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.game_map);
        mapFragment.getMapAsync(this);
//        Player.curQuest = Player.savedQuests.get(getIntent().getIntExtra("questID", -1));

        // Create an instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            // ATTENTION: This "addApi(AppIndex.API)"was auto-generated to implement the App Indexing API.
            // See https://g.co/AppIndexing/AndroidStudio for more information.
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .addApi(AppIndex.API).build();
        }
        mGeofenceList = new ArrayList<Geofence>();
        //set the geofence for first place
        populateGeofenceList();

        LocalBroadcastManager lbc = LocalBroadcastManager.getInstance(this);
        GoogleReceiver googleReceiver = new GoogleReceiver(this);
        lbc.registerReceiver(googleReceiver, new IntentFilter("googlegeofence"));


    }

    private void populateGeofenceList() {
        Geofence firstGeofence = new Geofence.Builder()
                // Set the request ID of the geofence. This is a string to identify this
                // geofence.
                .setRequestId("" + Player.curQuest.getPlaces().get(0).getId()).setCircularRegion(
                        Player.curQuest.getPlaces().get(0).getLocation().latitude,
                        Player.curQuest.getPlaces().get(0).getLocation().longitude,
                        RADIUS
                )
                .setExpirationDuration(Geofence.NEVER_EXPIRE)
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER |
                        Geofence.GEOFENCE_TRANSITION_EXIT)
                .build();

        mGeofenceList.add(firstGeofence);

    }

    private GeofencingRequest getGeofencingRequest() {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
        builder.setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER);
        builder.addGeofences(mGeofenceList);
        return builder.build();
    }


    private PendingIntent getGeofencePendingIntent() {
        // Reuse the PendingIntent if we already have it.
        if (mGeofencePendingIntent != null) {
            return mGeofencePendingIntent;
        }
        Intent intent = new Intent(this, GeofenceTransitionsIntentService.class);
        // We use FLAG_UPDATE_CURRENT so that we get the same pending intent back when
        // calling addGeofences() and removeGeofences().
        return PendingIntent.getService(this, 0, intent, PendingIntent.
                FLAG_UPDATE_CURRENT);
    }

//    private PendingIntent getGeofencePendingIntent2() {
//        // Reuse the PendingIntent if we already have it.
//        if (mGeofencePendingIntent != null) {
//            return mGeofencePendingIntent;
//        }
//        Intent intent = new Intent("alert");
//        PendingIntent proximityIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
//        locationManager.addProximityAlert(latitude,
//                longitude, PROXIMITY_DISTANCE, -1, proximityIntent);
//        // We use FLAG_UPDATE_CURRENT so that we get the same pending intent back when
//        // calling addGeofences() and removeGeofences().
//        return PendingIntent.getService(this, 0, intent, PendingIntent.
//                FLAG_UPDATE_CURRENT);
//    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("notes", "GameplayActivity: on resume called");
        if (mMap != null) {
            for (Place p : Player.curQuest.getPlaces()) {
                addPlaceMarker(p);
            }
        }
    }


    @Override
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.start(mGoogleApiClient, getIndexApiAction());
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(mGoogleApiClient, getIndexApiAction());
    }

    //
//    public void on
//    /**
//     * Manipulates the map once available.
//     * This callback is triggered when the map is ready to be used.
//     * This is where we can add markers or lines, add listeners or move the camera. In this case,
//     * we just add a marker near Sydney, Australia.
//     * If Google Play services is not installed on the device, the user will be prompted to install
//     * it inside the SupportMapFragment. This method will only be triggered once the user has
//     * installed Google Play services and returned to the app.
//     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d("notes", "GameplayActivity: on map ready called");

        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Player.curQuest.getPlaces().get(0).getLocation()));

        // Add a marker in Sydney and move the camera
        for (Place p : Player.curQuest.getPlaces()) {
            addPlaceMarker(p);
        }
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                int curPlaceId = (int) marker.getTag();
                Intent ansAct = new Intent(getApplicationContext(), PlaceActivity.class);
                Log.d("notes", "quest id:" + Player.curQuest.getId());
                Log.d("notes", "place id:" + curPlaceId);
//                ansAct.putExtra("questID",Player.curQuest.getId());
                ansAct.putExtra("placeID", curPlaceId);
                startActivity(ansAct);
                return false;
            }
        });
    }

    public void addPlaceMarker(Place place) {
        if (place.isRevealed()) {
            Log.d("notes", "place revealed: " + place.getTitle());
            Marker curMark = mMap.addMarker(new MarkerOptions().position(place.getLocation()).title(place.getTitle()).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.puzzle))));
            curMark.setTag(place.getId());
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.d("notes", "on connected called");

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.GeofencingApi.addGeofences(
                mGoogleApiClient,
                getGeofencingRequest(),
                getGeofencePendingIntent()
        ).setResultCallback(this);
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d("notes", "on connected suspended called");

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d("notes", "on connected failed called");

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Gameplay Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onResult(@NonNull Result result) {
        Status status = result.getStatus();
        if (status.isSuccess()) {
            Toast.makeText(
                    this,
                    "Geofences Added",
                    Toast.LENGTH_SHORT
            ).show();
        } else {
            // Get the status code for the error and log it using a user-friendly message.
//            String errorMessage = GeofenceErrorMessages.getErrorString(this,
//                    status.getStatusCode());
            Log.d("notes", "on result error");
        }
    }


    static class GoogleReceiver extends BroadcastReceiver {

        GameplayActivity mActivity;

        public GoogleReceiver(Activity activity) {
            mActivity = (GameplayActivity) activity;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            //Handle the intent here

            Log.d("notes","On Receive: receiver called");
            int curPlaceId = intent.getIntExtra("placeID",-1);
            Intent ansAct = new Intent(context, PlaceActivity.class);
            Log.d("notes", "place id:" + curPlaceId);
            ansAct.putExtra("placeID", curPlaceId);
            mActivity.startActivity(ansAct);
        }
    }

}
/*

    <RelativeLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

        <Button
            android:id="@+id/bt_GamePuzzle"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Riddles"
            android:textColor="#888888"
            android:background="@drawable/mybutton"
            android:drawableLeft="@drawable/ic_action_puzzle"
            android:layout_gravity="right|center"
            android:layout_marginRight="59dp"
            android:layout_marginEnd="59dp"
            android:layout_alignParentTop="true"
            android:layout_alignParentRight="true"
            android:layout_alignParentEnd="true" />

        <Button
            android:id="@+id/bt_GameTB"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="ToolBox"
            android:textColor="#888888"
            android:background="@drawable/mybutton"
            android:drawableLeft="@drawable/ic_action_toolbox"
            android:layout_gravity="left|center"
            android:layout_alignParentTop="true"
            android:layout_alignParentLeft="true"
            android:layout_alignParentStart="true"
            android:layout_marginLeft="80dp"
            android:layout_marginStart="80dp" />
    </RelativeLayout>
 */