package com.ak.sodikov.clonetelegram.ui.fragment


import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.ak.sodikov.clonetelegram.R
import com.ak.sodikov.clonetelegram.utilits.AppTextWatcher
import com.ak.sodikov.clonetelegram.utilits.shawToast
import kotlinx.android.synthetic.main.fragment_enter_code.*

class EnterCodeFragment : BaseFragment (R.layout.fragment_enter_code) {

    override fun onStart() {
        super.onStart()
        register_text_input_code.addTextChangedListener(AppTextWatcher {
            val string = register_text_input_code.text.toString()
            if (string.length == 6) {
                verifiCode()
            }
        })
    }

    private fun  verifiCode (){
        shawToast("OK")
    }
}