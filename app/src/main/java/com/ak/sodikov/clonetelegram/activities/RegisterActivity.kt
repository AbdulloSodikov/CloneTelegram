package com.ak.sodikov.clonetelegram.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.ak.sodikov.clonetelegram.R
import com.ak.sodikov.clonetelegram.databinding.ActivityRegisterBinding
import com.ak.sodikov.clonetelegram.ui.fragment.EnterPhoneNumberFragment
import com.ak.sodikov.clonetelegram.utilits.replaceFragment


class RegisterActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityRegisterBinding
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        //Toolbar для RegisterActivity
        mToolbar = mBinding.registerToolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.register_title_your_phone) // титал тулбара
        // Запуск EnterPhoneNumberFragment
       replaceFragment(EnterPhoneNumberFragment())
       }
}