package viewmodels

import fsm.FiniteStateMachine
import ui.FooterStateComponent

class FooterViewModel(private val initialState: String?) {

    var footerFSM: FiniteStateMachine? = null
    var footerInitialState: String? = null

    fun bind(){

        setInitialState(initialState)

        footerFSM = createFSM()

        runFSM()
    }

    private fun setInitialState(initState: String?){
        footerInitialState = initState
    }

    private fun createFSM() = FiniteStateMachine(footerInitialState)

    private fun runFSM(){
        footerFSM?.registerStateComponent(FooterStateComponent())
        footerFSM?.initState()
    }

    fun onClickEvent(){
        footerFSM?.setNextState()
    }
}