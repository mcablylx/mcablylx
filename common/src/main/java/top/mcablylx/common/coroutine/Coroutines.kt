package top.mcablylx.common.coroutine

import kotlin.coroutines.experimental.*

/**
 * If there is no bug, Created by Mcablylx on 2018-10-23.
 * otherwise, I do not know who create it either
 * If anyone finds out I have bug, I can only kill him quietly
 */
fun startCoroutine(context: CoroutineContext = EmptyCoroutineContext, block: suspend () -> Unit) {
    block.startCoroutine(ContextContinuation(context + AsyncCoroutineContext()))
}

/**
 * 开始可挂起方法
 */
suspend fun <T> runSuspend(block: CoroutineContext.() -> T) = suspendCoroutine<T> {
    AsyncTask {
        try {
            it.resume(block(it.context))
        } catch (e: Exception) {
            it.resumeWithException(e)
        }
    }.execute()
}