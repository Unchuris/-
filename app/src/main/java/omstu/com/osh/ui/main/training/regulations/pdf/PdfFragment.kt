package omstu.com.osh.ui.main.training.regulations.pdf

import android.os.Bundle
import android.view.View
import com.github.barteksc.pdfviewer.link.DefaultLinkHandler
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.github.barteksc.pdfviewer.util.FitPolicy
import kotlinx.android.synthetic.main.pdf_fragmnet.*
import omstu.com.osh.R
import omstu.com.osh.ui.common.BaseFragment

class PdfFragment : BaseFragment() {

    override val layoutRes = R.layout.pdf_fragmnet

    companion object {
        const val FILE_NAME = "fileName"

        fun gewInstance(key: String) = PdfFragment().apply {
            arguments = Bundle().apply {
                putString(FILE_NAME, key)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(FILE_NAME)?.let {
            pdfView.fromAsset(it)
                .enableAnnotationRendering(true)
                .autoSpacing ( false )
                .scrollHandle(DefaultScrollHandle(context))
                .linkHandler(DefaultLinkHandler(pdfView))
                .pageFitPolicy(FitPolicy.BOTH)
                .load()
        }
    }
}