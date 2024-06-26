package com.example.project_of_tantai;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class your_choice extends AppCompatActivity {
 Button music,films;
 ImageView imageView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_choice);
        music = (Button) findViewById(R.id.music);
        films = (Button) findViewById(R.id.films);
        imageView = (ImageView) findViewById(R.id.image);
        Animation animFade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim);
        imageView.startAnimation(animFade);
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(your_choice.this, Activity_Comic_Manager.class);
                startActivity(i);
            }
        });
        films.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(your_choice.this, myteam.class);
                startActivity(i);
            }
        });
    }
}