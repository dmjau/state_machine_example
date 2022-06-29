import viewmodel.FooterViewModel
import viewmodel.HeaderViewModel

fun main(){

    /**
     * States.
     */
    val initStateCollapsed = "collapsed"
    val initStateExpanded = "expanded"
    val initStateShow = "show"
    val initStateHide = "hide"

    val footerViewModel = FooterViewModel()
    val headerViewModel = HeaderViewModel()

    footerViewModel.createFooterFSM(initStateExpanded)
    footerViewModel.runFooterNextState()

    headerViewModel.createHeaderFSM(initStateShow)
    headerViewModel.runHeaderNextState()
}
