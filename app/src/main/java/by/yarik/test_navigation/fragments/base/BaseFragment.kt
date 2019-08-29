package by.yarik.test_navigation.fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import by.yarik.test_navigation.fragments.activity.MainNavigation

abstract class BaseFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(savedInstanceState)
    }

    abstract fun initViews(savedInstanceState: Bundle?)

    @LayoutRes
    abstract fun layoutRes(): Int

    protected fun getMainNavigation(): MainNavigation? = activity as MainNavigation
}