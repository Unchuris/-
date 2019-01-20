package omstu.com.osh.ui.main.quiz

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import omstu.com.osh.R
import omstu.com.osh.data.entities.ResultTest
import omstu.com.osh.ui.Screens
import omstu.com.osh.ui.common.BaseActivityMvp
import omstu.com.osh.ui.main.quiz.question.QuestionFragment
import omstu.com.osh.ui.main.quiz.result.ResultFragment
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.SupportAppNavigator
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject

class QuizActivity : BaseActivityMvp(), QuizView {

    override val layoutRes = R.layout.quiz_activity

    @Inject
    @InjectPresenter
    lateinit var presenter: QuizPresenter

    @ProvidePresenter
    fun providePresenter() = presenter


    override val navigator: Navigator = object : SupportAppNavigator(this, R.id.quiz_container) {

        override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? = null

        override fun createFragment(screenKey: String?, data: Any?): Fragment? = when (screenKey) {
            Screens.QUESTION_SCREEN -> QuestionFragment()
            Screens.RESULT_SCREEN -> ResultFragment.gewInstance(data as ResultTest)
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
