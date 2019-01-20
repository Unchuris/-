package omstu.com.osh.ui.main.quiz.question

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import omstu.com.osh.data.entities.Question

@StateStrategyType(AddToEndSingleStrategy::class)
interface QuestionView : MvpView {
    fun showQuestion(question: Question)
    fun changeColor(optionId: Int, color: Int)
}
