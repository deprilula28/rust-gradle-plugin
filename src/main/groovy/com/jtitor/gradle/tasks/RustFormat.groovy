package com.jtitor.plugin.gradle.rust.tasks

import com.jtitor.plugin.gradle.rust.tasks.CargoTask
import org.gradle.api.tasks.TaskAction

class RustFormat extends TaskBase {
	//This doesn't have all of the flags
	//the other tasks have in common, so it uses TaskBase.

	/**
	Generates the Cargo string corresponding to the format action,
	with flags set to the task's values.
	*/	
	private String invocationForAction() {
		StringBuilder result = new StringBuilder("cargo fmt")
		if (verbose) {
			result.append(" --verbose")
		}
		if (quiet) {
			result.append(" --quiet")
		}

		return result.toString()
	}

	/**
	Runs cargo fmt on the given project.
	*/
	@TaskAction
	void format() {
		logTaskStart("format")
		//Do a cargo fmt.
		project.exec {
			commandLine invocationForAction()
		}
	}
}