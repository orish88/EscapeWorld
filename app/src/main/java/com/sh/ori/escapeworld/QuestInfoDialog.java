package com.sh.ori.escapeworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
        curQuest = Player.savedQuests.get(getIntent().getIntExtra("quest",-1));
        tvTitle = (TextView) findViewById(R.id.tv_dialog_quest_title);
        tvTitle.setText("Title: "+ curQuest.getName());
        tvDescription = (TextView) findViewById(R.id.tv_dialog_quest_description);
        tvDescription.setText("Description: "+curQuest.getDescription());
        btPlayQuest = (Button) findViewById(R.id.bt_dialog_play_quest);
        btPlayQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: start game activity
//                startActivity();
                Toast.makeText(getApplicationContext(),"start playing: "+curQuest.getName() , Toast.LENGTH_SHORT).show();
            }
        });

    }
}