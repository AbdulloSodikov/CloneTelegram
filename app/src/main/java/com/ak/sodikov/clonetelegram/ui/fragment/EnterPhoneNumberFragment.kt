package com.ak.sodikov.clonetelegram.ui.fragment


import com.ak.sodikov.clonetelegram.MainActivity
import com.ak.sodikov.clonetelegram.R
import com.ak.sodikov.clonetelegram.activities.RegisterActivity
import com.ak.sodikov.clonetelegram.utilits.AUTH
import com.ak.sodikov.clonetelegram.utilits.replaceActivity
import com.ak.sodikov.clonetelegram.utilits.replaceFragment
import com.ak.sodikov.clonetelegram.utilits.showToast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_enter_phone_number.*
import java.util.concurrent.TimeUnit

class EnterPhoneNumberFragment : BaseFragment (R.layout.fragment_enter_phone_number) {
private lateinit var mPhoneNumber : String
private lateinit var mCallback :  PhoneAuthProvider.OnVerificationStateChangedCallbacks


 override fun onStart() {
  super.onStart()
       mCallback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
         override fun onVerificationCompleted(credential: PhoneAuthCredential) {
             AUTH.signInWithCredential(credential).addOnCompleteListener{
                 if(it.isSuccessful){
                     showToast("Добро пожаловать")
                     (activity as RegisterActivity).replaceActivity(MainActivity())
                 } else {
                     showToast(it.exception?.message.toString())
                 }
             }
         }
         override fun onVerificationFailed(p0: FirebaseException) {
                showToast(p0.message.toString())
         }

         override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
            replaceFragment(EnterCodeFragment(mPhoneNumber,id))
         }
     }
    register_btn_next.setOnClickListener { sendCode()

        }
    }

    private fun sendCode() {
        if(register_text_phone_number.text.toString().isEmpty()) {
            showToast(getString(R.string.register_toast_enter_phone))
        } else {
            authUser ()
         }
    }

    private fun authUser() {
        mPhoneNumber = register_text_phone_number.text.toString()
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            mPhoneNumber,
            60,
            TimeUnit.SECONDS,
            activity as RegisterActivity,
            mCallback
        )
    }
}