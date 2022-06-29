import viewmodel.FooterViewModel

fun main(){

    /**
     * States.
     */
    val initStateCollapsed = "collapsed"
    val initStateExpanded = "expanded"

    val footerViewModel = FooterViewModel()

    footerViewModel.createFSM(initStateExpanded)
    footerViewModel.runToNextState()
}
