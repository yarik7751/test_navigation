package by.yarik.test_navigation.fragments.main

import android.os.Bundle
import by.yarik.test_navigation.R
import by.yarik.test_navigation.activity.main.MainNavigation
import by.yarik.test_navigation.fragments.base.BaseFragment

class UserInfoFragment: BaseFragment<MainNavigation>() {

    override fun layoutRes(): Int = R.layout.fragment_user_info

    override fun titleRes(): Int = R.string.user_info_title

    override fun initViews(savedInstanceState: Bundle?) {
    }
}