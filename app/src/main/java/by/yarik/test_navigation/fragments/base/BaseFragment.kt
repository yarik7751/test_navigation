package by.yarik.test_navigation.fragments.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import by.yarik.test_navigation.R
import by.yarik.test_navigation.activity.base.BaseActivity
import by.yarik.test_navigation.activity.base.BaseNavigation

abstract class BaseFragment<N: BaseNavigation>: Fragment() {

    companion object {
        const val LOG_LIFE_CYCLE = "life_cycle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_LIFE_CYCLE, "onCreate: " + this::class.java.simpleName)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes(), container, false)
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

    @LayoutRes
    abstract fun layoutRes(): Int

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