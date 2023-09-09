package com.akash.singh.alarmSettings.optionDeepWakeUp

import com.akash.singh.alarmSettings.optionSetRingtone.MediaPlayerHelper
import com.akash.singh.alarmSettings.optionSetRingtone.RingtoneObject
import com.akash.singh.data.AlarmDataHelper
import javax.inject.Inject

class OptionSetDeepWakeUpPresenter @Inject constructor(private val dataHelper: AlarmDataHelper, private val mediaPlayer: MediaPlayerHelper) : OptionSetDeepWakeUpContract.Presenter {
    private lateinit var ringtoneObject: RingtoneObject

    override fun start() {
        ringtoneObject = dataHelper.getSavedDeepWakeUpRingtoneOb()
    }

    override fun playRingtone() {
        mediaPlayer.playDeepWakeUpRingtone(ringtoneObject)
    }

    override fun stopPlayingRingtone() {
        mediaPlayer.stopPlaying()
    }

    override fun getDeepWakeUpRingtoneName() = ringtoneObject.name

    override fun saveStateInSP(isChecked: Boolean) {
        dataHelper.saveDeepWakeUpStateInSP(isChecked)
    }

    override fun getStateFromSP(): Boolean = dataHelper.getDeepWakeUpStateFromSP()

    override fun releaseObjects() {
        mediaPlayer.releaseMediaPlayer()
    }
}