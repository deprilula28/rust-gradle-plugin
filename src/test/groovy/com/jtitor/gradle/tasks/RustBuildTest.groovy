package com.jtitor.plugin.gradle.test

import groovy.util.logging.Slf4j
import com.jtitor.plugin.gradle.test.TestBase
import com.jtitor.plugin.gradle.rust.tasks.RustBuild

/**
Runs cargo build on the given project.
*/
@Slf4j
class RustBuildTest extends TestBase {
	String expectedDefaultInvocation = "cargo build"

	//TODO
	def "Test RustBuild functionality"() {
		setup:
		def taskInstance = new RustBuild()

		when:
		def actualDefaultInvocation = taskInstance.invocationForAction()

		then:
		//Test that the default invocation
		//matches "cargo build".
		actualDefaultInvocation == expectedDefaultInvocation
	}
}