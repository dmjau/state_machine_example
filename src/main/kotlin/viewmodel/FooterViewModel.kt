package viewmodel

import fsm.FiniteStateMachine
import ui.FooterStateComponent

class FooterViewModel {

    var footerFSM: FiniteStateMachine? = null
    var footerInitialState: String? = null

    fun createFooterFSM(initialState: String?){

        setInitialFooterState(initialState)

        footerFSM = createFooterFSM()

        runFooterFSM()
    }

    private fun setInitialFooterState(initState: String?){
        footerInitialState = initState
    }

    private fun createFooterFSM() = FiniteStateMachine(footerInitialState)

    private fun runFooterFSM(){
        footerFSM?.registerStateComponent(FooterStateComponent())
        footerFSM?.initState()
    }

    fun runFooterNextState(){
        footerFSM?.setNextState()
    }
}