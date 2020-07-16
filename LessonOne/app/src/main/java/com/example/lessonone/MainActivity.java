package com.example.lessonone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public void changeCat(View view){
        Log.i("Info", "Button Pressed!");
ImageView cat2 = findViewById(R.id.imageView);
cat2.setImageResource(R.drawable.abycat2);
    }

    public void login (View view ){
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        Log.i("Info", "Button Pressed!");
        Log.i("USERNAME", username.getText().toString());
        Log.i("PASSWORD", password.getText().toString());
        Toast.makeText(this, " Hi, User!", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked (View view){
        Log.i("Info","Button Clicked");
    }
}