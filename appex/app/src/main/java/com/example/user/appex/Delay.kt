package com.example.user.appex
import android.os.Handler

class Delay {
    companion object {
        fun after(delay: Long, process: () -> Unit) {
            Handler().postDelayed({
                process()
            }, delay)
        }
    }
}