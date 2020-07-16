package com.example.mathtraining;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button goButton;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sum;
    TextView correct;
    TextView scoreView;
    TextView timerView;
    List<Integer> answersList = new ArrayList<Integer>(4);
    Random random = new Random();
    int correctLocation;
    int score;
    int tries;
    int a;
    int b;
    CountDownTimer timer;
    Button playAgainButton;
    ConstraintLayout gameLayout;
int countDownTime = 5;
    public void newProblem() {
        a = random.nextInt(21);
        b = random.nextInt(21);
        generateNewProblem(a, b);
        fillAnswerList(a, b);
        fillAnswerButtons();

    }

    public void answerAction(View view) {
        if (String.valueOf(correctLocation).equals(view.getTag().toString())) {
            correct.setText("Correct!");
            score++;
        } else {
            correct.setText("Wrong!");
        }
        newProblem();
        tries++;
        scoreView.setText(score + "/" + tries);
        Log.i("tag", view.getTag().toString());
    }

    public void fillAnswerList(int a, int b) {
        answersList.clear();
        correctLocation = random.nextInt(4);
        for (int i = 0; i < 4; i++) {
            if (i == correctLocation) {
                answersList.add(a + b);
            } else {
                int wrongAnswer = random.nextInt(41);
                while (wrongAnswer == a + b) {
                    wrongAnswer = random.nextInt(41);
                }
                answersList.add(wrongAnswer);
            }
        }
    }

    public void fillAnswerButtons() {
//    public void fillAnswerButtons(Button button0,Button button1,Button button2,Button button3) {
        button0.setText(String.valueOf(answersList.get(0)));
        button1.setText(String.valueOf(answersList.get(1)));
        button2.setText(String.valueOf(answersList.get(2)));
        button3.setText(String.valueOf(answersList.get(3)));

    }

    public void goAction(View view) {
        goButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        playAgainAction(correct);

    }

    public void generateNewProblem(int a, int b) {
        sum.setText(a + " + " + b);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goButton = findViewById(R.id.goButton);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        sum = findViewById(R.id.problemView);
        correct = findViewById(R.id.correctTextView);
        scoreView = findViewById(R.id.scoreView);
        timerView = findViewById(R.id.timerView);
        playAgainButton = findViewById(R.id.playAgainButton);
        playAgainButton.setVisibility(View.INVISIBLE);
        gameLayout = findViewById(R.id.gameLayout);
        gameLayout.setVisibility(View.INVISIBLE);
    }

    public void playAgainAction(View view) {
        playAgainButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        correct.setText("");
        score = 0;
        tries = 0;
        timerView.setText(countDownTime+"s");
        scoreView.setText(score + "/" + tries);
        newProblem();
        timer = new CountDownTimer(countDownTime*1000, 1000) {
            @Override
            public void onTick(long l) {
                timerView.setText(l / 1000 + "s");
            }

            @Override
            public void onFinish() {
                correct.setText("Finished! Your Result is : " + score + "/" + tries);
                playAgainButton.setVisibility(View.VISIBLE);
                gameLayout.setVisibility(View.INVISIBLE);
            }
        }.start();
    }
}