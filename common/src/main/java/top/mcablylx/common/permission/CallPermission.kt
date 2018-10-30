package top.mcablylx.common.permission

import android.app.Activity
import top.mcablylx.common.permission.request.Request
import top.mcablylx.common.permission.request.impl.DefaultRequest

/**
 * If there is no bug, Created by Mcablylx on 2018-10-29.
 * otherwise, I do not know who create it either
 * If anyone finds out I have bug, I can only kill him quietly
 */
object CallPermission{

    fun with(activity:Activity):Request{

        return DefaultRequest()
    }
}
