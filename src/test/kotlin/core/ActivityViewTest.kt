package core

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import states.OnCollapsedState
import states.OnExpandedState

class ActivityViewTest {

    @Test
    fun `Set initial state OK`(){
        val activityView = ActivityView()
        val initState = "collapsed"

        activityView.initStateMachine(initState)

        assertEquals("collapsed", activityView.initialState)
    }

    @Test
    fun `Set next state OK`(){
        val activityView = ActivityView()
        val initState = "collapsed"

        activityView.initStateMachine(initState)

        // check init parameters
        assertEquals("collapsed", activityView.initialState)
        assertTrue(activityView.stateMachine?.currentState is OnCollapsedState)

        // set next state
        activityView.runNextState()

        // check next state
        assertEquals("collapsed", activityView.initialState)
        assertTrue(activityView.stateMachine?.currentState is OnExpandedState)
    }
}