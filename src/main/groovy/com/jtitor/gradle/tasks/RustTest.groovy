package com.jtitor.plugin.gradle.rust.tasks

import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import com.jtitor.plugin.gradle.rust.tasks.CargoTask

/**
Runs cargo test on the given project.
*/
class RustTest extends CargoTask {
	public static final String FLAG_ENABLE_BACKTRACE = "RUST_BACKTRACE=1"

	/**
	Enables backtraces during testing;
	this is set to true by default.
	*/
	@Input
	boolean enableBacktrace = true

	String actionName() {
		return "test"
	}

	@TaskAction
	void doCargoAction() {
		System.setProperty("RUST_BACKTRACE", enableBacktrace ? "1" : "0")
		super.doCargoAction()
	}
}