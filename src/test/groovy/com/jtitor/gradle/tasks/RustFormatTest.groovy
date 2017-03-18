package com.jtitor.plugin.gradle.test

import groovy.util.logging.Slf4j
import com.jtitor.plugin.gradle.test.TestBase
import com.jtitor.plugin.gradle.rust.tasks.RustFormat

@Slf4j
class RustFormatTest extends TestBase {
	def expectedDefaultInvocation = ["cargo", "fmt"]

	//TODO
	def "Test RustFormat functionality"() {
		setup:
		def taskInstance = dummyProject.task("rustFormat", type:RustFormat)

		when:
		def actualDefaultInvocation = taskInstance.invocationForAction()

		then:
		//Test that the default invocation
		//matches "cargo fmt".
		actualDefaultInvocation == expectedDefaultInvocation
	}
}