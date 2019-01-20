package omstu.com.osh.ui.main.quiz.result

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.result_fragment.*
import kotlinx.android.synthetic.main.toolbar.*
import omstu.com.osh.R
import omstu.com.osh.data.entities.ResultTest
import omstu.com.osh.ui.common.BaseFragment
import javax.inject.Inject

class ResultFragment : BaseFragment(), ResultView {

    override val layoutRes = R.layout.result_fragment

    @Inject
    @InjectPresenter
    lateinit var presenter: ResultPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    companion object {
        const val CURRENT = "current"
        const val WRONG = "wrong"

        fun gewInstance(key: ResultTest) = ResultFragment().apply {
            arguments = Bundle().apply {
                putInt(CURRENT, key.current)
                putInt(WRONG, key.wrong)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(toolbar, titleText = "Результат") { presenter.back() }
        arguments?.getInt(CURRENT)?.let {
            val text = "На $it вы ответили правильно"
            currentCount.text = text
        }
        arguments?.getInt(WRONG)?.let {
            val text = "В $it вы ошиблись"
            wrongCount.text = text
        }
        startQuiz.setOnClickListener { presenter.again() }
    }
}
