package com.jtitor.plugin.gradle.rust.tasks

import com.jtitor.plugin.gradle.rust.tasks.CargoTask
import org.gradle.api.tasks.TaskAction

/**
Runs cargo test on the given project.
*/
class RustTest extends CargoTask {
	String actionName() {
		return "test"
	}
}