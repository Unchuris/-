package omstu.com.osh.ui.main.training.regulations

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.regulations_fragment.*
import kotlinx.android.synthetic.main.toolbar.*
import omstu.com.osh.R
import omstu.com.osh.ui.common.BaseFragment
import javax.inject.Inject

class RegulationsFragment : BaseFragment(), RegulationsView {

    override val layoutRes = R.layout.regulations_fragment

    @Inject
    @InjectPresenter
    lateinit var presenter: RegulationsPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(toolbar, titleText = "Выбор раздела") { presenter.back() }
    }

    override fun initRecycler(list: List<String>) {
        recyclerView.adapter = RegulationsAdapter(list) { presenter.itemOnclick(it) }
    }
}
