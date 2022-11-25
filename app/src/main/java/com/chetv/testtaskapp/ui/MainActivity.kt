package com.chetv.testtaskapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chetv.testtaskapp.R
import com.chetv.testtaskapp.databinding.ActivityMainBinding
import com.chetv.testtaskapp.ui.main.MainFragment
import dagger.Provides


class MainActivity : AppCompatActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val biding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(biding.root)

    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
        .add(R.id.container, MainFragment())
        .commitAllowingStateLoss()
    }
  }
}