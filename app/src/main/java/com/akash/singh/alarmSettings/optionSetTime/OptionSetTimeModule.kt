package com.akash.singh.alarmSettings.optionSetTime

import com.akash.singh.injections.scope.FragmentScope
import dagger.Binds
import dagger.Module


@Module
public abstract class OptionSetTimeModule {
    @FragmentScope
    @Binds
    abstract fun getOptionSetTimePresenter(presenter: OptionSetTimePresenter): OptionSetTimeContract.Presenter
}