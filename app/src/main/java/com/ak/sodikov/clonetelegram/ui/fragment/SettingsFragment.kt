package com.ak.sodikov.clonetelegram.ui.fragment

import android.view.Menu
import android.view.MenuInflater
import com.ak.sodikov.clonetelegram.R
import com.ak.sodikov.clonetelegram.databinding.FragmentSettingsBinding


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {
    private lateinit var mBinding: FragmentSettingsBinding


    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
       activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }
 }