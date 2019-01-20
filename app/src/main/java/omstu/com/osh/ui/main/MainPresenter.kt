package omstu.com.osh.ui.main

import com.arellomobile.mvp.InjectViewState
import omstu.com.osh.ui.Screens
import omstu.com.osh.ui.common.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
        private val router: Router
) : BasePresenter<MainView>() {

    fun trainingOnClick() = router.navigateTo(Screens.TRAINING_SCREEN)

    fun quizOnClick() = router.navigateTo(Screens.QUIZ_SCREEN)
}
