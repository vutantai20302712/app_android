package com.example.project_of_tantai;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_screen extends AppCompatActivity {
    Button btok, btcancel;
    EditText edmaillogin, edpasslogin;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        btcancel = (Button) findViewById(R.id.btcancel);
        btok = (Button) findViewById(R.id.btok);
        edmaillogin = (EditText) findViewById(R.id.edmaillogin);
        edpasslogin = (EditText) findViewById(R.id.edpasslogin);
        btok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String semail = edmaillogin.getText().toString(); //Thông tin email bên màn hình LOGIN
                String spass = edpasslogin.getText().toString(); //Thông tin password bên màn hình LOGIN
                String rmail = getIntent().getExtras().getString("addressemail");
                String rpass = getIntent().getExtras().getString("pass");
                if(semail.equals(rmail)&& (spass.equals(rpass)))
                {
                    Toast.makeText(Login_screen.this,"Connection successfull", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Login_screen.this, start_app.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(Login_screen.this, "Connection Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
        btcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}