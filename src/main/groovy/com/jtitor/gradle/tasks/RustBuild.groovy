package com.jtitor.plugin.gradle.rust.tasks

import com.jtitor.plugin.gradle.rust.tasks.CargoTask
import org.gradle.api.tasks.TaskAction

class RustBuild extends CargoTask {
	
	/**
	Runs cargo build on the given project.
	*/
	@TaskAction
	void build() {
		//Do a cargo build.
	}
}