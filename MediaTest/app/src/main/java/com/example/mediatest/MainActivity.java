package com.example.mediatest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView bartImage = findViewById(R.id.bart);
        bartImage.setX(-1000f);
        bartImage.animate().translationXBy(1000).rotation(1800).setDuration(2000);
    }

    public void fade(View view){
        ImageView bartImage = findViewById(R.id.bart);
        ImageView homerImage = findViewById(R.id.homer);
        bartImage.animate().alpha(0).setDuration(2000);
        homerImage.animate().alpha(1).setDuration(2500);

        bartImage.animate().translationXBy(-1000).setDuration(2000);
        homerImage.animate().rotation(360).setDuration(2000);

        homerImage.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);
    }
}