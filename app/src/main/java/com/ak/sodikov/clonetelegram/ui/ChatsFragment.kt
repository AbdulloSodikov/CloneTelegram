package com.ak.sodikov.clonetelegram.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ak.sodikov.clonetelegram.R
import com.ak.sodikov.clonetelegram.databinding.FragmentChatBinding


class ChatsFragment : Fragment() {
private lateinit var mBinding : FragmentChatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentChatBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onResume() {
        super.onResume()

    }
  }