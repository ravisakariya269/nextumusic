package com.example.nextu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Homepage extends AppCompatActivity {


    ImageView dailybtn,playbtn1,favrotbtn,playbtn,profilebtn,mymusic;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        if(getActionBar()!= null)
        {
            getActionBar().hide();
        }

        dailybtn = findViewById(R.id.dailybtn);
        playbtn1 = findViewById(R.id.playbtn1);
        playbtn = findViewById(R.id.playbtn);
        profilebtn = findViewById(R.id.profilebtn);
        favrotbtn = findViewById(R.id.favrotbtn);
        mymusic = findViewById(R.id.mymusic);

        dailybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dailymusicpage = new Intent(Homepage.this,dailymusicpage.class);
                startActivity(dailymusicpage);
            }
        });

        playbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playlistpage = new Intent(Homepage.this,playlistpage.class);
                startActivity(playlistpage);
            }
        });
        favrotbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent favouritpage = new Intent(Homepage.this,favouritpage.class);
                startActivity(favouritpage);
            }
        });
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playmusic = new Intent(Homepage.this, playmusic.class);
                startActivity(playmusic);
            }
        });

        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profilepage = new Intent(Homepage.this, profilepage.class);
                startActivity(profilepage);
            }
        });

        mymusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Mymusicpage = new Intent(Homepage.this, Mymusicpage.class);
                startActivity(Mymusicpage);
            }
        });



    }
}