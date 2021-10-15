package com.ak.sodikov.clonetelegram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.ak.sodikov.clonetelegram.databinding.ActivityMainBinding
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMainBinding
    private lateinit var mDrawer : Drawer
    private lateinit var mHeader :  AccountHeader
    private lateinit var mToolbar : Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar  // Инициализация ToolBar
        initFunction ()
    }


    private fun initFunction() {
       setSupportActionBar(mToolbar) // Передача  ToolBar
       createHeader()  //
       createDrawer()

    }

// Фунция для создания Header
    private fun createHeader(){
        mHeader = AccountHeaderBuilder()
            .withActivity(this)
            .withHeaderBackground(R.drawable.header) // Передаем Layout для Header
            .addProfiles(
                ProfileDrawerItem().withName("Абдулло Содиков")
                    .withEmail("+992918865861")
            ).build()
        }
// Функция для создания выдвежного меню (Drawer)
    private fun createDrawer (){
        mDrawer = DrawerBuilder()
            .withActivity(this)   // передаем активити
            .withToolbar(mToolbar) // передает ToolBar
            .withActionBarDrawerToggle(true) // ?
            .withSelectedItem(-1) //  окно по умолчанию
            .withAccountHeader(mHeader) // передаем Header
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(100)
                    .withIconTintingEnabled(true)
                    .withName("Создать группу")
                    .withSelectable(false)
            ).build()
    }


    }
