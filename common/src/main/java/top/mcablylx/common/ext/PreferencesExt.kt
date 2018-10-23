package top.mcablylx.common.ext

import android.content.Context
import top.mcablylx.common.AppContext
import top.mcablylx.common.mPrefName
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * If there is no bug, Created by Mcablylx on 2018-10-19.
 * otherwise, I do not know who create it either
 * If anyone finds out I have bug, I can only kill him quietly
 *
 * 代理
 */
class Preference<T>(val name: String, val default: T) : ReadWriteProperty<Any?, T> {

    val prefs by lazy {
        AppContext.getSharedPreferences(mPrefName, Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreference(findProperName(property))
    }

    private fun findPreference(key: String): T {
        return when (default) {
            is Long -> prefs.getLong(key, default)
            is Int -> prefs.getInt(key, default)
            is Boolean -> prefs.getBoolean(key, default)
            is String -> prefs.getString(key, default)
            else -> throw IllegalAccessException("Unsupported type.")
        } as T
    }

    private fun findProperName(property: KProperty<*>) = if (name.isEmpty()) property.name else name

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(findProperName(property), value)
    }

    private fun putPreference(key: String, value: T) {
        with(prefs.edit()) {
            when (value) {
                is Long -> putLong(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is String -> putString(key, value)
                else -> throw IllegalArgumentException("Unsupported type.")
            }
        }.apply()
    }
}

inline fun <reified R, T> R.pref(default: T) = Preference("", default)