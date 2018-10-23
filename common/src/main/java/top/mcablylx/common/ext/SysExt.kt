package top.mcablylx.common.ext

import android.widget.Toast
import top.mcablylx.common.AppContext
import top.mcablylx.common.utils.runInMainThread

/**
 * If there is no bug, Created by Mcablylx on 2018-10-19.
 * otherwise, I do not know who create it either
 * If anyone finds out I have bug, I can only kill him quietly
 */
fun <R> R.show(msg: String) {
    runInMainThread {
        Toast.makeText(AppContext, msg, Toast.LENGTH_LONG).show()
    }
}
