package com.jtitor.plugin.gradle.test

import groovy.util.logging.Slf4j
import com.jtitor.plugin.gradle.test.TestBase
import com.jtitor.plugin.gradle.rust.tasks.RustDoc

/**
Runs cargo doc on the given project.
*/
@Slf4j
class RustDocTest extends TestBase {
	def expectedDefaultInvocation = ["cargo", "doc"]

	//TODO
	def "Test RustDoc functionality"() {
		setup:
		def taskInstance = dummyProject.task("RustDoc", type:RustDoc)

		when:
		def actualDefaultInvocation = taskInstance.invocationForAction()

		then:
		//Test that the default invocation
		//matches "cargo doc".
		actualDefaultInvocation == expectedDefaultInvocation
	}
}