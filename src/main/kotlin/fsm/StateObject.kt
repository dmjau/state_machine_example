package fsm

interface StateObject {
    fun nextState() : StateObject

    fun executeState(listStatesComponents: MutableList<StateComponent>)
}