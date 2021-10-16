package com.ak.sodikov.clonetelegram

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.ak.sodikov.clonetelegram.databinding.ActivityMainBinding
import com.ak.sodikov.clonetelegram.objects.AppDrawer
import com.ak.sodikov.clonetelegram.ui.fragment.ChatsFragment


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
        initFun ()
    }


    private fun initFun() {
       setSupportActionBar(mToolbar) // Передача  ToolBar
       mAppDrawer.create() // Cоздание Drawer menu
        supportFragmentManager.beginTransaction()
           .replace(R.id.dataContainer, ChatsFragment()).commit()

    }
}
