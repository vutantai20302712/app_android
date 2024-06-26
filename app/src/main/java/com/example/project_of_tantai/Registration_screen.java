package com.example.project_of_tantai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registration_screen extends AppCompatActivity {
Button buttonregis, buttonback;
EditText editmail, editpass, editname, editaddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen);
        editmail = (EditText) findViewById(R.id.editmail);
        editpass = (EditText) findViewById(R.id.editpass);
        editname = (EditText) findViewById(R.id.editname);
        editaddress = (EditText) findViewById(R.id.editaddress);
        buttonback = (Button) findViewById(R.id.buttonback);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  finish();
                Log.d("Close","app");
            }
        });

        buttonregis = (Button) findViewById(R.id.buttonregis);
        buttonregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Registration_screen.this,Login_screen.class);
                Bundle data = new Bundle();
                String email = editmail.getText().toString();
                String password = editpass.getText().toString();
                i.putExtra("addressemail",email);
                i.putExtra("pass", password);
                startActivity(i);
            }
        });
    }
}