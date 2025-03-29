package com.gonzapolleria.promosapp.shared.helpers
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth

actual fun getFirebaseAuth():FirebaseAuth {
    return Firebase.auth
}