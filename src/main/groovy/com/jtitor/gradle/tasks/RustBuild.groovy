package com.jtitor.plugin.gradle.rust.tasks

import com.jtitor.plugin.gradle.rust.tasks.CargoTask
import org.gradle.api.tasks.TaskAction

/**
Runs cargo build on the given project.
*/
class RustBuild extends CargoTask {
	String actionName() {
		return "build"
	}
}