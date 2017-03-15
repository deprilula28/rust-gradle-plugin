package com.jtitor.plugin.gradle.rust.tasks

import com.jtitor.plugin.gradle.rust.tasks.CargoTask
import org.gradle.api.tasks.TaskAction

class RustBuild extends CargoTask {
	
	private String taskName = "build"

	private String invocationForAction() {
		return invocationForCargoAction(taskName)
	}

	/**
	Runs cargo build on the given project.
	*/
	@TaskAction
	void build() {
		logTaskStart(taskName)
		//Do a cargo build.
		project.exec {
			commandLine invocationForAction()
		}
	}
}