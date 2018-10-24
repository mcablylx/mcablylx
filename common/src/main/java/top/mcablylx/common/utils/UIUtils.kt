package top.mcablylx.common.utils

import android.os.Handler
import top.mcablylx.common.AppContext

/**
 * If there is no bug, Created by Mcablylx on 2018-10-19.
 * otherwise, I do not know who create it either
 * If anyone finds out I have bug, I can only kill him quietly
 */
fun isRunInMainThread(): Boolean {
    return android.os.Process.myTid() == getMainThreadId()
}

fun getMainThreadId(): Int {
    return AppContext.mainThreadId
}

fun <T> runInMainThread(block: () -> T) {
    if (isRunInMainThread()) {
        block()
    } else {
        post(block)
    }
}

fun <T> post(block: () -> T) {
    getMainHandler().post { block() }
}

fun getMainHandler(): Handler {
    return Handler(AppContext.mainLooper)
}
