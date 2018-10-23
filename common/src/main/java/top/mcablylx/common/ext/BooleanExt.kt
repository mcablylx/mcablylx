package top.mcablylx.common.ext

/**
 * If there is no bug, Created by Mcablylx on 2018-10-23.
 * otherwise, I do not know who create it either
 * If anyone finds out I have bug, I can only kill him quietly
 */
sealed class BooleanExt<out T>

object Otherwise : BooleanExt<Nothing>()
class WithData<T>(val data: T) : BooleanExt<T>()

inline fun <T> Boolean.yes(block: () -> T) =
        when {
            this -> {
                WithData(block())
            }
            else -> {
                Otherwise
            }
        }


inline fun <T> Boolean.no(block: () -> T) =
        when {
            this -> Otherwise
            else -> {
                WithData(block())
            }
        }

inline fun <T> BooleanExt<T>.otherwise(block: () -> T) =
        when (this) {
            is Otherwise -> block()
            is WithData -> data
        }