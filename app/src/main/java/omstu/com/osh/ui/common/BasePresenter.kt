package omstu.com.osh.ui.common

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<View : MvpView> : MvpPresenter<View>() {

    protected val disposable = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}
