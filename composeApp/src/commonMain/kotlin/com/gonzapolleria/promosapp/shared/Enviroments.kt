package com.gonzapolleria.promosapp.shared

sealed class Enviroments {
    object serverClientId : Enviroments() {
        fun getValue(): String = "696985231159-2diso3rj955iuifd5v8bi7k207vn60ff.apps.googleusercontent.com"
    }
}