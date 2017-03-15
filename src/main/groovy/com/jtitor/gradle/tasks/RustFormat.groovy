package com.jtitor.plugin.gradle.rust.tasks

import com.jtitor.plugin.gradle.rust.tasks.CargoTask
import org.gradle.api.tasks.TaskAction

class RustFormat extends CargoTask {
	
	/**
	Runs cargo fmt on the given project.
	*/
	@TaskAction
	void format() {
		//Do a cargo fmt.
	}
}