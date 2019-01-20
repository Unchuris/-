package omstu.com.osh.ui.common

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.toolbar.*
import omstu.com.osh.R
import javax.inject.Inject

abstract class BaseFragment : MvpAppCompatFragment(), HasSupportFragmentInjector {

    protected abstract val layoutRes: Int

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(layoutRes, container, false)

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return childFragmentInjector
    }

    protected fun initToolbar(
        toolbar: Toolbar,
        resNavigationIcon: Int = R.drawable.ic_arrow_white,
        titleText: String = "",
        navigationOnClickListener: () -> Unit
    ) {
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.setDisplayShowTitleEnabled(false)
        with(toolbar) {
            title = titleText
            setNavigationIcon(resNavigationIcon)
            setTitleTextColor(ContextCompat.getColor(context, R.color.text_color_white))
            setNavigationOnClickListener { navigationOnClickListener.invoke() }
        }
    }
}
