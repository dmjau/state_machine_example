package ui

import fsm.StateComponent

class FooterStateComponent : StateComponent {
    override fun onCollapseState() {
        println("Footer -> current state: collapsed")
    }

    override fun onExpandedState() {
        println("Footer -> current state: expanded")
    }

    override fun onHideState() {
        println("Footer -> current state: hide")
    }

    override fun onShowState() {
        println("Footer -> current state: show")
    }
}