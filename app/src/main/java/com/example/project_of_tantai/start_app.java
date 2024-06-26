package com.example.project_of_tantai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class start_app extends AppCompatActivity {
Button btstart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_app);
        btstart = (Button) findViewById(R.id.start);
        btstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(start_app.this, your_choice.class);
                startActivity(i);
            }
        });
    }
}