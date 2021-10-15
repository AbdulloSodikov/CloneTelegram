package com.ak.sodikov.clonetelegram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ak.sodikov.clonetelegram.databinding.ActivityMainBinding

private lateinit var mBinding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}s