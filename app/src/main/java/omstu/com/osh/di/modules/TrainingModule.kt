package omstu.com.osh.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import omstu.com.osh.ui.main.training.regulations.RegulationsFragment
import omstu.com.osh.ui.main.training.regulations.pdf.PdfFragment

@Module
abstract class TrainingModule {

    @ContributesAndroidInjector
    abstract fun bindRegulationsFragment(): RegulationsFragment

    @ContributesAndroidInjector
    abstract fun bindPdfFragmentFragment(): PdfFragment
}
