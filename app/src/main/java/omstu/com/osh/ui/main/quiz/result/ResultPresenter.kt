package omstu.com.osh.ui.main.quiz.result

import com.arellomobile.mvp.InjectViewState
import omstu.com.osh.ui.Screens
import omstu.com.osh.ui.common.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ResultPresenter @Inject constructor(
    private val router: Router
) : BasePresenter<ResultView>() {

    fun back() = router.exit()

    fun again() = router.replaceScreen(Screens.QUESTION_SCREEN)
}
