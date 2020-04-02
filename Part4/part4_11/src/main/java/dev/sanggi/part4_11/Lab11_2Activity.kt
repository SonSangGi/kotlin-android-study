package dev.sanggi.part4_11

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab11_2.*

class Lab11_2Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab11_2)

        webview.settings.javaScriptEnabled = true
        webview.loadUrl("file:///android_asset/test.html")
        webview.addJavascriptInterface(JavascriptTest(), "android")
        webview.webChromeClient = MyWebChrome()
        webview.webViewClient = MyWebClient()

        btn_chart_bar.setOnClickListener(this)
        btn_chart_line.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            btn_chart_line -> webview.loadUrl("javascript:lineChart()")
            btn_chart_bar -> webview.loadUrl("javascript:barChart()")
        }
    }

    inner class JavascriptTest {
        @get:JavascriptInterface
        val chartData: String
            get() {
                val buffer = StringBuffer()
                buffer.append("[")
                for (i in 0..13) {
                    buffer.append("[" + i + "," + Math.sin(i.toDouble()) + "]")
                    if (i < 13) buffer.append(",")
                }
                buffer.append("]")
                return buffer.toString()
            }
    }

    inner class MyWebClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView,
            url: String
        ): Boolean {
            val t = Toast.makeText(this@Lab11_2Activity, url, Toast.LENGTH_SHORT)
            t.show()
            return true
        }
    }

    inner class MyWebChrome : WebChromeClient() {
        override fun onJsAlert(
            view: WebView,
            url: String,
            message: String,
            result: JsResult
        ): Boolean {
            val t = Toast.makeText(this@Lab11_2Activity, message, Toast.LENGTH_SHORT)
            t.show()
            result.confirm()
            return true
        }
    }
}
