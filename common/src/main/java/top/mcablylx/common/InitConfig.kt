package top.mcablylx.common

import android.annotation.SuppressLint
import android.content.Context
import android.content.ContextWrapper
import android.widget.Toast

/**
 * If there is no bug, Created by Mcablylx on 2018-10-19.
 * otherwise, I do not know who create it either
 * If anyone finds out I have bug, I can only kill him quietly
 */

@SuppressLint("StaticFieldLeak")
private lateinit var mContext: Context

fun initialization(context: Context){
    mContext = context.applicationContext
}

object AppContext:ContextWrapper(mContext)