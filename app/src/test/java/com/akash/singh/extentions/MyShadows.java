package com.akash.singh.extentions;

import android.media.MediaPlayer;

import org.robolectric.Shadows;
import org.robolectric.shadow.api.Shadow;


public class MyShadows extends Shadows {
    public static MyShadowMediaPlayer myShadowOf(MediaPlayer mediaPlayer) {
        return (MyShadowMediaPlayer) Shadow.extract(mediaPlayer);
    }
}
