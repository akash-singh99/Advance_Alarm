package com.akash.singh.alarmSettings.mainSettings

import com.akash.singh.alarmSettings.FragmentCreationHelper
import com.akash.singh.injections.scope.ActivityScope
import com.akash.singh.tools.ConstantValues
import dagger.Module
import dagger.Provides


@Module
class AlarmSettingsModule {
    @ActivityScope
    @Provides
    fun provideFragmentCreationHelper(activity: AlarmSettingsActivity) = FragmentCreationHelper(activity)

    @ActivityScope
    @Provides
    fun provideAlarmSettingsPresenter(fragmentToLoad: AlarmSettingsNames, activity: AlarmSettingsActivity)
            : AlarmSettingsContract.Presenter = AlarmSettingsPresenter(fragmentToLoad, activity)

    @ActivityScope
    @Provides
    fun provideIndexOfFragmentToLoad(activity: AlarmSettingsActivity): AlarmSettingsNames =
            AlarmSettingsNames.OPTION_SET_TIME.getAlarmSettingName(
                    activity.intent.getIntExtra(ConstantValues.INTENT_KEY_WHICH_FRAGMENT_TO_LOAD_FIRST,
                            AlarmSettingsNames.OPTION_WRONG.getKeyValue()))
}