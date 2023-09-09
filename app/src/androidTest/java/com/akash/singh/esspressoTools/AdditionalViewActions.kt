package com.akash.singh.esspressoTools

import android.support.test.espresso.UiController
import android.support.test.espresso.ViewAction
import android.view.View
import org.hamcrest.Matcher


class AdditionalViewActions {
    companion object {
        fun actionAtChildView(id: Int, itemAction: ViewAction) = object : ViewAction {
            override fun getDescription(): String {
                return "Click on a child view with specified id: $id."
            }

            override fun getConstraints(): Matcher<View>? {
                return null
            }

            override fun perform(uiController: UiController?, v: View?) {
                val view: View? = v?.findViewById(id)
                itemAction.perform(uiController, view)
            }

        }
    }
}