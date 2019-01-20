package omstu.com.osh.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import omstu.com.osh.di.modules.QuizModule
import omstu.com.osh.di.modules.TrainingModule
import omstu.com.osh.ui.main.MainActivity
import omstu.com.osh.ui.main.quiz.QuizActivity
import omstu.com.osh.ui.main.training.TrainingActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [TrainingModule::class])
    abstract fun bindTrainingActivity(): TrainingActivity

    @ContributesAndroidInjector(modules = [QuizModule::class])
    abstract fun bindQuizActivity(): QuizActivity
}
