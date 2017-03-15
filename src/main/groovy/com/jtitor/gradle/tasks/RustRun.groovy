package com.jtitor.plugin.gradle.rust.tasks

import com.jtitor.plugin.gradle.rust.tasks.CargoTask
import org.gradle.api.tasks.TaskAction

class RustRun extends CargoTask {
	
	/**
	Runs cargo run on the given project.
	*/
	@TaskAction
	void run() {
		//Do a cargo run.
	}
}