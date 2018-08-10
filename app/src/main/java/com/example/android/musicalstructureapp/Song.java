package com.example.android.musicalstructureapp;

public class Song {
    String songName;
    String artistName;
    String albumName;
    int imageId;

    public Song(String songName, String artistName, String albumName, int imageId) {
        this.songName = songName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.imageId = imageId;
    }

    public String getSongName() {
        return this.songName;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public int getImageId() {
        return this.imageId;
    }
}
