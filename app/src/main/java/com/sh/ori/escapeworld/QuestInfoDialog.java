package com.sh.ori.escapeworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sh.ori.escapeworld.GameObjects.Player;
import com.sh.ori.escapeworld.GameObjects.Quest;

public class QuestInfoDialog extends AppCompatActivity {

    Quest curQuest;
    TextView tvTitle;
    TextView tvDescription;
    Button btPlayQuest;
    RatingBar rbQuestRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_info_dialog);
        curQuest = Player.curQuest;
        tvTitle = (TextView) findViewById(R.id.tv_dialog_quest_title);
        tvTitle.setText("Title: "+ curQuest.getName());
        tvDescription = (TextView) findViewById(R.id.tv_dialog_quest_description);
        tvDescription.setText("Description: "+curQuest.getDescription());
        btPlayQuest = (Button) findViewById(R.id.bt_dialog_play_quest);
        btPlayQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: start game activity
                Toast.makeText(getApplicationContext(),"start playing: "+curQuest.getName() , Toast.LENGTH_SHORT).show();
                Intent gameplayAct = new Intent(getApplicationContext(),GameplayActivity.class);
//                gameplayAct.putExtra("questID",curQuest.getId());
                startActivity(gameplayAct);
            }
        });

    }
}
