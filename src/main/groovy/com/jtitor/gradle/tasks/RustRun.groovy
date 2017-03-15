package com.jtitor.plugin.gradle.rust.tasks

import com.jtitor.plugin.gradle.rust.tasks.CargoTask
import org.gradle.api.tasks.TaskAction

class RustRun extends CargoTask {
	
	private String taskName = "run"

	private String invocationForAction() {
		return invocationForCargoAction(taskName)
	}

	/**
	Runs cargo run on the given project.
	*/
	@TaskAction
	void run() {
		logTaskStart(taskName)
		//Do a cargo run.
		project.exec {
			standardInput System.in
			commandLine invocationForAction()
		}
	}
}