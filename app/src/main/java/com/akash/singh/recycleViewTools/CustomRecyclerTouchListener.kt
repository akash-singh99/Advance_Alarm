package com.akash.singh.recycleViewTools

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent
import com.akash.singh.alarmSettings.optionSetRingtone.RingtoneClickListeners


class CustomRecyclerTouchListener(context: Context, private val clickListener: RingtoneClickListeners) : RecyclerView.OnItemTouchListener {
    private val gestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            return true
        }
    })

    override fun onTouchEvent(rv: RecyclerView?, e: MotionEvent?) {
    }

    override fun onInterceptTouchEvent(rv: RecyclerView?, e: MotionEvent?): Boolean {
        if (e != null) {
            val child = rv?.findChildViewUnder(e.x, e.y)
            if (child != null && gestureDetector.onTouchEvent(e)) {
                clickListener.recycleViewClickListener(child, rv.getChildAdapterPosition(child))

            }
        }
        return false
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
    }


}

