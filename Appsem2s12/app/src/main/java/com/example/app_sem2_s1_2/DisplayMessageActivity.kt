package com.example.app_sem2_s1_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        //Con putExtra envié
        //Con getStringExtra lo recupero
        val message = intent.getStringExtra(EXTRA_MESS)

        val textView = findViewById<TextView>(R.id.tvName).apply {
            text = message
        }
    }
}