package ui

import fsm.StateComponent

class FooterStateComponent : StateComponent {
    override fun onCollapseState() {
        println("Footer -> current state: COLLAPSED")
    }

    override fun onExpandedState() {
        println("Footer -> current state: EXPANDED")
    }

    override fun onHideState() {
        println("Footer -> current state: HIDE")
    }

    override fun onShowState() {
        println("Footer -> current state: SHOW")
    }
}