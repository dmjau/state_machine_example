package ui

import fsm.StateComponent

class HeaderStateComponent : StateComponent {
    override fun onCollapseState() {
        println("Header -> current state: COLLAPSED")
    }

    override fun onExpandedState() {
        println("Header -> current state: EXPANDED")
    }

    override fun onHideState() {
        println("Header -> current state: HIDE")
    }

    override fun onShowState() {
        println("Header -> current state: SHOW")
    }
}