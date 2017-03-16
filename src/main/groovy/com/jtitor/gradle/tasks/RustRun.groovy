package com.jtitor.plugin.gradle.rust.tasks

import com.jtitor.plugin.gradle.rust.tasks.CargoTask
import org.gradle.api.tasks.TaskAction

/**
Runs cargo run on the given project.
*/
class RustRun extends CargoTask {
	String actionName() {
		return "run"
	}
}