package com.example.project_of_tantai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class myteam extends AppCompatActivity {
    Button address, email, messenger, call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myteam);

        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        messenger = findViewById(R.id.message);
        call = findViewById(R.id.call);

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = "BKACAD";
                String mapUri = "geo:0,0?q=" + Uri.encode(address);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(mapUri));
                i.setPackage("com.google.android.apps.maps");
                startActivity(i);
            }
        });

        messenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:0326196160"));
                i.putExtra("sms_body", "Hey You");
                startActivity(i);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0326196160"));
                startActivity(i);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "vutai4420@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });
    }
}
