package core

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import fsm.states.OnCollapsedState
import fsm.states.OnExpandedState
import viewmodel.FooterViewModel

class FooterViewModelTest {

    @Test
    fun `Set initial state OK`(){
        val footerViewModel = FooterViewModel()
        val initState = "collapsed"

        footerViewModel.createFSM(initState)

        assertEquals("collapsed", footerViewModel.initialState)
    }

    @Test
    fun `Set next state OK`(){
        val footerViewModel = FooterViewModel()
        val initState = "collapsed"

        footerViewModel.createFSM(initState)

        // check init parameters
        assertEquals("collapsed", footerViewModel.initialState)
        assertTrue(footerViewModel.finiteStateMachine?.currentState is OnCollapsedState)

        // set next state
        footerViewModel.runToNextState()

        // check next state
        assertEquals("collapsed", footerViewModel.initialState)
        assertTrue(footerViewModel.finiteStateMachine?.currentState is OnExpandedState)
    }
}