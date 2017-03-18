package com.jtitor.plugin.gradle.test

import groovy.util.logging.Slf4j
import com.jtitor.plugin.gradle.test.TestBase
import com.jtitor.plugin.gradle.rust.tasks.RustTest

@Slf4j
class RustTestTest extends TestBase {
	def expectedDefaultInvocation = ["cargo", "test"]

	//TODO
	def "Test RustTest functionality"() {
		setup:
		def taskInstance = dummyProject.task("rustTest", type:RustTest)

		when:
		def actualDefaultInvocation = taskInstance.invocationForAction()

		then:
		//Test that the default invocation
		//matches "cargo test".
		actualDefaultInvocation == expectedDefaultInvocation
	}
}