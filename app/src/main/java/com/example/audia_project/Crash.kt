package com.example.audia_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Crash : AppCompatActivity() {

    lateinit var crash: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crash)

        crash = findViewById(R.id.mCrach)
        val webSettings = crash.settings
        webSettings.javaScriptEnabled = true
        crash.loadUrl("https://keycollisioncenter.com/car-accident-repair/")


    }
}