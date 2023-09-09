package com.akash.singh.alarmSettings.optionSetRingtone

import com.akash.singh.Interfaces.BasePresenter
import com.akash.singh.Interfaces.BaseView

interface OptionSetRingtoneContract {

    interface View : BaseView<Presenter> {
        var positionOfPlayingButtonItem: Int
        fun itemChangedRefreshRecycleView(itemPosition: Int)
    }

    interface Presenter : BasePresenter<View> {
        val ringtonePopulationList: ArrayList<RingtoneObject>
        fun setIsPlayingToFalse(whichIndex: Int)
        fun stopPlayingRingtone()

        fun setCheckedOrPlayingToFalse(actionIsCheckedOrPlaying: (RingtoneObject) -> Boolean,
                                 actionSetFalse: (RingtoneObject) -> Unit)

        fun setClickedIndexToTrue(actionSetTrue: (RingtoneObject) -> Unit,
                                  actionSetFalse: (RingtoneObject) -> Unit,
                                  actionIsCheckedOrPlaying: (RingtoneObject) -> Boolean,
                                  position: Int)

        fun playChosenRingtone(position: Int)

        fun saveChosenRingtoneNameSP(elementIndex : Int)

        fun getSavedRingtonePosition() : RingtoneObject

        fun initializeLastSavedRingtone()

        fun releaseObjects()

    }
}