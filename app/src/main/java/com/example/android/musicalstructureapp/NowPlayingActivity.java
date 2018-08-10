package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

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
        tv.setText("Song Name: " + sn + " \n" +
                "            \nArtist: " + sa + " \n" +
                "            \nAlbum: " + saa);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cust_app_bar_menu,menu);
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
}
