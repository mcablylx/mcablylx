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
/**
 * pref名字  默认值config
 */
lateinit var mPrefName: String
/**
 * 主线程id
 */
private var mainThreadID: Int = -1

/**
 * 初始化操作
 * 在Application的onCreate()方法中执行
 * 切记一定要在主线程中执行 否则拿不到主线程ID, 部分方法无法正常运行
 */
fun initialization(context: Context) {
    initialization(context, "config")
}

/**
 * 初始化操作
 * 出事pref的名字和主线程id
 */
fun initialization(context: Context, prefName: String) {
    mContext = context.applicationContext
    mPrefName = prefName
    mainThreadID = android.os.Process.myTid()
}

/**
 * 包装上下文
 */
object AppContext : ContextWrapper(mContext){
    val mainThreadId = mainThreadID
}
