package com.projects.sharebutton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnshare = findViewById<Button>(R.id.sharebtn)
        val tv = findViewById<TextView>(R.id.textview)


        btnshare.setOnClickListener {
            val sharesub = "Please download our app from playstore:\nhttps://play.google.com/store/apps/details?id=com.app.glossaread&hl=en_IN&gl=US"
            tv.text = sharesub
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "$sharesub \nThank You ♡")
                type = "text/plain"
            }
            val shareintent = Intent.createChooser(sendIntent, "Share our app to: ")
            startActivity(shareintent)
        }
    }
}