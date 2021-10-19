package com.ak.sodikov.clonetelegram.ui.fragment


import com.ak.sodikov.clonetelegram.MainActivity
import com.ak.sodikov.clonetelegram.R
import com.ak.sodikov.clonetelegram.activities.RegisterActivity
import com.ak.sodikov.clonetelegram.utilits.AUTH
import com.ak.sodikov.clonetelegram.utilits.AppTextWatcher
import com.ak.sodikov.clonetelegram.utilits.replaceActivity
import com.ak.sodikov.clonetelegram.utilits.showToast
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_code.*

class EnterCodeFragment(val phoneNumber: String, val id: String) : BaseFragment (R.layout.fragment_enter_code) {


    override fun onStart() {
        super.onStart()
        (activity as RegisterActivity).title = phoneNumber
        register_text_input_code.addTextChangedListener(AppTextWatcher {
            val string = register_text_input_code.text.toString()
            if (string.length == 6) {
                enterCode()
            }
        })
    }

    private fun enterCode() {
        val code = register_text_input_code.text.toString()
        val credential = PhoneAuthProvider.getCredential(id, code)

        AUTH.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                showToast("Добро пожаловать")
                (activity as RegisterActivity).replaceActivity(MainActivity())
            } else {
                showToast(it.exception?.message.toString())
            }
        }
    }
}
