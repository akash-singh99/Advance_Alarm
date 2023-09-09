package com.akash.singh.alarms.mathAlarm.mainAlarm

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import com.akash.singh.R
import com.akash.singh.alarmSettings.mainSettings.AlarmSettingsActivity
import com.akash.singh.alarmSettings.mainSettings.AlarmSettingsNames
import com.akash.singh.alarms.mathAlarm.AlarmManagerHelper
import com.akash.singh.alarms.mathAlarm.AlarmObject
import com.akash.singh.databinding.CustomViewAlertDialogSetingsPreviewBinding
import com.akash.singh.tools.ConstantValues
import com.akash.singh.tools.NotificationTools
import javax.inject.Inject



class PreviewOfAlarmSettings @Inject constructor(private val context: Context,
                                                 private val mainViewModel: MainAlarmViewModel,
                                                 private val notificationsTools: NotificationTools) : View.OnClickListener {
    private val TAG = this.javaClass.simpleName
    private val alarmObject = mainViewModel.getAlarmDataObject()

    private lateinit var alertDialog: AlertDialog
    private lateinit var binding: CustomViewAlertDialogSetingsPreviewBinding

    fun showSettingsPreviewDialog() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.custom_view_alert_dialog_setings_preview,
                null, false)
        with(binding) {
            viewModel = mainViewModel
            executePendingBindings()
        }
        setOnClickListeners()
        alertDialog = AlertDialog.Builder(context, R.style.AlertDialogCustomStyle)
                .setTitle(R.string.settingsPreviewTitle)
                .setView(binding.root)
                .setPositiveButton(R.string.settingsPreviewPositiveButtonText) { dialogInterface, i ->
                    scheduleNewAlarm(alarmObject)
                }
                .setNegativeButton(R.string.settingsPreviewNegativeButtonText) { dialogInterface, i ->
                    dialogInterface.dismiss()
                }.create()

        alertDialog.show()

    }

    override fun onClick(v: View?) {
        with(binding) {
            when (v) {
                tvTimePreview -> {
                    showChosenSettingsFragment(AlarmSettingsNames.OPTION_SET_TIME.getKeyValue())
                }
                tvRingtonePreview -> {
                    showChosenSettingsFragment(AlarmSettingsNames.OPTION_SET_RINGTONE.getKeyValue())
                }
                tvTextMessagePreview -> {
                    showChosenSettingsFragment(AlarmSettingsNames.OPTION_SET_MESSAGE.getKeyValue())
                }
                swDeepWakeUpPreview -> {
                    showChosenSettingsFragment(AlarmSettingsNames.OPTION_SET_DEEP_WAKE_UP.getKeyValue())
                    if (swDeepWakeUpPreview.isChecked) {
                        swDeepWakeUpPreview
                    }
                }
            }
        }
        alertDialog.dismiss()
    }

    private fun scheduleNewAlarm(alarmObject: AlarmObject) {
        AlarmManagerHelper(context).setNewAlarm(alarmObject)
        notificationsTools.showToastMessage(context.getString(R.string.alarmActivatedMessage))

    }

    private fun showChosenSettingsFragment(which: Int) {
        context.startActivity(Intent(context, AlarmSettingsActivity::class.java)
                .putExtra(ConstantValues.INTENT_KEY_WHICH_FRAGMENT_TO_LOAD_FIRST, which)
        )
    }

    private fun setOnClickListeners() {
        with(binding) {
            tvTimePreview.setOnClickListener(this@PreviewOfAlarmSettings)
            tvRingtonePreview.setOnClickListener(this@PreviewOfAlarmSettings)
            tvTextMessagePreview.setOnClickListener(this@PreviewOfAlarmSettings)
            swDeepWakeUpPreview.setOnClickListener(this@PreviewOfAlarmSettings)
        }
    }

}