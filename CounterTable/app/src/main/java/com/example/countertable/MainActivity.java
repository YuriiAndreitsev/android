package com.example.countertable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        public void generateTimesTable (int timesTableNumber){
            zz
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar seekBar = findViewById(R.id.seekBar);
        final ListView listView = findViewById(R.id.numbersList);
        final List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numbersList);
        listView.setAdapter(adapter);
        seekBar.setMax(10);

        final int[] prevProgress = new int[1];

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                List<Integer> numbersList = new ArrayList<Integer>(10);
                for (int k =1; k<=10; k++){
                    numbersList.add(k);
                }
                 ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, numbersList);


                List<Integer> multiplied = new ArrayList<Integer>(10);
                int min = 1;
                if (i >= min) {
                    for (int j = 0; j < 10; j++) {
                        multiplied.add(j, numbersList.get(j) * i);
                    }
                }
                // just having fun
                TextView textView = findViewById(R.id.textView);
                textView.setText(String.valueOf(i));
                int diff = i - prevProgress[0];
                if (diff > 0) {
                    textView.animate().xBy(seekBar.getWidth() / 10).setDuration(100);
                } else {
                    textView.animate().translationXBy(-(seekBar.getWidth() / 10)).setDuration(100);
                }
                prevProgress[0] = i;
                //end of having fun

                listView.setAdapter(adapter);
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