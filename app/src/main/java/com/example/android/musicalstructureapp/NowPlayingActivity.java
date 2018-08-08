package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        String sn = (String) b.get("Song Name");
        String sa = (String) b.get("Song Artist");
        String saa = (String) b.get("Song Album");
        Integer img = (Integer) b.get("Song Display");
        ImageView iv = findViewById(R.id.now_playing_iv);
        iv.setImageResource(img);
        TextView tv = findViewById(R.id.Now_Playing_tv);
        tv.setText("Song Name: " + sn +" \n" +
                "            \nArtist: " + sa + " \n" +
                "            \nAlbum: " + saa);
    }
}
