package com.example.algorithm

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   4/22/21 11:49 AM
 */
class MyView @JvmOverloads constructor(context: Context, attrSets: AttributeSet? = null, defStyleAttrs: Int = 0)
    : View(context, attrSets, defStyleAttrs) {


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.e("MyView","onAttachedToWindow ")
    }
}