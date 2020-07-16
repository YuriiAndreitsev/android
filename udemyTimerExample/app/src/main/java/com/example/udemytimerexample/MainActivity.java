package com.example.udemytimerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    SeekBar seekBar;
    MediaPlayer mediaPlayer;
    Button goButton;
    boolean active =false;
    CountDownTimer timer;

    public void goButtonAction(View view) {

        if (active) {
            textView.setText("0:30");
            seekBar.setProgress(30);
            seekBar.setEnabled(true);
            timer.cancel();
            goButton.setText("Go!");
            active = false;
        } else {
            active = true;
            seekBar.setEnabled(false);
            goButton.setText("STOP");
            timer = new CountDownTimer(seekBar.getProgress() * 1000, 1000) {
                @Override
                public void onTick(long l) {
                    updateTimer((int) l / 1000);
                }

                @Override
                public void onFinish() {
                    mediaPlayer.create(getApplicationContext(), R.raw.air_horn).start();
                    Log.i("finished", "done");
                }
            };
            timer.start();
        }

    }

    public void updateTimer(int secondsLeft) {
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft % 60;

        String zero = "";
        if (seconds < 10)
            zero = "0";
        textView.setText(Integer.toString(minutes) + ":" + zero + Integer.toString(seconds));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        seekBar = findViewById(R.id.seekBar);
        goButton = findViewById(R.id.button);
        seekBar.setMax(600);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimer(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}