package com.jtitor.plugin.gradle.rust.tasks

import org.gradle.api.DefaultTask

/**
Base class for tasks.
*/
class TaskBase extends DefaultTask {

	/**
	Adds verbose output.
	If true, this will call Cargo with the --verbose flag.
	*/
	boolean verbose = false

	/**
	Disables all standard output.
	If true, this will call Cargo with the --quiet flag.
	*/
	boolean quiet = false

	void logTaskStart(String taskName) {
		String toPrint = "Starting Cargo task: " + taskName
		println toPrint
	}
}