package omstu.com.osh.ui.common

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import com.arellomobile.mvp.MvpAppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import omstu.com.osh.R
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import javax.inject.Inject

abstract class BaseActivityMvp : MvpAppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    protected abstract val layoutRes: Int
    protected abstract val navigator: Navigator

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }
}
