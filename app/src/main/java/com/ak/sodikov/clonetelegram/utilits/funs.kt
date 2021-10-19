package com.ak.sodikov.clonetelegram.utilits

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ak.sodikov.clonetelegram.R

fun Fragment.shawToast(message : String) {
    Toast.makeText(this.context,message,Toast.LENGTH_SHORT).show()
}
fun AppCompatActivity.replaceActivity(activity: AppCompatActivity) {
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
    this.finish()
}

fun AppCompatActivity.replaceFragment (fragment: Fragment) {
    supportFragmentManager.beginTransaction()  // Запуск ChatsFragment
        .addToBackStack(null)
        .replace(R.id.dataContainer, fragment)
        .commit()
}

fun Fragment.replaceFragment (fragment: Fragment) {
       parentFragmentManager.beginTransaction()
        .replace(R.id.dataContainer, fragment)
        .addToBackStack(null)
        .commit()
}
