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

        footerViewModel.createFooterFSM(initState)

        assertEquals("collapsed", footerViewModel.footerInitialState)
    }

    @Test
    fun `Set next state OK`(){
        val footerViewModel = FooterViewModel()
        val initState = "collapsed"

        footerViewModel.createFooterFSM(initState)

        // check init parameters
        assertEquals("collapsed", footerViewModel.footerInitialState)
        assertTrue(footerViewModel.footerFSM?.currentState is OnCollapsedState)

        // set next state
        footerViewModel.runFooterNextState()

        // check next state
        assertEquals("collapsed", footerViewModel.footerInitialState)
        assertTrue(footerViewModel.footerFSM?.currentState is OnExpandedState)
    }
}