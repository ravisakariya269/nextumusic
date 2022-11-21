package com.example.nextu;

import android.net.Uri;

public class musiclist {

    private  String title,artist,duration;
    private boolean isPlaying;
    private Uri musicfile;

    /*create constructor  for music title , artist ,duration time for song ,playing song*/

    public musiclist(String title, String artist, String duration, boolean isPlaying,Uri musicfile) {
        /*call the method */

        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.isPlaying = isPlaying;
        this.musicfile = musicfile;

    }


    /*get method for get the construct */

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getDuration() {
        return duration;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public Uri getMusicfile() {
        return musicfile;
    }
}
