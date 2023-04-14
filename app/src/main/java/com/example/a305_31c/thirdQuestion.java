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


public class thirdQuestion extends AppCompatActivity {

    Button correctAnswerBtn;
    Button submit;

    Button wrongAnswerBtn;

    Button backBtn;

    Button nextBtn;
    ProgressBar thirdProgressBar;

    Boolean correctAnswerClicked = false;
    Boolean wrongAnswerClicked = false;

    int extrasData;

    String userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_question);

        correctAnswerBtn = findViewById(R.id.correctAnswer);
        submit = findViewById(R.id.submitBtn);
        wrongAnswerBtn = findViewById(R.id.button3);

        nextBtn = findViewById(R.id.nextBtn);
        thirdProgressBar = findViewById(R.id.thirdProgressBar);
        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thirdToSecond = new Intent(thirdQuestion.this,secondQuestion.class);
                startActivity(thirdToSecond);
            }
        });

        thirdProgressBar.setMax(5);
        thirdProgressBar.setProgress(3);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            extrasData = extras.getInt("resultAfterSecondQuestion");
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
                    Toast.makeText(thirdQuestion.this,"You chose the correct answer.", Toast.LENGTH_LONG).show();
                    // finalScore++
                }
                else if (wrongAnswerClicked == true && correctAnswerClicked == false){
                    correctAnswerBtn.setBackgroundColor(Color.GREEN);
                    wrongAnswerBtn.setBackgroundColor(Color.RED);
                    Toast.makeText(thirdQuestion.this,"You chose the wrong answer.", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(thirdQuestion.this,"Please choose an answer first.", Toast.LENGTH_LONG).show();
                }
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctAnswerClicked == true && wrongAnswerClicked == false){
                    extrasData++;
                }
                Intent thirdToFourth = new Intent(thirdQuestion.this,fourthQuestion.class);
                thirdToFourth.putExtra("resultAfterThirdQuestion", extrasData);
                startActivity(thirdToFourth);
            }
        });

    }
}