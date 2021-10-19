package com.ak.sodikov.clonetelegram.objects

import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.ak.sodikov.clonetelegram.R
import com.ak.sodikov.clonetelegram.ui.fragment.SettingsFragment
import com.ak.sodikov.clonetelegram.utilits.replaceFragment
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class AppDrawer (val mainActivity : AppCompatActivity, val toolbar: Toolbar) {

    private lateinit var drawer : Drawer
    private lateinit var header : AccountHeader

    fun create () {
        createHeader()
        createDrawer()
    }


    // Фунция для создания Header
    private fun createHeader(){
        header = AccountHeaderBuilder()
            .withActivity(mainActivity)
            .withHeaderBackground(R.drawable.header) // Передаем Layout для Header
            .addProfiles(
                ProfileDrawerItem()
                    .withName("Абдулло Содиков") // Поле для имени владелца
                    .withEmail("+992918865861") //
            ).build()
    }
    // Функция для создания выдвежного меню (Drawer)
    private fun createDrawer (){
        DrawerBuilder()
            .withActivity(mainActivity)   // передаем активити
            .withToolbar(toolbar) // передает ToolBar
            .withActionBarDrawerToggle(true) // ?
            .withSelectedItem(-1) //  окно по умолчанию
            .withAccountHeader(header) // передаем Header
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(100)
                    .withIconTintingEnabled(true)
                    .withName("Создать группу")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_create_groups),
                PrimaryDrawerItem().withIdentifier(101)
                    .withIconTintingEnabled(true)
                    .withName("Создать секретный чат")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_secret_chat),
                PrimaryDrawerItem().withIdentifier(102)
                    .withIconTintingEnabled(true)
                    .withName("Создать канал")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_create_channel),
                PrimaryDrawerItem().withIdentifier(103)
                    .withIconTintingEnabled(true)
                    .withName("Контакты")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_create_channel),
                PrimaryDrawerItem().withIdentifier(104)
                    .withIconTintingEnabled(true)
                    .withName("Звонки")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_phone),
                PrimaryDrawerItem().withIdentifier(105)
                    .withIconTintingEnabled(true)
                    .withName("Избранное")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_favorites),
                PrimaryDrawerItem().withIdentifier(106)
                    .withIconTintingEnabled(true)
                    .withName("Настройки")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_settings),
                DividerDrawerItem (),
                PrimaryDrawerItem().withIdentifier(107)
                    .withIconTintingEnabled(true)
                    .withName("Пригласить друзей")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_invate),
                PrimaryDrawerItem().withIdentifier(108)
                    .withIconTintingEnabled(true)
                    .withName("Возможности Telegram")
                    .withSelectable(false)
                    .withIcon(R.drawable.ic_menu_help)
            ).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    //Toast.makeText(this@MainActivity,position.toString(),Toast.LENGTH_SHORT).show()
                    when(position){
                        7 ->  mainActivity.replaceFragment(SettingsFragment())
                    }
                    return false
                }
            }
            ).build().also { drawer = it }
    }
}


