package omstu.com.osh.ui.main.training

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import omstu.com.osh.R
import omstu.com.osh.ui.Screens
import omstu.com.osh.ui.common.BaseActivityMvp
import omstu.com.osh.ui.main.training.regulations.RegulationsFragment
import omstu.com.osh.ui.main.training.regulations.pdf.PdfFragment
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

class TrainingActivity : BaseActivityMvp(), TrainingView {

    override val layoutRes = R.layout.training_activity

    @Inject
    @InjectPresenter
    lateinit var presenter: TrainingPresenter

    @ProvidePresenter
    fun providePresenter() = presenter


    override val navigator: Navigator = object : SupportAppNavigator(this, R.id.training_container) {

        override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? = null

        override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
            Screens.REGULATIONS_SCREEN -> RegulationsFragment()
            Screens.PDF_SCREEN -> PdfFragment.gewInstance(data as String)
            else -> null
        }

        override fun setupFragmentTransactionAnimation(
            command: Command,
            currentFragment: Fragment?,
            nextFragment: Fragment?,
            fragmentTransaction: FragmentTransaction
        ) {
            fragmentTransaction.setCustomAnimations(
                R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
        }
    }
}
