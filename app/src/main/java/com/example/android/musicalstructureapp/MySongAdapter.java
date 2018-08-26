package com.example.android.musicalstructureapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MySongAdapter extends ArrayAdapter<Song> {

    View listView;
    private TextView songNameView;
    private TextView songArtistView;
    private ImageView playView;

    public MySongAdapter(@NonNull Context context, ArrayList<Song> resource) {
        super(context, 0, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list_item, parent, false
            );
        }
        songNameView = listView.findViewById(R.id.songName_View);
        songArtistView = listView.findViewById(R.id.artistName_View);

        Song s = getItem(position);

        songNameView.setText(s.getSongName());
        songArtistView.setText("By " + s.getArtistName());
        songNameView.setClickable(true);
        songArtistView.setClickable(true);

        return listView;
    }
}
