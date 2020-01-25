package com.example.helloworkflow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.workflow.ui.ExperimentalWorkflowUi
import com.squareup.workflow.ui.ViewRegistry
import com.squareup.workflow.ui.WorkflowRunner
import com.squareup.workflow.ui.setContentWorkflow

@UseExperimental(ExperimentalWorkflowUi::class)
class HelloWorkflowActivity : AppCompatActivity() {
    private val viewRegistry = ViewRegistry(HelloLayoutRunner)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentWorkflow(savedInstanceState) {
            WorkflowRunner.Config(HelloWorkflow, viewRegistry)
        }
    }

    // To opt-in to state saving, use this alternative and
    // implement StatefulWorkflow.snapshotState.
//
//    private lateinit var runner: WorkflowRunner<Unit>
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        runner = setContentWorkflow(savedInstanceState) {
//            WorkflowRunner.Config(HelloWorkflow, viewRegistry)
//        }
//    }
//
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        runner.onSaveInstanceState(outState)
//    }
//

    /**
     * To handle the back button, uncomment this and have your
     * [LayoutRunners][com.squareup.workflow.ui.LayoutRunner] use
     * [setBackHandler][com.squareup.workflow.ui.setBackHandler].
     */
//    override fun onBackPressed() {
//        if (!workflowOnBackPressed()) super.onBackPressed()
//    }
}
