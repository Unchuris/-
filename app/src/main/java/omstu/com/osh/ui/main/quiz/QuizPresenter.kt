package omstu.com.osh.ui.main.quiz

import com.arellomobile.mvp.InjectViewState
import omstu.com.osh.ui.Screens
import omstu.com.osh.ui.common.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class QuizPresenter @Inject constructor(
    private val router: Router
) : BasePresenter<QuizView>() {

    override fun onFirstViewAttach() {
        router.replaceScreen(Screens.QUESTION_SCREEN)
        super.onFirstViewAttach()
    }
}
