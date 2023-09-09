package com.akash.singh.alarms.mathAlarm.displayAlarm

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import com.akash.singh.data.AlarmDataHelper
import javax.inject.Inject

class DisplayAlarmViewModel @Inject constructor(private val dataHelper: AlarmDataHelper) : ViewModel() {
    val userTextMessage: String = "\"" + dataHelper.getTextMessageFromSP() + "\""
    val isShowExplanationDialog = ObservableBoolean()

    init {
        isShowExplanationDialog.set(dataHelper.getIsTaskExplanationShow())
    }

    fun setIsShowExplanationDialog(state : Boolean){
        dataHelper.saveIsTaskExplanationShow(state)
    }
}