package com.akash.singh.alarms.mathAlarm.services.displayAlarmService

import com.akash.singh.injections.scope.DisplayAlarmServiceScope
import dagger.Binds
import dagger.Module

@Module
abstract class DisplayAlarmServiceModule {
    @DisplayAlarmServiceScope
    @Binds
    abstract fun provideDisplayAlarmServicePresenter(presenter: DisplayAlarmServicePresenter): DisplayAlarmServiceContract.Presenter

}