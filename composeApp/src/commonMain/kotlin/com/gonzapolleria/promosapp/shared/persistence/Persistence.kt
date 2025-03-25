package com.gonzapolleria.promosapp.shared.persistence

expect class SharedPreferencesHelper() {
    fun getString(key: String): String?
    fun putString(key: String, value: String)
    fun remove(key: String)
    fun clear()
}