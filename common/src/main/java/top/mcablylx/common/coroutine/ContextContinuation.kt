package top.mcablylx.common.coroutine

import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext

/**
 * If there is no bug, Created by Mcablylx on 2018-10-23.
 * otherwise, I do not know who create it either
 * If anyone finds out I have bug, I can only kill him quietly
 */
class ContextContinuation(override val context: CoroutineContext) : Continuation<Unit> {
    override fun resume(value: Unit) {

    }

    override fun resumeWithException(exception: Throwable) {

    }
}