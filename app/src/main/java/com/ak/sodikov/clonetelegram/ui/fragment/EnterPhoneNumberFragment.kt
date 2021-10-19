package com.ak.sodikov.clonetelegram.ui.fragment


import com.ak.sodikov.clonetelegram.R
import com.ak.sodikov.clonetelegram.utilits.replaceFragment
import com.ak.sodikov.clonetelegram.utilits.shawToast
import kotlinx.android.synthetic.main.fragment_enter_phone_number.*

class EnterPhoneNumberFragment : BaseFragment (R.layout.fragment_enter_phone_number) {

 override fun onStart() {
  super.onStart()
    register_btn_next.setOnClickListener { sendCode()

    }
    }

    private fun sendCode() {
        if(register_text_phone_number.text.toString().isEmpty()) {
            shawToast(getString(R.string.register_toast_enter_phone))
        } else {
        replaceFragment(EnterCodeFragment())
        }
    }
}