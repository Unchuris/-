package omstu.com.osh.extensions

import android.view.View

fun View.setVisible(show: Boolean, collapseIfHide: Boolean = true) {
    if (show) show() else hide(collapseIfHide)
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide(collapse: Boolean = true) {
    visibility = if (collapse) View.GONE else View.INVISIBLE
}