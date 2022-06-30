import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut
import org.junit.jupiter.api.Test
import viewmodels.FooterViewModel
import viewmodels.HeaderViewModel
import kotlin.test.assertEquals

class BehaviourTest {

    @Test
    fun `Test printLn in the HeaderStateComponent when initial state header is SHOW`(){

        // given
        val headerViewModel = HeaderViewModel()
        val initState = "show"

        val output = tapSystemOut {
            // when
            headerViewModel.createHeaderFSM(initState)
        }

        // then
        assertEquals("Header -> current state: show", output.trim())
    }

    @Test
    fun `Test printLn in the HeaderStateComponent when initial state header is HIDE`(){

        // given
        val headerViewModel = HeaderViewModel()
        val initState = "hide"

        val output = tapSystemOut {
            // when
            headerViewModel.createHeaderFSM(initState)
        }

        // then
        assertEquals("Header -> current state: hide", output.trim())
    }

    @Test
    fun `Test printLn in the HeaderStateComponent when initial state header is SHOW change to HIDE`(){

        // given
        val headerViewModel = HeaderViewModel()
        val initState = "show"

        val output = tapSystemOut {
            headerViewModel.createHeaderFSM(initState)
        }

        // check previous call next state
        assertEquals("Header -> current state: show", output.trim())

        // when
        val outputNextState = tapSystemOut {
            // when
            headerViewModel.runHeaderNextState()
        }

        // then
        assertEquals("Header -> current state: hide", outputNextState.trim())
    }

    @Test
    fun `Test printLn in the FooterStateComponent when initial state header is COLLAPSED`(){

        // given
        val footerViewModel = FooterViewModel()
        val initState = "collapsed"

        val output = tapSystemOut {
            // when
            footerViewModel.createFooterFSM(initState)
        }

        // then
        assertEquals("Footer -> current state: collapsed", output.trim())
    }

    @Test
    fun `Test printLn in the FooterStateComponent when initial state header is EXPANDED`(){

        // given
        val footerViewModel = FooterViewModel()
        val initState = "expanded"

        val output = tapSystemOut {
            // when
            footerViewModel.createFooterFSM(initState)
        }

        // then
        assertEquals("Footer -> current state: expanded", output.trim())
    }

    @Test
    fun `Test printLn in the FooterStateComponent when initial state header is EXPANDED change to COLLAPSED`(){

        // given
        val footerViewModel = FooterViewModel()
        val initState = "expanded"

        val output = tapSystemOut {
            footerViewModel.createFooterFSM(initState)
        }

        // check previous call next state
        assertEquals("Footer -> current state: expanded", output.trim())

        // when
        val outputNextState = tapSystemOut {
            // when
            footerViewModel.runFooterNextState()
        }

        // then
        assertEquals("Footer -> current state: collapsed", outputNextState.trim())
    }
}