package ui

import fsm.StateComponent

class HeaderStateComponent : StateComponent {
    override fun onCollapseState() {
        println("Header -> current state: collapsed")
    }

    override fun onExpandedState() {
        println("Header -> current state: expanded")
    }

    override fun onHideState() {
        println("Header -> current state: hide")
    }

    override fun onShowState() {
        println("Header -> current state: show")
    }
}