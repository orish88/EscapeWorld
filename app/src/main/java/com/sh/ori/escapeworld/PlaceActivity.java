package com.sh.ori.escapeworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sh.ori.escapeworld.GameObjects.Place;
import com.sh.ori.escapeworld.GameObjects.Player;
import com.sh.ori.escapeworld.GameObjects.Riddle;

public class PlaceActivity extends AppCompatActivity implements View.OnClickListener{


    TextView tvQuestion;
    EditText etAnswer;
    Button btSubmit;
    ImageButton imBtLeft;
    ImageButton imBtRight;
    int placeID;
    Place curPlace;
    ImageView imvAnsweredMark;
    Riddle curRiddle;
    static int curRiddleIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
//        final int questID = getIntent().getIntExtra("questID",-1);
        placeID = getIntent().getIntExtra("placeID",-1); //todo: change default back to -1 to sopt errors
//        Log.d("notes", "ARA quest id:" + questID);
        Log.d("notes", "ARA place id:" + placeID);

        curPlace = Player.getPlaceFromID(placeID);

        tvQuestion = (TextView) findViewById(R.id.tv_question);
        etAnswer = (EditText) findViewById(R.id.et_answer);
        imvAnsweredMark = (ImageView) findViewById(R.id.imv_answered_mark);
        imvAnsweredMark.setVisibility(View.INVISIBLE);
        curRiddle = curPlace.getRiddles().get(curRiddleIndex);
        if( curRiddle != null){
           setRiddleOnScreen(curRiddle);
        }
        btSubmit = (Button) findViewById(R.id.bt_submit_answer);
        btSubmit.setOnClickListener(this);
        imBtLeft = (ImageButton) findViewById(R.id.img_bt_left);
        imBtRight = (ImageButton) findViewById(R.id.img_bt_right);
        imBtLeft.setOnClickListener(this);
        imBtRight.setOnClickListener(this);




    }

    public void setRiddleOnScreen(Riddle curRiddle){
        tvQuestion.setText(curRiddle.getDescription());
        if(curRiddle.isAnswered()){
            imvAnsweredMark.setVisibility(View.VISIBLE);
        }else{
            imvAnsweredMark.setVisibility(View.INVISIBLE);
        }
    }



    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case(R.id.bt_submit_answer):
                String userAnswer = etAnswer.getText().toString();
                //todo: complete submit
                if(curRiddle.tryAnswer(userAnswer)){
                    curRiddle.setAnswered(true);
                    //todo: update the riddle in the global static cur quest
                    Player.saveRiddle(curPlace.getId(), curRiddle);
                    //todo: add the case of several riddles on 1 reward
                    for(int newPlaceID : curRiddle.getPlaceRewardIds()){
                        Player.revealLoc(newPlaceID);
                    }
                    //todo: handle reward items as well
                    setRiddleOnScreen(curRiddle);
                    curPlace = Player.getPlaceFromID(placeID);
                }
                break;
            case(R.id.img_bt_left):
                changeRiddleIndex(false);
                curRiddle = curPlace.getRiddles().get(curRiddleIndex);
                if( curRiddle != null){
                    setRiddleOnScreen(curRiddle);
                }
                break;
            case(R.id.img_bt_right):
                changeRiddleIndex(true);
                curRiddle = curPlace.getRiddles().get(curRiddleIndex);
                if( curRiddle != null){
                    setRiddleOnScreen(curRiddle);
                }
                break;

        }



    }
    private void changeRiddleIndex(boolean isPlus){
        int riddlesSize = curPlace.getRiddles().size();
        if(isPlus){
            curRiddleIndex= (++curRiddleIndex) % riddlesSize;
        }else{
            if(curRiddleIndex == 0){
                curRiddleIndex = riddlesSize - 1;
            }else{
                curRiddleIndex = (--curRiddleIndex) % riddlesSize;
            }
        }
    }
}
