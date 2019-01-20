package omstu.com.osh.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import omstu.com.osh.di.modules.NavigationModule
import javax.inject.Singleton

@Module(includes = [NavigationModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: Application): Context = app.applicationContext
}
