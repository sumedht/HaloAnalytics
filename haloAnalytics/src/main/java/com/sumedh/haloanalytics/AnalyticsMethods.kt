package com.sumedh.haloanalytics

interface AnalyticsMethods {

    interface Google {
        fun init(): Google
        fun sendAnalytics(eventName: String, properties: Map<String, String>)
        fun setUserIdentificationProperties(userId: String, userProperties: Map<String, String>)
    }

    interface Amplitude {
        fun init(): Amplitude
        fun sendAnalytics(eventName: String, properties: Map<String, String>)
        fun setUserIdentificationProperties(userId: String, userProperties: Map<String, String>)
    }

    interface Braze {
        fun init(): Braze
        fun sendAnalytics(eventName: String, properties: Map<String, String>)
        fun setUserIdentificationProperties(userId: String, userProperties: Map<String, String>)
    }
}