package com.sh.ori.escapeworld;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.GeofencingEvent;
import com.sh.ori.escapeworld.GameObjects.Player;

import java.util.ArrayList;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class GeofenceTransitionsIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this

    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.sh.ori.escapeworld.action.FOO";
    private static final String ACTION_BAZ = "com.sh.ori.escapeworld.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.sh.ori.escapeworld.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.sh.ori.escapeworld.extra.PARAM2";

    private static final String TAG = "notes";


    public GeofenceTransitionsIntentService() {
        super("GeofenceTransitionsIntentService");
    }

//    /**
//     * Starts this service to perform action Foo with the given parameters. If
//     * the service is already performing a task this action will be queued.
//     *
//     * @see IntentService
//     */
//    // TODO: Customize helper method
//    public static void startActionFoo(Context context, String param1, String param2) {
//        Intent intent = new Intent(context, GeofenceTransitionsIntentService.class);
//        intent.setAction(ACTION_FOO);
//        intent.putExtra(EXTRA_PARAM1, param1);
//        intent.putExtra(EXTRA_PARAM2, param2);
//        context.startService(intent);
//    }

//    /**
//     * Starts this service to perform action Baz with the given parameters. If
//     * the service is already performing a task this action will be queued.
//     *
//     * @see IntentService
//     */
//    // TODO: Customize helper method
//    public static void startActionBaz(Context context, String param1, String param2) {
//        Intent intent = new Intent(context, GeofenceTransitionsIntentService.class);
//        intent.setAction(ACTION_BAZ);
//        intent.putExtra(EXTRA_PARAM1, param1);
//        intent.putExtra(EXTRA_PARAM2, param2);
//        context.startService(intent);
//    }

    @Override
    protected void onHandleIntent(Intent intent) {
//        if (intent != null) {
//            final String action = intent.getAction();
//            if (ACTION_FOO.equals(action)) {
//                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
//                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
//                handleActionFoo(param1, param2);
//            } else if (ACTION_BAZ.equals(action)) {
//                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
//                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
//                handleActionBaz(param1, param2);
//            }
//        }

        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        if (geofencingEvent.hasError()) {
//            String errorMessage = GeofenceErrorMessages.getErrorString(this,
//                    geofencingEvent.getErrorCode());
//            Log.d(TAG, errorMessage);
            Log.d(TAG, "error in geoevent");
            return;
        }

        // Get the transition type.
        int geofenceTransition = geofencingEvent.getGeofenceTransition();

        // Test that the reported transition was of interest.
        if (geofenceTransition == Geofence.GEOFENCE_TRANSITION_ENTER ) {
            //||geofenceTransition == Geofence.GEOFENCE_TRANSITION_EXIT

            // Get the geofences that were triggered. A single event can trigger
            // multiple geofences.
//            List triggeringGeofences = geofencingEvent.getTriggeringGeofences();

            // Get the transition details as a String.
//            String geofenceTransitionDetails = getGeofenceTransitionDetails(
//                    this,
//                    geofenceTransition,
//                    triggeringGeofences
//            );
//            String geofenceTransitionDetails = getGeofenceTransitionDetails(geofencingEvent);

            // Send notification and log the transition details.
            ArrayList<String> reqIds = getGeofenceTransitionDetails(geofencingEvent);
//            for(String reqID : reqIds){
//                sendNotification(reqID);
//                changePlacesToInRangeIcon(reqID);
//                Log.i(TAG, reqIds.get(0));
//            }
            changePlacesToInRangeIcon(reqIds);
        } else {
            // Log the error.
            Log.e(TAG, "geofence_transition_invalid_type: "+ geofenceTransition);
        }

    }



    //added funcs
    private static ArrayList<String> getGeofenceTransitionDetails(GeofencingEvent event) {
        Log.d(TAG, "getGeoTransitionDetails called");
        String transitionString =
                GeofenceStatusCodes.getStatusCodeString(event.getGeofenceTransition());
        ArrayList triggeringIDs = new ArrayList();
        for (Geofence geofence : event.getTriggeringGeofences()) {
            Log.d(TAG, "on geo details- geo: "+geofence.getRequestId());
            triggeringIDs.add(geofence.getRequestId()); //because the request id == placeID the geofence represents
        }
//        return String.format("%s: %s", transitionString, TextUtils.join(", ", triggeringIDs));
        return triggeringIDs;
    }

    private void sendNotification(String requestId) {

        Log.d(TAG, "send notifications called");
        Toast.makeText(getApplicationContext(),"send notifitcation called",Toast.LENGTH_LONG).show();
        // Create an explicit content Intent that starts MainActivity.
        Intent notificationIntent = new Intent(getApplicationContext(), GameplayActivity.class);
        notificationIntent.putExtra("placeID",Integer.parseInt(requestId));
//        notification.flags = Notification.FLAG_ONGOING_EVENT | Notification.FLAG_NO_CLEAR;
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        // Get a PendingIntent containing the entire back stack.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(GameplayActivity.class).addNextIntent(notificationIntent);
        PendingIntent notificationPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        // Get a notification builder that's compatible with platform versions >= 4
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        // Define the notification settings.
        builder.setColor(Color.RED)
                .setContentTitle(Player.getPlaceFromID(Integer.parseInt(requestId)).getTitle())
                .setContentText("Click notification to return to App")
                .setContentIntent(notificationPendingIntent)
                .setAutoCancel(true).setSmallIcon(R.mipmap.bg);


        // Fire and notify the built Notification.
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }
    public void changePlacesToInRangeIcon(ArrayList<String> reqIds){
//        Intent placeAct = new Intent(getApplicationContext(), PlaceActivity.class);
//        placeAct.putExtra("placeID",Integer.parseInt(requestId));
//        startActivity(placeAct);
        Intent lbcIntent = new Intent("googlegeofence"); //Send to any reciever listening for this
        lbcIntent.putExtra("placeIDs", reqIds);  //Put whatever it is you want the activity to handle
        LocalBroadcastManager.getInstance(this).sendBroadcast(lbcIntent);  //Send the intent
    }
}
