package com.jtitor.plugin.gradle.rust.tasks

import com.jtitor.plugin.gradle.rust.tasks.CargoTask

/**
Runs cargo build on the given project.
*/
class RustBuild extends CargoTask {
	String actionName() {
		return "build"
	}
}