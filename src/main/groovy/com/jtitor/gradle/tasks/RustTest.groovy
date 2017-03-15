package com.jtitor.plugin.gradle.rust.tasks

import com.jtitor.plugin.gradle.rust.tasks.CargoTask
import org.gradle.api.tasks.TaskAction

class RustTest extends CargoTask {
	
	/**
	Runs cargo test on the given project.
	*/
	@TaskAction
	void test() {
		//Do a cargo test.
	}
}