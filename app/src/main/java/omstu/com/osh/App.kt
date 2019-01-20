package omstu.com.osh

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import omstu.com.osh.di.DaggerAppComponent
import timber.log.Timber

class App : DaggerApplication() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent.builder().app(this).build()
}
