package com.akash.singh.alarmSettings

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.akash.singh.Interfaces.KotlinActivitiesInterface
import com.akash.singh.Interfaces.SettingsFragmentInterface
import com.akash.singh.R
import com.akash.singh.extensions.get
import com.akash.singh.extensions.set
import com.akash.singh.tools.ConstantsPreferences
import com.akash.singh.tools.NotificationTools
import kotlinx.android.synthetic.main.fragment_option_set_message.*

class FragmentOptionSetMessage : Fragment(), SettingsFragmentInterface, KotlinActivitiesInterface {
    override lateinit var fragmentContext: Context

    private val TAG = this.javaClass.simpleName

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentContext = activity!!.applicationContext
        initializeDependOnContextVariables(fragmentContext)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_option_set_message, container, false)
    }

    override fun onResume() {
        super.onResume()
        initializeTextViewWithLastMessage()
        saveSettingsInSharedPreferences()
    }

    override fun onPause() {
        super.onPause()
        saveMessage()
    }

    private fun saveMessage() {
        var message = etSetAlarmMessage.text.toString()
        NotificationTools(fragmentContext).showToastMessage(getString(R.string.toast_message_was_saved))
        if (message.isEmpty()) {
            message = ConstantsPreferences.ALARM_TEXT_MESSAGE.defaultTextMessage
        }
        sharedPreferences[ConstantsPreferences.ALARM_TEXT_MESSAGE.getKeyValue()] = message
    }

    override fun initializeDependOnContextVariables(context: Context) {
        sharedPreferences = context.getSharedPreferences(ConstantsPreferences.ALARM_SP_NAME.getKeyValue(), Context.MODE_PRIVATE)
    }


    override fun initializeDependOnViewVariables(view: View?) {
    }

    override fun saveSettingsInSharedPreferences() {
    }

    private fun initializeTextViewWithLastMessage() {
        val savedMessage = sharedPreferences[ConstantsPreferences.ALARM_TEXT_MESSAGE.getKeyValue(), ""]
        if (savedMessage == ConstantsPreferences.ALARM_TEXT_MESSAGE.defaultTextMessage) {
            etSetAlarmMessage.setText("", TextView.BufferType.EDITABLE)
        } else {
            etSetAlarmMessage.setText(savedMessage, TextView.BufferType.EDITABLE)
        }
    }
}