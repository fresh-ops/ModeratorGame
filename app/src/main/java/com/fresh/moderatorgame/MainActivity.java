package com.fresh.moderatorgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fresh.moderatorgame.questions.QuestionsList;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private TextView questionText;
    private Button generateQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionText = findViewById(R.id.questionText);
        generateQuestion = findViewById(R.id.generateQuestion);

        InputStream source;
        try {
            source = getAssets().open("questions/questions.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        QuestionsList questionsList = new QuestionsList(source);

        generateQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = questionsList.nextQuestion();
                questionText.setText(question);
            }
        });
    }
}