package com.akash.singh.alarmSettings

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.akash.singh.R
import com.akash.singh.alarmSettings.optionSetRingtone.FragmentOptionSetRingtone
import com.akash.singh.injections.scope.ActivityScope
import com.akash.singh.tools.ShowLogs
import javax.inject.Inject


@ActivityScope
class FragmentCreationHelper @Inject constructor(activity: FragmentActivity) {
    private val fragmentManager: FragmentManager = activity.supportFragmentManager
    private val TAG: String = this.javaClass.simpleName

    fun loadFragment(fragment: Fragment) {
        ShowLogs.log(TAG, "loadFragment + fragment " + fragment.toString())
        fragmentManager.beginTransaction()
                .replace(R.id.flFragmentsContainer, fragment)
                .addToBackStack(null)
                .commit()

    }

    fun getFragmentFormContainer(): Fragment {
        return fragmentManager.findFragmentById(R.id.flFragmentsContainer)
                ?: FragmentOptionSetRingtone()

    }
}
