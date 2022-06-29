package fsm.states

import fsm.StateComponent
import fsm.StateObject

class OnHideState : StateObject {
    override fun nextState(): StateObject {
        return OnShowState()
    }

    override fun executeState(listStatesComponents: MutableList<StateComponent>) {
        listStatesComponents.forEach {
            it.onHideState()
        }
    }
}