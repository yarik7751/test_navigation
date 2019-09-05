package com.example.presentation.fragments.base

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.presentation.R
import com.example.presentation.activity.base.BaseActivity
import com.example.presentation.activity.base.BaseNavigation

abstract class BaseFragment<N: BaseNavigation>(@LayoutRes res: Int): Fragment(res) {

    companion object {
        const val LOG_LIFE_CYCLE = "life_cycle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_LIFE_CYCLE, "onCreate: " + this::class.java.simpleName)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        (activity as BaseActivity).setSupportActionBar(toolbar)
        toolbar?.setNavigationOnClickListener {
            backPressed()
        }
        initToolbar()
        initViews(savedInstanceState)
    }

    private fun initToolbar() {
        (activity as BaseActivity).supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setTitle(titleRes())
        }
    }

    @StringRes
    abstract fun titleRes(): Int

    abstract fun initViews(savedInstanceState: Bundle?)

    protected fun getNavigation(): N? = activity as N

    private fun backPressed() {
        activity?.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_LIFE_CYCLE, "onDestroy: " + this::class.java.simpleName)
    }
}