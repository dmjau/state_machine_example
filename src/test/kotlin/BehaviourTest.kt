import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut
import org.junit.jupiter.api.Test
import viewmodels.FooterViewModel
import viewmodels.HeaderViewModel
import kotlin.test.assertEquals

class BehaviourTest {

    @Test
    fun `Test printLn in the HeaderStateComponent when initial state header is SHOW`(){

        // given
        val initState = "show"
        val headerViewModel = HeaderViewModel(initState)

        val output = tapSystemOut {
            // when
            headerViewModel.bind()
        }

        // then
        assertEquals("Header -> current state: SHOW", output.trim())
    }

    @Test
    fun `Test printLn in the HeaderStateComponent when initial state header is HIDE`(){

        // given
        val initState = "hide"
        val headerViewModel = HeaderViewModel(initState)

        val output = tapSystemOut {
            // when
            headerViewModel.bind()
        }

        // then
        assertEquals("Header -> current state: HIDE", output.trim())
    }

    @Test
    fun `Test printLn in the HeaderStateComponent when initial state header is SHOW change to HIDE`(){

        // given
        val initState = "show"
        val headerViewModel = HeaderViewModel(initState)

        var output = tapSystemOut {
            headerViewModel.bind()
        }

        // check previous call next state
        assertEquals("Header -> current state: SHOW", output.trim())

        // when
        output = tapSystemOut {
            // when
            headerViewModel.onClickEvent()
        }

        // then
        assertEquals("Header -> current state: HIDE", output.trim())
    }

    @Test
    fun `Test printLn in the HeaderStateComponent when initial state header is SHOW change to HIDE and change again to SHOW`(){

        // given
        val initState = "show"
        val headerViewModel = HeaderViewModel(initState)

        var output = tapSystemOut {
            headerViewModel.bind()
        }

        // check initial state view
        assertEquals("Header -> current state: SHOW", output.trim())

        output = tapSystemOut {
            // when
            headerViewModel.onClickEvent()
        }

        // check first change state
        assertEquals("Header -> current state: HIDE", output.trim())

        output = tapSystemOut {
            // when
            headerViewModel.onClickEvent()
        }

        // check second change state
        assertEquals("Header -> current state: SHOW", output.trim())
    }

    @Test
    fun `Test printLn in the FooterStateComponent when initial state header is COLLAPSED`(){

        // given
        val initState = "collapsed"
        val footerViewModel = FooterViewModel(initState)

        val output = tapSystemOut {
            // when
            footerViewModel.bind()
        }

        // then
        assertEquals("Footer -> current state: COLLAPSED", output.trim())
    }

    @Test
    fun `Test printLn in the FooterStateComponent when initial state header is EXPANDED`(){

        // given
        val initState = "expanded"
        val footerViewModel = FooterViewModel(initState)

        val output = tapSystemOut {
            // when
            footerViewModel.bind()
        }

        // then
        assertEquals("Footer -> current state: EXPANDED", output.trim())
    }

    @Test
    fun `Test printLn in the FooterStateComponent when initial state header is EXPANDED change to COLLAPSED`(){

        // given
        val initState = "expanded"
        val footerViewModel = FooterViewModel(initState)

        var output = tapSystemOut {
            footerViewModel.bind()
        }

        // check previous call next state
        assertEquals("Footer -> current state: EXPANDED", output.trim())

        // when
        output = tapSystemOut {
            // when
            footerViewModel.onClickEvent()
        }

        // then
        assertEquals("Footer -> current state: COLLAPSED", output.trim())
    }

    @Test
    fun `Test printLn in the FooterStateComponent when initial state header is EXPANDED change to COLLAPSED and change again to EXPANDED`(){

        // given
        val initState = "expanded"
        val footerViewModel = FooterViewModel(initState)

        var output = tapSystemOut {
            footerViewModel.bind()

        }

        // check initial state view
        assertEquals("Footer -> current state: EXPANDED", output.trim())

        output = tapSystemOut {
            // when
            footerViewModel.onClickEvent()
        }

        // check first change state
        assertEquals("Footer -> current state: COLLAPSED", output.trim())

        output = tapSystemOut {
            // when
            footerViewModel.onClickEvent()
        }

        // check second change state
        assertEquals("Footer -> current state: EXPANDED", output.trim())
    }
}