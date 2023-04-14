package com.example.a305_31c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class lastPage extends AppCompatActivity {

    Button takeNewQuiz;
    Button finish;

    TextView title;
    int extrasData;
    String userNameInput;

    TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_page);

        takeNewQuiz = findViewById(R.id.takeNewQuiz);
        finish = findViewById(R.id.finish);
        title = findViewById(R.id.title);
        userName = findViewById(R.id.userName);

        // In the title textView, display the finalScore and userName, using Intent to connect pages with each other.
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            extrasData = extras.getInt("resultAfterFifthQuestion");
            userNameInput = extras.getString("userName");
        }
        userName.setText("Hi " + userNameInput);


        title.setText("Congratulations! Your final score is:" + extrasData);

        takeNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lastToFirst = new Intent(lastPage.this,MainActivity.class);
                startActivity(lastToFirst);
                extrasData = 0;
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(lastPage.this, "See you next time!", Toast.LENGTH_LONG).show();
            }
        });
    }
}