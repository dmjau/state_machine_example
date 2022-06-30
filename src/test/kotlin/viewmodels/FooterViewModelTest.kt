package viewmodels

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import fsm.states.OnCollapsedState
import fsm.states.OnExpandedState

class FooterViewModelTest {

    @Test
    fun `Test FooterViewModel create FSM OK`(){
        // given
        val footerViewModel = FooterViewModel()
        val initState = "collapsed"

        // when
        footerViewModel.createFooterFSM(initState)

        // then
        assertNotNull(footerViewModel.footerFSM)
    }

    @Test
    fun `Test FooterViewModel set init state OK`(){
        // given
        val footerViewModel = FooterViewModel()
        val initState = "collapsed"

        // when
        footerViewModel.createFooterFSM(initState)

        // then
        assertTrue(footerViewModel.footerFSM?.currentState is OnCollapsedState)
    }

    @Test
    fun `Test when FooterViewModel call next state OK`(){
        // given
        val footerViewModel = FooterViewModel()
        val initState = "collapsed"

        footerViewModel.createFooterFSM(initState)

        // check initial state
        assertTrue(footerViewModel.footerFSM?.currentState is OnCollapsedState)

        // when
        footerViewModel.runFooterNextState()

        // then
        assertTrue(footerViewModel.footerFSM?.currentState is OnExpandedState)
    }
}