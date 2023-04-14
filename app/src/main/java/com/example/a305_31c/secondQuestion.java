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


public class secondQuestion extends AppCompatActivity {

    Button correctAnswerBtn;
    Button submit;

    Button wrongAnswerBtn;

    Boolean correctAnswerClicked = false;
    Boolean wrongAnswerClicked = false;

    Button nextBtn;
    ProgressBar progressBar;
    int extrasData;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_question);

        correctAnswerBtn = findViewById(R.id.correctAnswer);
        submit = findViewById(R.id.submitBtn);
        wrongAnswerBtn = findViewById(R.id.button3);
        nextBtn = findViewById(R.id.next);
        progressBar = findViewById(R.id.secondProgressBar);

        progressBar.setMax(5);
        progressBar.setProgress(2);

        Bundle extras = getIntent().getExtras();//get the Intent from previous activities;
        if (extras != null) {
            extrasData = extras.getInt("resultAfterFirstQuestion");
            userName = extras.getString("userName");
        } // get the data with the specified key


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
                    Toast.makeText(secondQuestion.this,"You chose the correct answer.", Toast.LENGTH_LONG).show();
                    // finalScore++
                }
                else if (wrongAnswerClicked == true && correctAnswerClicked == false){
                    correctAnswerBtn.setBackgroundColor(Color.GREEN);
                    wrongAnswerBtn.setBackgroundColor(Color.RED);
                    Toast.makeText(secondQuestion.this,"You chose the wrong answer.", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(secondQuestion.this,"Please choose an answer first.", Toast.LENGTH_LONG).show();
                }
            }
        });


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctAnswerClicked == true && wrongAnswerClicked == false) extrasData++;
                Intent secondToThird = new Intent(secondQuestion.this, thirdQuestion.class);
                secondToThird.putExtra("resultAfterSecondQuestion", extrasData);
                secondToThird.putExtra("userName", userName);
                startActivity(secondToThird);
            }
        });

    }
}