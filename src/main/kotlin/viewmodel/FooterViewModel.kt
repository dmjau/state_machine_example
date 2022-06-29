package viewmodel

import fsm.FiniteStateMachine
import ui.FooterStateComponent

class FooterViewModel {

    var finiteStateMachine: FiniteStateMachine? = null
    var initialState: String? = null

    fun createFSM(initState: String?){
        initialState = initState
        finiteStateMachine = FiniteStateMachine(initialState)
        runStateMachine()
    }

    private fun runStateMachine(){
        finiteStateMachine?.registerStateComponent(FooterStateComponent())
        finiteStateMachine?.initState()
    }

    fun runToNextState(){
        finiteStateMachine?.setNextState()
    }
}