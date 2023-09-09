package com.akash.singh.alarmSettings.optionSetRingtone

import com.akash.singh.injections.scope.FragmentScope
import dagger.Module
import dagger.Provides


@Module
public class OptionSetRingtoneModule {
    @FragmentScope
    @Provides
    public fun provideOptionSetRingtonePresenter(presenter: OptionSetRingtonePresenter): OptionSetRingtoneContract.Presenter = presenter

}