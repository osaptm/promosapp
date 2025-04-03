package com.gonzapolleria.promosapp.features.onboarding


import com.gonzapolleria.promosapp.core.persistence.SharedPreferencesHelper

fun String?.toBoolean(): Boolean {
    return this?.toBooleanStrictOrNull() ?: false
}

class OnboardingUtils() {
    companion object {

        private fun excistOnboarding(prefs : SharedPreferencesHelper): Unit {
            if(prefs.getString("onboardingCompleted") == null) {
                prefs.putString("onboardingCompleted", "false")
            }
        }

        fun isOnboardingCompleted(): Boolean {
            val prefs = SharedPreferencesHelper()
            excistOnboarding(prefs)
            val onboardingCompleted = prefs.getString("onboardingCompleted").toBoolean()
            return onboardingCompleted
        }

        fun setOnboardingCompleted() {
            val prefs = SharedPreferencesHelper()
            excistOnboarding(prefs)
            prefs.putString("onboardingCompleted", "true")
        }

        fun setOnboardingNotCompleted() {
            val prefs = SharedPreferencesHelper()
            excistOnboarding(prefs)
            prefs.putString("onboardingCompleted", "false")
        }

    }

}