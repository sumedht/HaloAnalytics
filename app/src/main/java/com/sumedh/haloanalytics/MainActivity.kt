package com.sumedh.haloanalytics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sumedh.haloanalytics.ui.theme.HaloAnalyticsTheme

class MainActivity : ComponentActivity() {

    val haloAnalytics: HaloAnalytics = HaloAnalytics()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HaloAnalyticsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    initAnalytics()
                    setUserIdentification()
                    sendAnalytics()
                }
            }
        }
    }

    private fun initAnalytics() {
        val frameworkList = arrayListOf<AnalyticsType>()
        frameworkList.add(AnalyticsType.GOOGLE)
        //frameworkList.add(AnalyticsType.BRAZE)
        haloAnalytics.init(this, frameworkList)
    }

    private fun setUserIdentification() {
        val properties: HashMap<String,String> = HashMap()
        properties.put("Location", "Pune")
        properties.put("Version", "2.1")
        properties.put("Network_type", "wifi")
        properties.put("screen_width", "1080")
        properties.put("screen_height", "1920")

        haloAnalytics.setUserIdentificationProperties(
            AnalyticsType.GOOGLE,
            "jkgjfhgkjsfgjksgjksfg",
            properties
        )
    }

    private fun sendAnalytics() {
        val properties: HashMap<String,String> = HashMap()
        properties.put("Location", "Pune")
        properties.put("Version", "2.1")
        properties.put("Network_type", "wifi")
        properties.put("screen_width", "1080")
        properties.put("screen_height", "1920")

        haloAnalytics.sendAnalytics(
            AnalyticsType.GOOGLE,
            "USER_INITIALIZE",
            properties
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HaloAnalyticsTheme {
        Greeting("Android")
    }
}