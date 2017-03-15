package com.jtitor.plugin.gradle.rust.tasks

import com.jtitor.plugin.gradle.rust.tasks.CargoTask
import org.gradle.api.tasks.TaskAction

class RustTest extends CargoTask {
	
	private String taskName = "test"
	
	private String invocationForAction() {
		return invocationForCargoAction(taskName)
	}

	/**
	Runs cargo test on the given project.
	*/
	@TaskAction
	void test() {
		logTaskStart(taskName)
		//Do a cargo test.
		project.exec {
			commandLine invocationForAction()
		}
	}
}