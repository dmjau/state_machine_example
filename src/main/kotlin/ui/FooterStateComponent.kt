package ui

import states.StateComponent

class FooterStateComponent : StateComponent {
    override fun onCollapseState() {
        println("Footer -> state: collapsed")
    }

    override fun onExpandedState() {
        println("Footer -> state: expanded")
    }

    override fun onHideState() {
        println("Footer -> state: hide")
    }

    override fun onShowState() {
        println("Footer -> state: show")
    }
}