package omstu.com.osh.ui.main.training

import com.arellomobile.mvp.InjectViewState
import omstu.com.osh.ui.Screens
import omstu.com.osh.ui.common.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class TrainingPresenter @Inject constructor(
        private val router: Router
) : BasePresenter<TrainingView>() {


    override fun onFirstViewAttach() {
        router.replaceScreen(Screens.REGULATIONS_SCREEN)
        super.onFirstViewAttach()
    }
}
