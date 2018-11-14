package top.mcablylx.common.coroutine

import top.mcablylx.common.utils.runInMainThread
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext

/**
 * If there is no bug, Created by Mcablylx on 2018-10-23.
 * otherwise, I do not know who create it either
 * If anyone finds out I have bug, I can only kill him quietly
 *
 * 主线程 Continuation 包装类
 */
class MainThreadContinuationWrapper<T>(private val continuation: Continuation<T>) : Continuation<T> {

    override val context: CoroutineContext = continuation.context

    override fun resume(value: T) {
        runInMainThread { continuation.resume(value) }
    }

    override fun resumeWithException(exception: Throwable) {
        runInMainThread { continuation.resumeWithException(exception) }
    }

}