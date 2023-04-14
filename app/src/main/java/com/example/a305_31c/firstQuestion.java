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


public class firstQuestion extends AppCompatActivity  {

    Button correctAnswerBtn;
    Button submit;

    Button wrongAnswerBtn;
    Button next;


    ProgressBar  firstProgressBar;// 1st progressBar

    Boolean correctAnswerClicked = false;
    Boolean wrongAnswerClicked = false;

    int result = 0;
    String userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_question);

        correctAnswerBtn = findViewById(R.id.correctAnswer);
        submit = findViewById(R.id.submitBtn);
        wrongAnswerBtn = findViewById(R.id.button3);
        next = findViewById(R.id.next);
        firstProgressBar = findViewById(R.id.firstProgressBar);

        firstProgressBar.setMax(5);
        firstProgressBar.setProgress(1);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
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
                    Toast.makeText(firstQuestion.this,"You chose the correct answer.", Toast.LENGTH_LONG).show();
                }
                else if (wrongAnswerClicked == true && correctAnswerClicked == false){
                    correctAnswerBtn.setBackgroundColor(Color.GREEN);
                    wrongAnswerBtn.setBackgroundColor(Color.RED);
                    Toast.makeText(firstQuestion.this,"You chose the wrong answer.", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(firstQuestion.this,"Please choose an answer first.", Toast.LENGTH_LONG).show();
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(correctAnswerClicked == true && wrongAnswerClicked == false) result ++;
                Intent firstToSecond = new Intent(firstQuestion.this,secondQuestion.class);
                firstToSecond.putExtra("resultAfterFirstQuestion", result);// intent key and the value we gonna send
                firstToSecond.putExtra("userName", userName);
                startActivity(firstToSecond);
                // user chose the correctAnswer, result++
                // we created an intent to connect this activity with others, and send the value using the specified intentKey;
            }
        });

    }
}