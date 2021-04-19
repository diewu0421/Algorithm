package com.example.algorithm

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val token = window::class.java.superclass.getDeclaredField("mAppToken").also { it.isAccessible = true }.get(window)

        Dialog(applicationContext).let {dialog ->
//            dialog.window?.windowManager!!::class.java.declaredMethods[6].apply {
//                invoke(dialog.window?.windowManager, token)
//            }
            dialog.show()
        }
    }
}