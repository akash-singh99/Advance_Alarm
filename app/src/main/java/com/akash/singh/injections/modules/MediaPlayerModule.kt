package com.akash.singh.injections.modules

import android.content.Context
import android.media.MediaPlayer
import com.akash.singh.alarmSettings.optionSetRingtone.MediaPlayerHelper
import dagger.Module
import dagger.Provides


@Module
class MediaPlayerHelperModule {
    @Provides
    fun provideMediaPlayerHelper(context: Context): MediaPlayerHelper = MediaPlayerHelper(context, MediaPlayer())
}