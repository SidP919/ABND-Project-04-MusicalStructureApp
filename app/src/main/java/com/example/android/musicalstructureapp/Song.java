package com.example.android.musicalstructureapp;

public class Song {
    private String songName;
    private String artistName;
    private String albumName;
    private int imageId;


    private int songId;

    public Song(String songName, String artistName, String albumName, int imageId, int songId) {
        this.songName = songName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.imageId = imageId;
        this.songId = songId;
    }

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

    public int getSongId() {
        return songId;
    }
}
