package states

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