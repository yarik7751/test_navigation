package by.yarik.test_navigation.fragments.activity

import android.os.Bundle
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
    }

    override fun settingsNext() {
    }

    override fun settingsBack() {
        navController.popBackStack()
    }

    override fun currenciesNext() {
        navController.navigate(R.id.settingsFragment)
    }

    override fun currenciesBack() {
        navController.popBackStack()
    }
}
