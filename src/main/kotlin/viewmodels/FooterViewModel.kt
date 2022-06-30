package viewmodels

import fsm.FiniteStateMachine
import ui.FooterStateComponent
import ui.HeaderStateComponent

class FooterViewModel(
    private val initialState: String?,
    private val initialStateDependant: String?
) {

    var footerFSM: FiniteStateMachine? = null
    var footerInitialState: String? = null

    fun bind() {

        setInitialState(initialState)

        footerFSM = createFSM()

        createDependantFSM()

        runFSM()
    }

    private fun setInitialState(initState: String?) {
        footerInitialState = initState
    }

    private fun createFSM() = FiniteStateMachine(footerInitialState)

    private fun createDependantFSM() {
        val dependantFSM = FiniteStateMachine(initialStateDependant)
        dependantFSM.registerStateComponent(HeaderStateComponent())

        footerFSM?.registerDependantStateMachine(dependantFSM)
    }

    private fun runFSM() {
        footerFSM?.registerStateComponent(FooterStateComponent())
        footerFSM?.initState()
    }

    fun onClickEvent() {
        footerFSM?.setNextState()
    }
}