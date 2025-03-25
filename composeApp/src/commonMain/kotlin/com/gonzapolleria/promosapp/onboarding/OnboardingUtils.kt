package com.gonzapolleria.promosapp.onboarding


import com.gonzapolleria.promosapp.shared.persistence.SharedPreferencesHelper

fun String?.toBoolean(): Boolean {
    return this?.toBooleanStrictOrNull() ?: false
}

class OnboardingUtils() {
    companion object {

        private fun excistOnboarding(prefs : SharedPreferencesHelper ): Unit {
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

    }

}