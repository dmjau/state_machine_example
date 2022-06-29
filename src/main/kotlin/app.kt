import core.ActivityView

fun main(){
    val initStateCollapsed = "collapsed"
    val initStateExpanded = "expanded"
    val activityView = ActivityView()


    activityView.initStateMachine(initStateExpanded)

    activityView.runNextState()
}

