package top.mcablylx.common.permission.annotation


/**
 * If there is no bug, Created by Mcablylx on 2018-10-31.
 * otherwise, I do not know who create it either
 * If anyone finds out I have bug, I can only kill him quietly
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Permission(val value: Int = 0)