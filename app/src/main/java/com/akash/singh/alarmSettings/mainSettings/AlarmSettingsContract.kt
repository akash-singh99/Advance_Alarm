package com.akash.singh.alarmSettings.mainSettings

import com.akash.singh.Interfaces.BasePresenter
import com.akash.singh.Interfaces.BaseView


interface AlarmSettingsContract {
    interface View : BaseView<Presenter> {
        fun blockInitialButton(loadedFragmentName: AlarmSettingsNames)
        fun moveToMainActivity()
        fun getCurrentFragmentIndex(): Int
        fun moveToNextFragment(currentFragmentIndex: Int)
        fun moveToPreviousFragment(currentFragmentIndex: Int)
        fun loadChosenFragment(fragmentName: AlarmSettingsNames)
    }

    interface Presenter : BasePresenter<View> {
        fun showChosenFragment(fragmentIndex: Int)
        fun showNextPreviousFragment(isNextFragment: Boolean)

        /**
         * @param whichFragmentIndex used for cases when new fragment is still loading
         * but gerCurrentFragmentIndex() returns previous (old one).
         */
        fun isLastSettingsFragment(whichFragmentIndex: Int = 0): Boolean

        fun isFirstSettingsFragment(whichFragmentIndex: Int = 0): Boolean
    }

}