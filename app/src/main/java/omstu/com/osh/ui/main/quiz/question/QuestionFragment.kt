package omstu.com.osh.ui.main.quiz.question

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.question.*
import kotlinx.android.synthetic.main.toolbar.*
import omstu.com.osh.R
import omstu.com.osh.data.entities.Question
import omstu.com.osh.extensions.hide
import omstu.com.osh.extensions.show
import omstu.com.osh.ui.common.BaseFragment
import javax.inject.Inject

class QuestionFragment : BaseFragment(), QuestionView {

    @Inject
    @InjectPresenter
    lateinit var presenter: QuestionPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override val layoutRes = R.layout.question

    private val colorBackground = Color.WHITE

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(toolbar, titleText = "Проверка знаний") { presenter.back() }
    }

    override fun showQuestion(question: Question) {
        cleanBackground()
        hideViews()
        questionTitle.text = question.question
        if (question.option1.isNotBlank()) option1.show()
        if (question.option2.isNotBlank()) option2.show()
        if (question.option3.isNotBlank()) option3.show()
        if (question.option4.isNotBlank()) option4.show()
        option1.text = question.option1
        option2.text = question.option2
        option3.text = question.option3
        option4.text = question.option4
        setOnClickViews()
    }

    override fun changeColor(optionId: Int, color: Int) {
        when(optionId) {
            1 -> option1.setBackgroundColor(color)
            2 -> option2.setBackgroundColor(color)
            3 -> option3.setBackgroundColor(color)
            4 -> option4.setBackgroundColor(color)
        }
    }

    private fun cleanBackground() {
        option1.setBackgroundColor(colorBackground)
        option2.setBackgroundColor(colorBackground)
        option3.setBackgroundColor(colorBackground)
        option4.setBackgroundColor(colorBackground)
    }

    private fun setOnClickViews() {
        option1.setOnClickListener {
            removeOnClick()
            presenter.option1onClick()
        }
        option2.setOnClickListener {
            removeOnClick()
            presenter.option2onClick()
        }
        option3.setOnClickListener {
            removeOnClick()
            presenter.option3onClick()
        }
        option4.setOnClickListener {
            removeOnClick()
            presenter.option4onClick()
        }
    }

    private fun removeOnClick() {
        option1.setOnClickListener(null)
        option2.setOnClickListener(null)
        option3.setOnClickListener(null)
        option4.setOnClickListener(null)
    }

    private fun hideViews() {
        option1.hide()
        option2.hide()
        option3.hide()
        option4.hide()
    }
}
