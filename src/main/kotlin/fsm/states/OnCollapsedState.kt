package fsm.states

import fsm.StateComponent
import fsm.StateObject

class OnCollapsedState  : StateObject {
    override fun nextState(): StateObject {
        return OnExpandedState()
    }

    override fun executeState(listStatesComponents: MutableList<StateComponent>) {
        listStatesComponents.forEach {
            it.onCollapseState()
        }
    }
}