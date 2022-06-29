package fsm

interface StateComponent {
    fun onCollapseState()

    fun onExpandedState()

    fun onHideState()

    fun onShowState()
}