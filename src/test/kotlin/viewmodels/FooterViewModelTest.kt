package viewmodels

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import fsm.states.OnCollapsedState
import fsm.states.OnExpandedState

class FooterViewModelTest {

    @Test
    fun `Test FooterViewModel create FSM OK`() {
        // given
        val initState = "collapsed"
        val initStateDependantComponent = "hide"
        val footerViewModel = FooterViewModel(initState, initStateDependantComponent)

        // when
        footerViewModel.bind()

        // then
        assertNotNull(footerViewModel.footerFSM)
    }

    @Test
    fun `Test FooterViewModel set init state OK`() {
        // given
        val initState = "collapsed"
        val initStateDependantComponent = "hide"
        val footerViewModel = FooterViewModel(initState, initStateDependantComponent)

        // when
        footerViewModel.bind()

        // then
        assertTrue(footerViewModel.footerFSM?.currentState is OnCollapsedState)
    }

    @Test
    fun `Test when FooterViewModel call next state OK`() {
        // given
        val initState = "collapsed"
        val initStateDependantComponent = "hide"
        val footerViewModel = FooterViewModel(initState, initStateDependantComponent)

        footerViewModel.bind()

        // check initial state
        assertTrue(footerViewModel.footerFSM?.currentState is OnCollapsedState)

        // when
        footerViewModel.onClickEvent()

        // then
        assertTrue(footerViewModel.footerFSM?.currentState is OnExpandedState)
    }
}