package com.example.android.musicalstructureapp;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class AudioPlay {

    public static MediaPlayer mediaPlayer;
    private static SoundPool soundPool;
    public static boolean isplayingAudio=false;
    public static boolean isAudioPaused=false;

    public static void playAudio(Context c,int id){
        mediaPlayer = MediaPlayer.create(c,id);
        soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        if(!mediaPlayer.isPlaying())
        {
            mediaPlayer.start();
            isplayingAudio=true;
        }
    }

    public static void changeSong(Context c, int id){
        mediaPlayer.stop();
		mediaPlayer.release();
        isplayingAudio=false;
        playAudio(c,id);
    }

    public static void playpauseAudio(){
        if(isAudioPaused==false){
            mediaPlayer.pause();
            isAudioPaused=true;
        }
        else if(isAudioPaused==true){
            mediaPlayer.start();
            isAudioPaused=false;
        }
    }

    public static void forwardTen(){
        int forward = mediaPlayer.getCurrentPosition() + 10000;
        mediaPlayer.seekTo(forward);
    }

    public static void previousTen(){
        int prev = mediaPlayer.getCurrentPosition() - 10000;
        if(prev>=0)
            mediaPlayer.seekTo(prev);
        else {
            mediaPlayer.seekTo(0);
        }
    }
}
