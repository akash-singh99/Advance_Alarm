package com.akash.singh.alarms.mathAlarm.services.displayAlarmService

import com.akash.singh.alarmSettings.optionSetRingtone.MediaPlayerHelper
import com.akash.singh.data.AlarmDataHelper
import javax.inject.Inject

class DisplayAlarmServicePresenter @Inject constructor(private val dataHelper: AlarmDataHelper, private val mediaPlayer: MediaPlayerHelper) : DisplayAlarmServiceContract.Presenter {
    override fun start() {
    }

    override fun playRingtone() {
        mediaPlayer.playRingtone(dataHelper.getSavedRingtoneAlarmOb(), true)
    }

    override fun getDeepWakeUpState() = dataHelper.getDeepWakeUpStateFromSP()

    override fun playDeepWakeUpRingtone() {
        mediaPlayer.playDeepWakeUpRingtone(dataHelper.getSavedDeepWakeUpRingtoneOb())
    }

    override fun stopPlayingRingtone() {
        mediaPlayer.stopPlaying()

    }

    override fun releaseObjects() {
        mediaPlayer.releaseMediaPlayer()
    }

}