package com.jtitor.plugin.gradle.rust.tasks

import com.jtitor.plugin.gradle.rust.tasks.CargoTask

/**
Runs cargo doc on the given project.
*/
class RustDoc extends CargoTask {
	String actionName() {
		return "doc"
	}
}