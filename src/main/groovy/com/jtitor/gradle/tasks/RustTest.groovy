package com.jtitor.plugin.gradle.rust.tasks

import com.jtitor.plugin.gradle.rust.tasks.CargoTask

/**
Runs cargo test on the given project.
*/
class RustTest extends CargoTask {
	String actionName() {
		return "test"
	}
}