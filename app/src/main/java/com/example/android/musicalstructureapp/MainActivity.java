package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Song> songArrayList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent in = getIntent();
        Bundle b = in.getExtras();
        Integer comeBack = 0;
        if(b!=null)
            comeBack = (Integer)b.get("come back");
        if(comeBack == null || comeBack == 0){
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    LinearLayout loadingLayout = findViewById(R.id.loading_LL);
                    LinearLayout listLayout = findViewById(R.id.list_LL);
                    listLayout.setVisibility(View.VISIBLE);
                    loadingLayout.setVisibility(View.INVISIBLE);
                }
            }, 2000);
        }else{
            LinearLayout loadingLayout = findViewById(R.id.loading_LL);
            LinearLayout listLayout = findViewById(R.id.list_LL);
            listLayout.setVisibility(View.VISIBLE);
            loadingLayout.setVisibility(View.INVISIBLE);
        }

        songArrayList = new ArrayList<>();

        songArrayList.add(new Song("Raabta", "Arijit Singh",
                "Agent Vinod", R.drawable.raabta));
        songArrayList.add(new Song("Yeh Dil Deewana", "Sonu Nigam",
                "Pardes", R.drawable.yehdildeewana));
        songArrayList.add(new Song("Ae Dil Hai Mushkil", "Arijit Singh",
                "Ae Dil Hai Mushkil", R.drawable.aedilhaimushkil));
        songArrayList.add(new Song("Love Story", "Taylor Swift",
                "Who's That Girl", R.drawable.lovestory));
        songArrayList.add(new Song("I Want It That Way", "Backstreet Boys",
                "Millennium", R.drawable.iwantitthatway));
        songArrayList.add(new Song("Main Zindagi Ka Saath", "Mohammed Rafi",
                "Hum Dono", R.drawable.maizindagikasaath));
        songArrayList.add(new Song("Lean On", "Major Lazer, DJ Snake ft. MØ",
                "Peace Is The Mission", R.drawable.leanon));
        songArrayList.add(new Song("Bolna", "Arijit Singh, Asees Kaur",
                "Kapoor & Sons", R.drawable.bolna));
        songArrayList.add(new Song("Main Rahoon Ya Na Rahoon", "Armaan Malik",
                "Main Rahoon Ya Na Rahoon", R.drawable.mainrahoonyanarahoon));
        songArrayList.add(new Song("As Long As You Love Me", "Backstreet Boys",
                "Backstreet's Back", R.drawable.aslongasyouloveme));
        songArrayList.add(new Song("Everybody", "Backstreet Boys",
                "Backstreet's Back", R.drawable.everybody));
        listView = findViewById(R.id.songs_list);
        MySongAdapter sa = new MySongAdapter(this, songArrayList);
        listView.setAdapter(sa);
        listView.setOnItemClickListener(new MyListener());
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
            startActivity(intn);
        }
    }
}
