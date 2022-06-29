package viewmodel

import fsm.FiniteStateMachine
import ui.HeaderStateComponent

class HeaderViewModel {

    var headerFSM: FiniteStateMachine? = null
    var headerInitialState: String? = null

    fun createHeaderFSM(initialState: String?){

        setInitialHeaderState(initialState)

        headerFSM = createHeaderFSM()

        runHeaderFSM()
    }

    private fun setInitialHeaderState(initState: String?){
        headerInitialState = initState
    }

    private fun createHeaderFSM() = FiniteStateMachine(headerInitialState)

    private fun runHeaderFSM(){
        headerFSM?.registerStateComponent(HeaderStateComponent())
        headerFSM?.initState()
    }

    fun runHeaderNextState(){
        headerFSM?.setNextState()
    }
}