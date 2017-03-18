package com.jtitor.plugin.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.jtitor.plugin.gradle.rust.tasks.RustBuild
import com.jtitor.plugin.gradle.rust.tasks.RustRun
import com.jtitor.plugin.gradle.rust.tasks.RustTest

/**
 * Created by ariel on 17/05/15.
 */
class RustPlugin implements Plugin<Project> {
	@Override
	void apply(Project project) {
		//Add global tasks.
		project.task('rustBuildTop', type:RustBuild) {
			description "Builds the project."
			group "project-global"
		}
	
		project.task('rustRunTop', type:RustRun) {
			description "Runs the project."
			group "project-global"
		}

		project.task('rustTestTop', type:RustTest) {
			description "Tests the project."
			group "project-global"
		}
	}
}