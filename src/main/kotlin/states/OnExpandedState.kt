package states

class OnExpandedState : StateObject {
    override fun nextState(): StateObject {
        return OnCollapsedState()
    }

    override fun executeState(listStatesComponents: MutableList<StateComponent>) {
        listStatesComponents.forEach {
            it.onExpandedState()
        }
    }
}