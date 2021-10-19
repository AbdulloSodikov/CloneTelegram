package com.ak.sodikov.clonetelegram

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.ak.sodikov.clonetelegram.activities.RegisterActivity
import com.ak.sodikov.clonetelegram.databinding.ActivityMainBinding
import com.ak.sodikov.clonetelegram.objects.AppDrawer
import com.ak.sodikov.clonetelegram.ui.fragment.ChatsFragment
import com.ak.sodikov.clonetelegram.utilits.replaceActivity
import com.ak.sodikov.clonetelegram.utilits.replaceFragment


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMainBinding
    private lateinit var mToolbar : Toolbar
    private lateinit var mAppDrawer : AppDrawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFun()
    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar  // Инициализация ToolBar
        mAppDrawer = AppDrawer(this,mToolbar) // Инициализация AppDrawer для создания Drawer menu

    }


    private fun initFun() {
        if(false) {
            setSupportActionBar(mToolbar) // Передача  ToolBar
            mAppDrawer.create() // Cоздание Drawer menu
            replaceFragment(ChatsFragment())
        } else {
            replaceActivity(RegisterActivity())
        }
    }
}
