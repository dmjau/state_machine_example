package viewmodels

import fsm.states.OnHideState
import fsm.states.OnShowState
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HeaderViewModelTest {

    @Test
    fun `Test HeaderViewModel create FSM OK`(){
        // given
        val headerViewModel = HeaderViewModel()
        val initState = "show"

        // when
        headerViewModel.createHeaderFSM(initState)

        // then
        assertNotNull(headerViewModel.headerFSM)
    }

    @Test
    fun `Test HeaderViewModel set init state OK`(){
        // given
        val headerViewModel = HeaderViewModel()
        val initState = "show"

        // when
        headerViewModel.createHeaderFSM(initState)

        // then
        assertTrue(headerViewModel.headerFSM?.currentState is OnShowState)
    }

    @Test
    fun `Test when HeaderViewModel call next state OK`(){
        // given
        val headerViewModel = HeaderViewModel()
        val initState = "show"

        headerViewModel.createHeaderFSM(initState)

        // check initial state
        assertTrue(headerViewModel.headerFSM?.currentState is OnShowState)

        // when
        headerViewModel.runHeaderNextState()

        // then
        assertTrue(headerViewModel.headerFSM?.currentState is OnHideState)
    }
}