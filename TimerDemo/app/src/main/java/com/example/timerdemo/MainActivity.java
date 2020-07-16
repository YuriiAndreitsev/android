package com.example.timerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button startPause;
    TextView time;
    CountDownTimer timer;
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    long timeT = 0;

    public void buttonStart(View view) {
        timer = new CountDownTimer(timeT, 1000) {
            public void onTick(long millisecondsUntilDone) {
                Log.i("seconds left", String.valueOf(millisecondsUntilDone));
                long minutes = timeT/1000 / 60;
                long seconds = timeT/1000 % 60;
                String zero = "0";
                if (minutes < 0) {
                    minutes = 0;
                }
                if (seconds >= 10) {
                    zero = "";
                }
                time.setText(minutes + " : " + zero + seconds);
                timeT = millisecondsUntilDone;
            }
            public void onFinish() {
                time.setText("TIME IS UP!!");
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
                mediaPlayer.start();

                Log.i("finished", "finished");
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar selectTimeBar = findViewById(R.id.seekBar);
         time = findViewById(R.id.timeTextView);
        startPause = findViewById(R.id.startPauseButton);
        startPause.setTag("1");
        selectTimeBar.setMax(125);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        mediaPlayer = MediaPlayer.create(this, R.raw.timeisup);

        selectTimeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int minutes = i / 60;
                int seconds = i % 60;
                String zero = "0";
                if (minutes < 0) {
                    minutes = 0;
                }
                if (seconds >= 10) {
                    zero = "";
                }
                time.setText(minutes + " : " + zero + seconds);
                Log.i("seconds", String.valueOf(seconds));
                timeT = i*1000;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


//        new CountDownTimer(10000, 1000) {
//            public void onTick(long millisecondsUntilDone) {
//                Log.i("seconds left", String.valueOf(millisecondsUntilDone));
//            }
//
//            public void onFinish() {
//                Log.i("finished", "finished");
//            }
//        }.start();

//        final Handler handler = new Handler();
//        final Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                Log.i("asdsdasd", "123123213");
//                handler.postDelayed(this, 1000);
//            }
//        };
//        handler.post(runnable);
    }


}