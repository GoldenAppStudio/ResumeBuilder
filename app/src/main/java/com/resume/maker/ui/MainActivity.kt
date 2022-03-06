package com.resume.maker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.resume.maker.R
import com.resume.maker.utils.navigateToFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*home_iv_bottom_navigation.setOnClickListener {
            navigateToFragment(this, R.id.nav_host_fragment_container, R.id.home_fragment)
        }

        edit_iv_bottom_navigation.setOnClickListener {
            navigateToFragment(
                this,
                R.id.nav_host_fragment_container,
                R.id.edit_fragment
            )
        }

        share_iv_bottom_navigation.setOnClickListener {
            navigateToFragment(this, R.id.nav_host_fragment_container, R.id.share_fragment)
        }*/
    }
}