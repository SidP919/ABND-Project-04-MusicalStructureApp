package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Song> songArrayList;
    private ListView listView;
    public static int counter = 0;
    MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent in = getIntent();
        Bundle b = in.getExtras();
        Integer comeBack = 0;
        if (b != null)
            comeBack = (Integer) b.get("come back");
        if (comeBack == null || comeBack == 0) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    LinearLayout loadingLayout = findViewById(R.id.loading_LL);
                    RelativeLayout listLayout = findViewById(R.id.list_RL);
                    listLayout.setVisibility(View.VISIBLE);
                    loadingLayout.setVisibility(View.INVISIBLE);
                }
            }, 2000);
        } else {
            LinearLayout loadingLayout = findViewById(R.id.loading_LL);
            RelativeLayout listLayout = findViewById(R.id.list_RL);
            listLayout.setVisibility(View.VISIBLE);
            loadingLayout.setVisibility(View.INVISIBLE);
        }

        songArrayList = new ArrayList<>();

        songArrayList.add(new Song("Raabta", "Arijit Singh",
                "Agent Vinod", R.drawable.raabta, R.raw.one_raabta));
        songArrayList.add(new Song("Yeh Dil Deewana", "Sonu Nigam",
                "Pardes", R.drawable.yehdildeewana, R.raw.two_yehdildeewana));
        songArrayList.add(new Song("Ae Dil Hai Mushkil", "Arijit Singh",
                "Ae Dil Hai Mushkil", R.drawable.aedilhaimushkil, R.raw.three_aedil_haimushkil));
        songArrayList.add(new Song("Love Story", "Taylor Swift",
                "Who's That Girl", R.drawable.lovestory, R.raw.four_love_story));
        songArrayList.add(new Song("I Want It That Way", "Backstreet Boys",
                "Millennium", R.drawable.iwantitthatway, R.raw.five_iwantit_thatway));
        songArrayList.add(new Song("Main Zindagi Ka Saath", "Mohammed Rafi",
                "Hum Dono", R.drawable.maizindagikasaath, R.raw.eight_main_zindagika_saath));
        songArrayList.add(new Song("Lean On", "Major Lazer, DJ Snake ft. MØ",
                "Peace Is The Mission", R.drawable.leanon, R.raw.six_lean_on));
        songArrayList.add(new Song("Bolna", "Arijit Singh, Asees Kaur",
                "Kapoor & Sons", R.drawable.bolna, R.raw.seven_bolna));
        songArrayList.add(new Song("Main Rahoon Ya Na Rahoon", "Armaan Malik",
                "Main Rahoon Ya Na Rahoon", R.drawable.mainrahoonyanarahoon, R.raw.eleven_mainrahoonyanarahoon));
        songArrayList.add(new Song("As Long As You Love Me", "Backstreet Boys",
                "Backstreet's Back", R.drawable.aslongasyouloveme, R.raw.nine_as_long_as_you_love_me));
        songArrayList.add(new Song("Everybody", "Backstreet Boys",
                "Backstreet's Back", R.drawable.everybody, R.raw.ten_everybody));
        listView = findViewById(R.id.songs_list);
        MySongAdapter sa = new MySongAdapter(this, songArrayList);
        listView.setAdapter(sa);
        listView.setOnItemClickListener(new MyListener());
    }

    public void playPause(View view) {
        if (AudioPlay.isplayingAudio)
            AudioPlay.playpauseAudio();
    }

    public void forwardTen(View view) {
        if (AudioPlay.isplayingAudio)
            AudioPlay.forwardTen();
    }

    public void previousTen(View view) {
        if (AudioPlay.isplayingAudio)
            AudioPlay.previousTen();
    }

    public class MyListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Song s = songArrayList.get(i);
            Intent intn = new Intent(MainActivity.this, NowPlayingActivity.class);
            intn.putExtra("Song Name", s.getSongName());
            intn.putExtra("Song Artist", s.getArtistName());
            intn.putExtra("Song Album", s.getAlbumName());
            intn.putExtra("Song Display", s.getImageId());
            if (s.getSongId() != 0) {
                intn.putExtra("Song File", s.getSongId());
            }

//            if(s.getSongId()!=-1 && counter ==0){
//                mPlayer = MediaPlayer.create(MainActivity.this,s.getSongId());
//                mPlayer.start();
//                counter++;
//            }else {
//                if(mPlayer.isPlaying()){
//                    mPlayer.release();
//                    mPlayer = MediaPlayer.create(MainActivity.this, s.getSongId());
//                    mPlayer.start();
//                    counter = 1;
//                }
//            }
            if (!AudioPlay.isplayingAudio) {
                AudioPlay.playAudio(MainActivity.this, s.getSongId());
            } else {
                AudioPlay.changeSong(MainActivity.this, s.getSongId());
            }

            startActivity(intn);
        }
    }
}
