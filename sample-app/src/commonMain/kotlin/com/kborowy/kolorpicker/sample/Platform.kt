package com.kborowy.kolorpicker.sample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform