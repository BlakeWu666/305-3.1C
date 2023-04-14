package com.example.a305_31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView title;
    EditText userInput;
    TextView hint;
    Button startQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        userInput = findViewById(R.id.userInput);
        hint = findViewById(R.id.hint);
        startQuiz = findViewById(R.id.startQuiz);

        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = userInput.getText().toString();
                Intent mainToFirstQuestion = new Intent(MainActivity.this, firstQuestion.class);
                mainToFirstQuestion.putExtra("userName", userName);
                startActivity(mainToFirstQuestion);
            }
        });
}}