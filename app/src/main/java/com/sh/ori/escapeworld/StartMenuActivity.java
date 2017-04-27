package com.sh.ori.escapeworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class StartMenuActivity extends AppCompatActivity implements View.OnClickListener {

    Button btFindQuest;
    Button btCreateQuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);
        Log.d("notes","startMenu on create called");
        btFindQuest = (Button) findViewById(R.id.bt_find_quest);
        btCreateQuest = (Button) findViewById(R.id.bt_create_quest);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.bt_find_quest):
//                startActivityForResult();
                break;
            case(R.id.bt_create_quest):
//                startActivityForResult();
                break;
        }
    }
}