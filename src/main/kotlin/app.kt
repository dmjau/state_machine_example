import viewmodels.FooterViewModel
import viewmodels.HeaderViewModel

fun main(){

    /**
     * States.
     */
    val initStateCollapsed = "collapsed"
    val initStateExpanded = "expanded"
    val initStateShow = "show"
    val initStateHide = "hide"

    val footerViewModel = FooterViewModel(initStateExpanded)
    val headerViewModel = HeaderViewModel(initStateShow)

    footerViewModel.bind()
    footerViewModel.onClickEvent()

    headerViewModel.bind()
    headerViewModel.onClickEvent()
    headerViewModel.onClickEvent()
    headerViewModel.onClickEvent()
}
