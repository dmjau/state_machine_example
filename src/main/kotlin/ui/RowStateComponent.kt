package ui

import states.StateComponent

class RowStateComponent : StateComponent {
    override fun onCollapseState() {
        println("Row -> state: collapsed")
    }

    override fun onExpandedState() {
        println("Row -> state: expanded")
    }

    override fun onHideState() {
        println("Row -> state: hide")
    }

    override fun onShowState() {
        println("Row -> state: show")
    }
}