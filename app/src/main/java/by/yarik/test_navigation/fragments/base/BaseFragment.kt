package by.yarik.test_navigation.fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import by.yarik.test_navigation.activity.base.BaseNavigation

abstract class BaseFragment<N: BaseNavigation>: Fragment() {

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
}