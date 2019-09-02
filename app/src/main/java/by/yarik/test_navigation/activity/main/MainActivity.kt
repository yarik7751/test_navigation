package by.yarik.test_navigation.activity.main

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import by.yarik.test_navigation.R
import by.yarik.test_navigation.activity.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainNavigation {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.navHostFragment)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

    override fun userInfoNext() {
        navController.navigate(R.id.action_userInfoFragment_to_currenciesFragment)
    }

    override fun userInfoBack() {
        showFinishDialog()
    }

    private fun showFinishDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle(R.string.finish_dialog_title)
        dialogBuilder.setMessage(R.string.finish_dialog_message)
        dialogBuilder.setNegativeButton(R.string.cancel, object: DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, p1: Int) {
                dialog?.dismiss()
            }
        })
        dialogBuilder.setPositiveButton(R.string.ok, object: DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, p1: Int) {
                finish()
            }
        })

        dialogBuilder.create().show()
    }

    override fun settingsNext() {
        navController.navigate(R.id.action_settingsFragment_to_weatherActivity)
    }

    override fun settingsHome() {
        navController.popBackStack(R.id.userInfoFragment, false)
    }

    override fun settingsBack() {
        navController.popBackStack()
    }

    override fun currenciesNext() {
        navController.navigate(R.id.action_currenciesFragment_to_settingsFragment)
    }

    override fun currenciesHome() {
        navController.popBackStack(R.id.userInfoFragment, false)
    }

    override fun currenciesBack() {
        navController.popBackStack()
    }
}
