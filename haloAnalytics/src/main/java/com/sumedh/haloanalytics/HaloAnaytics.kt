package com.sumedh.haloanalytics

import android.content.Context
import android.widget.Toast

class HaloAnalytics {

    var frameworkObjList = arrayListOf<AnalyticsFramework>()
    lateinit var frameworkObjItem : AnalyticsFramework
    lateinit var mContext: Context

    fun init(context: Context, framework: List<AnalyticsType>) {
        mContext = context
        if (framework.isEmpty()) {
            Toast.makeText(context, "Please provide value of framework", Toast.LENGTH_LONG).show()
            return
        }

        frameworkObjItem = Google()
        var j =0
        for(i in framework) {
            if (framework.get(j) == AnalyticsType.GOOGLE) {

                frameworkObjItem = (frameworkObjItem as Google).init()
                frameworkObjList.add(frameworkObjItem)
            }

            if (framework.get(j) == AnalyticsType.BRAZE) {
                frameworkObjItem = (frameworkObjItem as Braze).init()
                frameworkObjList.add(frameworkObjItem)

            }

            if (framework.get(j) == AnalyticsType.AMPLITUDE) {
                frameworkObjItem = Amplitude()
                frameworkObjList.add(frameworkObjItem)
            }
            j++
        }
    }

    fun setUserIdentificationProperties(analyticsType: AnalyticsType, userId: String, userProperties: Map<String, String>) {
        if (!checkIfFrameworkIsInitialized(analyticsType)) {
            Toast.makeText(mContext, "Please provide value of framework", Toast.LENGTH_LONG).show()
            return
        } else {
            if (analyticsType == AnalyticsType.GOOGLE) {
                (frameworkObjItem as Google).setUserIdentificationProperties(userId, userProperties)
            }

            else if (analyticsType == AnalyticsType.BRAZE) {
                (frameworkObjItem as Braze).setUserIdentificationProperties(userId, userProperties)
            }

            else if (analyticsType == AnalyticsType.AMPLITUDE) {
                (frameworkObjItem as Amplitude).setUserIdentificationProperties(userId, userProperties)
            }
        }
    }

    fun sendAnalytics(analyticsType: AnalyticsType, eventName: String, properties: Map<String, String>) {
        if (checkIfFrameworkIsInitialized(analyticsType)) {
            Toast.makeText(mContext, "Please provide value of framework", Toast.LENGTH_LONG).show()
            return
        }
        else {
            if (analyticsType == AnalyticsType.GOOGLE) {
                (frameworkObjItem as Google).sendAnalytics(eventName, properties)
            }

            else if (analyticsType == AnalyticsType.BRAZE) {
                (frameworkObjItem as Braze).sendAnalytics(eventName, properties)
            }

            else if (analyticsType == AnalyticsType.AMPLITUDE) {
                (frameworkObjItem as Amplitude).sendAnalytics(eventName, properties)
            }
        }
    }

    private fun checkIfFrameworkIsInitialized(analyticsType: AnalyticsType) : Boolean{

        if (analyticsType == AnalyticsType.GOOGLE) {
            if (frameworkObjList.contains(frameworkObjItem as Google))
                return true
        }

        else if (analyticsType == AnalyticsType.BRAZE) {
            if (frameworkObjList.contains(frameworkObjItem as Braze))
                return true
        }

        else if (analyticsType == AnalyticsType.AMPLITUDE) {
            if (frameworkObjList.contains(frameworkObjItem as Amplitude))
                return true
        }
        return false
    }
}