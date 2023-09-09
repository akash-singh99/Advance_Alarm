package com.akash.singh.alarmSettings.optionDeepWakeUp

import com.akash.singh.injections.scope.FragmentScope
import dagger.Binds
import dagger.Module


@Module
abstract class OptionSetDeepWakeUpModule {
    @FragmentScope
    @Binds
    abstract fun getOptionSetDeepWakeUpPresenter(presenter: OptionSetDeepWakeUpPresenter): OptionSetDeepWakeUpContract.Presenter
}