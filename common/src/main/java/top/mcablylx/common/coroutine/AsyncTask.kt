package top.mcablylx.common.coroutine

import java.util.concurrent.Executors

/**
 * If there is no bug, Created by Mcablylx on 2018-10-23.
 * otherwise, I do not know who create it either
 * If anyone finds out I have bug, I can only kill him quietly
 */

private val pool by lazy {
    Executors.newCachedThreadPool()
}

class AsyncTask(private val block: () -> Unit) {
    fun execute() = pool.execute(block)
}