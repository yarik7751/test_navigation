package by.yarik.test_navigation.fragments.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
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
        initViews(savedInstanceState)
    }

    @LayoutRes
    abstract fun layoutRes(): Int

    abstract fun initViews(savedInstanceState: Bundle?)

    protected fun getNavigation(): N? = activity as N

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_LIFE_CYCLE, "onDestroy: " + this::class.java.simpleName)
    }
}