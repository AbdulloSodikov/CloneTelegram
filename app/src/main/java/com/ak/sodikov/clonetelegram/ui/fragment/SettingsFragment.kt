package com.ak.sodikov.clonetelegram.ui.fragment

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.ak.sodikov.clonetelegram.MainActivity
import com.ak.sodikov.clonetelegram.R
import com.ak.sodikov.clonetelegram.activities.RegisterActivity
import com.ak.sodikov.clonetelegram.databinding.FragmentSettingsBinding
import com.ak.sodikov.clonetelegram.utilits.AUTH
import com.ak.sodikov.clonetelegram.utilits.replaceActivity
import com.ak.sodikov.clonetelegram.utilits.replaceFragment


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_menu_exit -> {
                AUTH.signOut()
               (activity as MainActivity).replaceActivity(RegisterActivity())
            }
        }
      return super.onOptionsItemSelected(item)
    }
}
