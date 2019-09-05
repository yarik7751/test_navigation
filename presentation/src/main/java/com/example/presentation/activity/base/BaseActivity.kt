package com.example.presentation.activity.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    companion object {
        const val LIFE_CYCLE_ACTIVITY = "life_cycle_activity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LIFE_CYCLE_ACTIVITY, "onCreate: " + this::class.java.simpleName)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFE_CYCLE_ACTIVITY, "onDestroy: " + this::class.java.simpleName)
    }
}