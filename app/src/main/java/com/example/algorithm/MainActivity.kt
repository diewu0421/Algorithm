package com.example.algorithm

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.WindowManager
import java.security.NoSuchAlgorithmException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).post {
            Log.e("MainActivity","onCreate1 ")
            while (true) {
                Log.e("MainActivity","onCreate 2")
                //主线程异常拦截
                try {
                    Looper.loop()
                } catch (e: Throwable) {
                    Log.e("MainActivity","onCreate $e")
                }
            }
        }
        val service = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val token = window::class.java.superclass.getDeclaredField("mAppToken").also { it.isAccessible = true }.get(window)

//        Dialog(applicationContext).let {dialog ->
//            dialog.window?.windowManager!!::class.java.declaredMethods[6].apply {
//                invoke(dialog.window?.windowManager, token)
//            }
//            dialog.show()
//        }
    }

    override fun onResume() {
        super.onResume()
        1/ 0
    }

    fun clickBtn3(view: View) {}
}