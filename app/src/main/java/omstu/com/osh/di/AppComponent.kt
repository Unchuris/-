package omstu.com.osh.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import omstu.com.osh.App
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, AndroidSupportInjectionModule::class, AndroidInjectionModule::class, ActivityBuilder::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(app: Application): Builder

        fun build(): AppComponent
    }
}
