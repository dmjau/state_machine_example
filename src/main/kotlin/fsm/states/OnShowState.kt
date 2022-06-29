package fsm.states

import fsm.StateComponent
import fsm.StateObject

class OnShowState : StateObject {
    override fun nextState(): StateObject {
        return OnHideState()
    }

    override fun executeState(listStatesComponents: MutableList<StateComponent>) {
        listStatesComponents.forEach {
            it.onShowState()
        }
    }
}