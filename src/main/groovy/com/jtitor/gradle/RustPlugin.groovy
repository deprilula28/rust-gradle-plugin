package com.jtitor.plugin.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.jtitor.plugin.gradle.rust.tasks.RustBuild
import com.jtitor.plugin.gradle.rust.tasks.RustRun
import com.jtitor.plugin.gradle.rust.tasks.RustTest
import com.jtitor.plugin.gradle.rust.tasks.RustFormat
import com.jtitor.plugin.gradle.rust.tasks.RustDoc

/**
 * Created by ariel on 17/05/15.
 * The plugin itself. This contains some preset tasks for
 * building, testing and running the project via Cargo
 * in case you are using the plugin via an IDE
 * and want to be able to connect it to a IDE hotkey.
 */
class RustPlugin implements Plugin<Project> {
	@Override
	void apply(Project project) {
		//Add aliases for custom task types.
		project.ext.RustBuild = com.jtitor.plugin.gradle.rust.tasks.RustBuild
		project.ext.RustRun = com.jtitor.plugin.gradle.rust.tasks.RustRun
		project.ext.RustFormat = com.jtitor.plugin.gradle.rust.tasks.RustFormat
		project.ext.RustTest = com.jtitor.plugin.gradle.rust.tasks.RustTest
		project.ext.RustDoc = com.jtitor.plugin.gradle.rust.tasks.RustDoc

		//Add global tasks.
		project.task('rustBuildTop', type:RustBuild) {
			description "Builds the project through Cargo."
			group "rust-plugin"
		}
	
		project.task('rustRunTop', type:RustRun) {
			description "Runs the project through Cargo."
			group "rust-plugin"
		}

		project.task('rustTestTop', type:RustTest) {
			description "Tests the project through Cargo."
			group "rust-plugin"
		}
	}
}