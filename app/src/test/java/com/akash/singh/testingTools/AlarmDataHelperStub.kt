package com.akash.singh.testingTools

import android.content.SharedPreferences
import com.akash.singh.alarmSettings.optionSetRingtone.RingtoneManagerHelper
import com.akash.singh.alarmSettings.optionSetRingtone.RingtoneObject
import com.akash.singh.data.AlarmDataHelper
import org.mockito.Mockito.mock


class AlarmDataHelperStub(private val ringtonesList: ArrayList<RingtoneObject>, private val lastSavedRingtoneIndex: Int) : AlarmDataHelper(mSharedPreferences, mRingtoneManagerHelper) {
    companion object {
        private val mRingtoneManagerHelper = mock(RingtoneManagerHelper::class.java)
        private val mSharedPreferences = mock(SharedPreferences::class.java)

    }

    override fun getRingtonesForPopulation(): ArrayList<RingtoneObject> {
        return ringtonesList
    }

    override fun getSavedRingtoneAlarmOb(ringtoneList: ArrayList<RingtoneObject>): RingtoneObject {
        return ringtonesList[lastSavedRingtoneIndex]
    }

    override fun getTextMessageFromSP(): String {
        return ""
    }

}