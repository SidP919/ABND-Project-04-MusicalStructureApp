package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    private static int counter = 0;
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        String sn = b.getString("Song Name", "Unknown Song");
        String sa = b.getString("Song Artist", "Unknown Artist");
        String saa = b.getString("Song Album", "Unknown Album");
        int img = b.getInt("Song Display", -1);
        int songId = b.getInt("Song File", -1);
        ImageView iv = findViewById(R.id.now_playing_iv);
        iv.setImageResource(img);
        TextView tv = findViewById(R.id.Now_Playing_tv);

        if (songId != -1) {
            Log.d("NowPlayingActivity", "OnCreate: songId = " + songId);

        }

        tv.setText("Song Name: " + sn + " \n" +
                "            \nArtist: " + sa + " \n" +
                "            \nAlbum: " + saa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cust_app_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);// New activity
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("come back", 1);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void playPause(View view) {
        AudioPlay.playpauseAudio();
    }

    public void forwardTen(View view) {
        AudioPlay.forwardTen();
    }


    public void previousTen(View view) {
        AudioPlay.previousTen();
    }
}
