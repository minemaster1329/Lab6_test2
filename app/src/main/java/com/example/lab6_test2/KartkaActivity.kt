package com.example.lab6_test2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView

class KartkaActivity : AppCompatActivity() {
    var presentsString = ""
    var imageString = ""
    @SuppressLint("JavascriptInterface", "SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presentsString = intent.getStringExtra("presents").toString()
        imageString = intent.getStringExtra("photo_path").toString()
        val webView = WebView(this)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("file:///android_asset/kartka.html")
        webView.addJavascriptInterface(this, "activity")
        setContentView(webView)
    }

    @JavascriptInterface
    fun getPresents(): String {
        return presentsString;
    }

    @JavascriptInterface
    fun getImageSrc() : String{
        return imageString
    }
}