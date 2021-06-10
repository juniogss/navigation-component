package com.junio.navigationcomponent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.junio.navigationcomponent.ui.profile.ProfileFragment
import com.junio.navigationcomponent.ui.start.StartFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}