package com.example.presentation.activity.main

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.common.BaseApp
import com.example.presentation.R
import com.example.presentation.activity.base.BaseActivity
import com.example.presentation.di.component.PresentationComponent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),
    MainNavigation {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        PresentationComponent.init((applicationContext as BaseApp).getAppProvider())
            ?.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.navHostFragment)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

    private fun showFinishDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle(R.string.finish_dialog_title)
        dialogBuilder.setMessage(R.string.finish_dialog_message)
        dialogBuilder.setNegativeButton(R.string.cancel) { dialog, p1 ->
            dialog?.dismiss()
        }
        dialogBuilder.setPositiveButton(R.string.ok) { dialog, p1 ->
            finish()
        }

        dialogBuilder.create().show()
    }

    override fun openWeatherScreen() {
        navController.navigate(R.id.weatherActivity)
    }
}
