package com.gonzapolleria.promosapp.core.persistence

import platform.Foundation.NSUserDefaults

actual class SharedPreferencesHelper {
    private val userDefaults: NSUserDefaults = NSUserDefaults.standardUserDefaults

    actual fun getString(key: String): String? {
        return userDefaults.stringForKey(key)
    }

    actual fun putString(key: String, value: String) {
        userDefaults.setObject(value, forKey = key)
    }

    actual fun remove(key: String) {
        userDefaults.removeObjectForKey(key)
    }

    actual fun clear() {
        userDefaults.dictionaryRepresentation().keys.forEach {
            userDefaults.removeObjectForKey(it.toString())
        }
    }
}