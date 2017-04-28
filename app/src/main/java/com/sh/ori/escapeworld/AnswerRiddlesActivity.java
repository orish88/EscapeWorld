package com.sh.ori.escapeworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class AnswerRiddlesActivity extends AppCompatActivity {


    TextView tvQuestion;
    EditText etAnswer;
    Button btSubmit;
    ImageButton imBtLeft;
    ImageButton imBtRight;
    Place curPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_riddles);
        int questID = getIntent().getIntExtra("questID",-1);
        int placeID = getIntent().getIntExtra("placeID",-1);

        curPlace = Player.savedQuests.get(questID).getPlace(placeID);

        tvQuestion = (TextView) findViewById(R.id.tv_question);
        etAnswer = (EditText) findViewById(R.id.et_answer);
        btSubmit = (Button) findViewById(R.id.bt_submit_answer);
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userAnswer = etAnswer.getText().toString();
                if(curPlace.getRiddle().tryAnswer(userAnswer)){
                    //add thumbs up?
                    Toast.makeText(getApplicationContext(),"Well done",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Wrong. Try again!",Toast.LENGTH_LONG).show();
                }
            }
        });
        imBtLeft = (ImageButton) findViewById(R.id.img_bt_left);
        imBtRight = (ImageButton) findViewById(R.id.img_bt_right);


        if(curPlace.getRiddle() != null){

            tvQuestion.setText(curPlace.getRiddle().getDescription());

        }



    }



}
