package com.jtitor.plugin.gradle.test

import groovy.util.logging.Slf4j
import com.jtitor.plugin.gradle.test.TestBase
import com.jtitor.plugin.gradle.rust.tasks.RustTest

@Slf4j
class RustTestTest extends TestBase {
	String expectedDefaultInvocation = "cargo test"

	//TODO
	def "Test RustTest functionality"() {
		setup:
		def taskInstance = new RustTest()

		when:
		def actualDefaultInvocation = taskInstance.invocationForAction()

		then:
		//Test that the default invocation
		//matches "cargo test".
		actualDefaultInvocation == expectedDefaultInvocation
	}
}