package omstu.com.osh.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.toolbar.*
import omstu.com.osh.R
import omstu.com.osh.ui.Screens
import omstu.com.osh.ui.common.BaseActivityMvp
import omstu.com.osh.ui.main.quiz.QuizActivity
import omstu.com.osh.ui.main.training.TrainingActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.SupportAppNavigator
import javax.inject.Inject

class MainActivity : BaseActivityMvp(), MainView {

    override val layoutRes = R.layout.main_activity

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar()
        training.setOnClickListener { presenter.trainingOnClick() }
        quiz.setOnClickListener { presenter.quizOnClick() }
    }

    override val navigator: Navigator = object : SupportAppNavigator(this, 0) {

        override fun createActivityIntent(context: Context?, screenKey: String?, data: Any?): Intent? = when (screenKey) {
            Screens.TRAINING_SCREEN -> Intent(this@MainActivity, TrainingActivity::class.java)
            Screens.QUIZ_SCREEN -> Intent(this@MainActivity, QuizActivity::class.java)
            else -> null
        }

        override fun createFragment(screenKey: String?, data: Any?): Fragment? = null
    }

    private fun initToolbar() {
        this.setSupportActionBar(toolbar)
        this.supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.title = "Охрана труда"
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.text_color_white))
    }
}
