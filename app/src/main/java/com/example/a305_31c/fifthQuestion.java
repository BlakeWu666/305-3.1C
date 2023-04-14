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


public class fifthQuestion extends AppCompatActivity {

    Button correctAnswerBtn;
    Button submit;

    Button wrongAnswerBtn;

    Button nextBtn;
    ProgressBar fifthProgressBar;

    Boolean correctAnswerClicked = false;
    Boolean wrongAnswerClicked = false;

    int extrasData;
    String userName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_question);

        correctAnswerBtn = findViewById(R.id.correctAnswer);
        submit = findViewById(R.id.submitBtn);
        wrongAnswerBtn = findViewById(R.id.button3);


        nextBtn = findViewById(R.id.nextBtn);
        fifthProgressBar = findViewById(R.id.fifthProgressBar);

        fifthProgressBar.setMax(5);
        fifthProgressBar.setProgress(5);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            extrasData = extras.getInt("resultAfterFourthQuestion");
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
                    Toast.makeText(fifthQuestion.this,"You chose the correct answer.", Toast.LENGTH_LONG).show();
                    // finalScore++
                }
                else if (wrongAnswerClicked == true && correctAnswerClicked == false){
                    correctAnswerBtn.setBackgroundColor(Color.GREEN);
                    wrongAnswerBtn.setBackgroundColor(Color.RED);
                    Toast.makeText(fifthQuestion.this,"You chose the wrong answer.", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(fifthQuestion.this,"Please choose an answer first.", Toast.LENGTH_LONG).show();
                }
            }
        });


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (correctAnswerClicked == true && wrongAnswerClicked == false) extrasData++;
                Intent fifthToLast = new Intent(fifthQuestion.this, lastPage.class);
                fifthToLast.putExtra("resultAfterFifthQuestion", extrasData);
                fifthToLast.putExtra("userName", userName);
                startActivity(fifthToLast);
            }
        });


    }
}