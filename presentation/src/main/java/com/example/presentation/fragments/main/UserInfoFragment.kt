package com.example.presentation.fragments.main

import android.os.Bundle
import com.example.presentation.R
import com.example.presentation.activity.main.MainNavigation
import com.example.presentation.fragments.base.BaseFragment

class UserInfoFragment: BaseFragment<MainNavigation>(R.layout.fragment_user_info) {

    override fun titleRes(): Int = R.string.user_info_title

    override fun initViews(savedInstanceState: Bundle?) {
    }
}