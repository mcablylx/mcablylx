package top.mcablylx.common

import android.annotation.SuppressLint
import android.content.Context
import android.content.ContextWrapper

/**
 * If there is no bug, Created by Mcablylx on 2018-10-19.
 * otherwise, I do not know who create it either
 * If anyone finds out I have bug, I can only kill him quietly
 */

@SuppressLint("StaticFieldLeak")
private lateinit var mContext: Context
lateinit var mPrefName: String


fun initialization(context: Context) {
    initialization(context, "config")
}

fun initialization(context: Context, prefName: String) {
    mContext = context.applicationContext
    mPrefName = prefName
}

object AppContext : ContextWrapper(mContext)