package com.example.a305_31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;


public class fourthQuestion extends AppCompatActivity {

    Button correctAnswerBtn;
    Button submit;


    Button wrongAnswerBtn;
    Button nextBtn;
    ProgressBar fourthProgressBar;

    Boolean correctAnswerClicked = false;
    Boolean wrongAnswerClicked = false;
    int extrasData;
    String userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_question);

        correctAnswerBtn = findViewById(R.id.correctAnswer);
        submit = findViewById(R.id.submitBtn);

        nextBtn = findViewById(R.id.nextBtn);
        fourthProgressBar = findViewById(R.id.fourthProgressBar);

        fourthProgressBar.setMax(5);
        fourthProgressBar.setProgress(4);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            extrasData = extras.getInt("resultAfterThirdQuestion");
            userName = extras.getString("userName");
        }

        correctAnswerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctAnswerClicked = true;
            }
        });
        wrongAnswerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wrongAnswerClicked = true;
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctAnswerClicked == true && wrongAnswerClicked == false){
                    correctAnswerBtn.setBackgroundColor(Color.GREEN);
                    Toast.makeText(fourthQuestion.this,"You chose the correct answer.", Toast.LENGTH_LONG).show();
                    Toast.makeText(fourthQuestion.this,"You chose the correct answer.", Toast.LENGTH_LONG).show();
                }
                else if (wrongAnswerClicked == true && correctAnswerClicked == false){
                    correctAnswerBtn.setBackgroundColor(Color.GREEN);
                    wrongAnswerBtn.setBackgroundColor(Color.RED);
                    Toast.makeText(fourthQuestion.this,"You chose the wrong answer.", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(fourthQuestion.this,"Please choose an answer first.", Toast.LENGTH_LONG).show();
                }
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctAnswerClicked == true && wrongAnswerClicked == false) extrasData++;
                Intent fourthToFifth = new Intent(fourthQuestion.this, fifthQuestion.class);
                fourthToFifth.putExtra("resultAfterFourthQuestion", extrasData);
                fourthToFifth.putExtra("userName",userName);
                startActivity(fourthToFifth);
            }
        });

    }
}