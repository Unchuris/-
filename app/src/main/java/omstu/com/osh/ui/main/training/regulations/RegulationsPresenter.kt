package omstu.com.osh.ui.main.training.regulations

import com.arellomobile.mvp.InjectViewState
import omstu.com.osh.ui.Screens
import omstu.com.osh.ui.common.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class RegulationsPresenter @Inject constructor(
    private val router: Router
) : BasePresenter<RegulationsView>() {

    override fun onFirstViewAttach() {
        viewState.initRecycler(PdfNames.list.map { it.title })
        super.onFirstViewAttach()
    }

    fun back() = router.exit()

    fun itemOnclick(position: Int) {
        if (position > -1 && position < PdfNames.list.size) {
            router.navigateTo(Screens.PDF_SCREEN, PdfNames.list[position].path)
        }
    }
}
