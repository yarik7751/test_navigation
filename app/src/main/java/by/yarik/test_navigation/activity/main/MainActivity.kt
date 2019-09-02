package by.yarik.test_navigation.activity.main

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import by.yarik.test_navigation.R

class MainActivity : AppCompatActivity(), MainNavigation {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.navHostFragment)
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
        navController.navigate(R.id.action_settingsFragment_to_userInfoFragment)
    }

    override fun settingsBack() {
        navController.popBackStack()
    }

    override fun currenciesNext() {
        navController.navigate(R.id.action_currenciesFragment_to_settingsFragment)
    }

    override fun currenciesHome() {
        navController.navigate(R.id.action_currenciesFragment_to_userInfoFragment)
    }

    override fun currenciesBack() {
        navController.popBackStack()
    }
}
