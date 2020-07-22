package com.cheermesdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cheerme.CheerMe
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CheerMe.init(mainLayout, this, "862fae93-4187-4214-8170-08ce532facfe")
    }
}
