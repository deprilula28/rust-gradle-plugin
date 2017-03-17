package com.jtitor.plugin.gradle.test

import groovy.util.logging.Slf4j
import com.jtitor.plugin.gradle.test.TestBase
import com.jtitor.plugin.gradle.rust.tasks.RustRun

@Slf4j
class RustRunTest extends TestBase {
	String expectedDefaultInvocation = "cargo run"

	//TODO
	def "Test RustRun functionality"() {
		setup:
		def taskInstance = dummyProject.task("rustRun", type:RustRun)

		when:
		def actualDefaultInvocation = taskInstance.invocationForAction()

		then:
		//Test that the default invocation
		//matches "cargo run".
		actualDefaultInvocation == expectedDefaultInvocation
	}
}