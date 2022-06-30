package viewmodels

import fsm.states.OnHideState
import fsm.states.OnShowState
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HeaderViewModelTest {

    @Test
    fun `Test HeaderViewModel create FSM OK`() {
        // given
        val initState = "show"
        val headerViewModel = HeaderViewModel(initState)

        // when
        headerViewModel.bind()

        // then
        assertNotNull(headerViewModel.headerFSM)
    }

    @Test
    fun `Test HeaderViewModel set init state OK`() {
        // given
        val initState = "show"
        val headerViewModel = HeaderViewModel(initState)

        // when
        headerViewModel.bind()

        // then
        assertTrue(headerViewModel.headerFSM?.currentState is OnShowState)
    }

    @Test
    fun `Test when HeaderViewModel call next state OK`() {
        // given
        val initState = "show"
        val headerViewModel = HeaderViewModel(initState)

        headerViewModel.bind()

        // check initial state
        assertTrue(headerViewModel.headerFSM?.currentState is OnShowState)

        // when
        headerViewModel.onClickEvent()

        // then
        assertTrue(headerViewModel.headerFSM?.currentState is OnHideState)
    }
}