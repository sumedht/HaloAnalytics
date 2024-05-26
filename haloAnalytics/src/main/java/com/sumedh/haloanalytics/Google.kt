package com.sumedh.haloanalytics

import android.util.Log

class Google : AnalyticsMethods.Google, AnalyticsFramework {
    val TAG = "GOOGLE"
    override fun init(): Google {
        return Google()
    }

    override fun sendAnalytics(eventName: String, properties: Map<String, String>) {
        Log.d(TAG, "---- sendAnalytics ----")
        Log.d(TAG, "---- EventName: $eventName")
        Log.d(TAG, "---- Properties: ${properties.toString()}")

    }

    override fun setUserIdentificationProperties(
        userId: String,
        userProperties: Map<String, String>
    ) {
        Log.d(TAG, "---- setUserIdentificationProperties ----")
        Log.d(TAG, "---- EventName: $userId")
        Log.d(TAG, "---- Properties: ${userProperties.toString()}")
    }

}