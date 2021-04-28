package com.example.algorithm

import android.app.Application
import android.content.Context
import android.os.*
import android.os.Process.killProcess
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   4/21/21 12:11 AM
 */
//定义CrashHandler
class CrashHandler private constructor() : Thread.UncaughtExceptionHandler {
    private var context: Context? = null
    fun init(context: Context?) {
        this.context = context
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    override fun uncaughtException(t: Thread, e: Throwable) {
        Log.e("CrashHandler", "uncaughtException $t $e")
//        Process.killProcess(Process.myPid())
//        exitProcess(10)
        throw e
        Process.killProcess(Process.myPid())

        System.exit(10)
    }

    companion object {
        val instance: CrashHandler by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            CrashHandler()
        }
    }
}

//Application中初始化
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        CrashHandler.instance.init(this)
        Handler(Looper.getMainLooper()).post {
            Log.e("MyApplication", "onCreate loop start")
            while (true) {
                try {
                    Log.e("MyApplication", "onCreate loop")
                    Looper.loop()
                } catch (e: Throwable) {
                    Log.e("MyApplication", "onCreate while  $e")
                }
            }
        }

    }
}

//Activity中触发异常
class ExceptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exception)

        findViewById<Button>(R.id.btn).setOnClickListener {
            throw RuntimeException("主线程异常")
        }
        findViewById<Button>(R.id.btn2).setOnClickListener {
            thread {
                throw RuntimeException("子线程异常")
            }
        }
        Class.forName("android.app.ActivityThread")
            .getDeclaredField("sCurrentActivityThread").let { field ->
                field.isAccessible = true
                val activityThread = field.get(null)

                Log.e("ExceptionActivity", "onCreate $activityThread")
                activityThread::class.java.getDeclaredField("mH")
                    .also {
                        it.isAccessible = true
                    }
                    .get(activityThread)
                    .let { handler ->
                        Handler::class.java.getDeclaredField("mCallback")
                            .also { it.isAccessible = true }

                            .set(handler, object : Handler.Callback {
                                override fun handleMessage(msg: Message): Boolean {
                                    Log.e("ExceptionActivity","handleMessage $msg")

                                    when (msg.what) {
//                                        activity
                                        107 -> {
                                            runCatching {
                                                (handler as? Handler)?.sendMessage(msg)
                                            }.onFailure {
                                                Log.e("ExceptionActivity","handleMessage $it")
                                            }
                                        }
                                    }
                                    return true

                                }

                            })
                    }

            }

    }

    override fun onResume() {
        super.onResume()

    }

    fun clickBtn3(view: View) {
        Log.e("ExceptionActivity", "clickBtn3 $view")

    }
}
