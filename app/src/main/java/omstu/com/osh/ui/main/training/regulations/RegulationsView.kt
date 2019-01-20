package omstu.com.osh.ui.main.training.regulations

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface RegulationsView : MvpView {
    fun initRecycler(list: List<String>)
}
