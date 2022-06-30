package viewmodels

import fsm.FiniteStateMachine
import ui.HeaderStateComponent

class HeaderViewModel(private val initialState: String?) {

    var headerFSM: FiniteStateMachine? = null
    var headerInitialState: String? = null

    fun bind(){

        setInitialState(initialState)

        headerFSM = createFSM()

        runFSM()
    }

    private fun setInitialState(initState: String?){
        headerInitialState = initState
    }

    private fun createFSM() = FiniteStateMachine(headerInitialState)

    private fun runFSM(){
        headerFSM?.registerStateComponent(HeaderStateComponent())
        headerFSM?.initState()
    }

    fun onClickEvent(){
        headerFSM?.setNextState()
    }
}