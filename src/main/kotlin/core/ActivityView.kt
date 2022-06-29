package core

import states.StateMachine
import ui.FooterStateComponent

class ActivityView {

    var stateMachine: StateMachine? = null
    var initialState: String? = null

    fun initStateMachine(initState: String?){
        initialState = initState
        stateMachine = createFooterSM(initialState)
        runStateMachine()
    }


    private fun createFooterSM(initialState: String?) = StateMachine(initialState)

    private fun runStateMachine(){
        stateMachine?.registerStateComponent(FooterStateComponent())
        stateMachine?.initState()
    }

    fun runNextState(){
        stateMachine?.setNextState()
    }
}