package com.sh.ori.escapeworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class StartMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);
        Log.d("notes","startMenu on create called");
        ArrayList<Item> inv = new ArrayList<Item>();
        ArrayList<Box> boxes = new ArrayList<Box>();
        Riddle r = new Riddle("","","");
        if(r.checkAnswer(""))
        {
            inv.addAll(inv.size(),r.getItemList());

        }

    }
    private String getNameFromClassName(String className){
        String[] spl = className.split("\\.");
        return spl[spl.length-1];


    }
}
