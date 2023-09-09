package com.akash.singh.smartAlarm

import com.akash.singh.alarms.mathAlarm.displayAlarm.DisplayAlarmViewModel
import com.akash.singh.testingTools.AlarmDataHelperStub
import org.junit.Before

class DisplayAlarmViewModelTest {
    private val dataHelperStub = AlarmDataHelperStub(ArrayList(), 2)
    private lateinit var testedClass: DisplayAlarmViewModel

    @Before
    fun setUp() {
        testedClass = DisplayAlarmViewModel(dataHelperStub)
    }
}