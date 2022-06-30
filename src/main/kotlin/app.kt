import viewmodels.FooterViewModel
import viewmodels.HeaderViewModel

fun main() {

    /**
     * States.
     */
    val initStateCollapsed = "collapsed"
    val initStateExpanded = "expanded"
    val initStateShow = "show"
    val initStateHide = "hide"

    val footerViewModel = FooterViewModel(initStateExpanded, initStateHide)

    footerViewModel.bind()
    footerViewModel.onClickEvent()
}
