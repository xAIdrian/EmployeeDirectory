package com.amohnacs.squareemployeedirectory.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amohnacs.squareemployeedirectory.R
import com.amohnacs.squareemployeedirectory.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}