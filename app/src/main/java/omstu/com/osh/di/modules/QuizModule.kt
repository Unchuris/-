package omstu.com.osh.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import omstu.com.osh.ui.main.quiz.question.QuestionFragment
import omstu.com.osh.ui.main.quiz.result.ResultFragment

@Module
abstract class QuizModule {

    @ContributesAndroidInjector
    abstract fun bindQuestionFragment(): QuestionFragment

    @ContributesAndroidInjector
    abstract fun bindResultFragment(): ResultFragment
}
