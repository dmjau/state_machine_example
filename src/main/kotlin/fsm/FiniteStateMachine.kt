package fsm

import fsm.states.OnCollapsedState
import fsm.states.OnExpandedState
import fsm.states.OnHideState
import fsm.states.OnShowState

class FiniteStateMachine(private val initialState: String?) {

    val statesComponentsRegisteredList: MutableList<StateComponent> = ArrayList()
    val statesMachinesDependantList: MutableList<FiniteStateMachine> = ArrayList()
    var currentState: StateObject? = null

    /**
     * Sets init state in the components registered in the list.
     */
    fun initState() {
        setInitCurrentState()
        executeCurrentState()
    }

    /**
     * Select state to init execute.
     */
    private fun setInitCurrentState() {
        currentState = when (initialState) {
            ON_COLLAPSED_STATE -> OnCollapsedState()
            ON_EXPANDED_STATE -> OnExpandedState()
            ON_HIDE_STATE -> OnHideState()
            ON_SHOW_STATE -> OnShowState()
            else -> null
        }

        // Propagate initialization to dependant SM
        statesMachinesDependantList.let { list ->
            list.forEach {
                it.setInitCurrentState()
            }
        }
    }

    /**
     * Execute current state.
     */
    private fun executeCurrentState() {
        // Execute the state
        currentState?.executeState(statesComponentsRegisteredList)

        // Propagate state execution to dependant SM
        statesMachinesDependantList.let { list ->
            list.forEach {
                it.executeCurrentState()
            }
        }
    }

    /**
     * Register components that use states in the array.
     */
    fun registerStateComponent(componentToRegister: StateComponent) {
        statesComponentsRegisteredList.add(componentToRegister)
    }

    /**
     * Register states machines that will depend on this one to change states.
     */
    fun registerDependantStateMachine(dependantSM: FiniteStateMachine) {
        statesMachinesDependantList.add(dependantSM)
    }

    /**
     * Sets and execute next state.
     */
    fun setNextState() {
        currentState?.let {
            currentState = currentState?.nextState()
            executeCurrentState()
        }

        // Propagate state change to dependant SM
        statesMachinesDependantList.forEach {
            it.setNextState()
        }
    }

    /**
     * Clean array states objects.
     */
    fun clean() {
        statesComponentsRegisteredList.clear()
        statesMachinesDependantList.clear()
    }

    companion object {
        const val ON_COLLAPSED_STATE = "collapsed"
        const val ON_EXPANDED_STATE = "expanded"
        const val ON_HIDE_STATE = "hide"
        const val ON_SHOW_STATE = "show"
    }
}
