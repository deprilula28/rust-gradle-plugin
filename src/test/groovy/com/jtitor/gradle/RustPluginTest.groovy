package com.jtitor.plugin.gradle.test

import org.gradle.testkit.runner.TaskOutcome
import org.gradle.testkit.runner.GradleRunner
import groovy.util.logging.Slf4j
import com.jtitor.plugin.gradle.test.TestBase

@Slf4j
class RustPluginTest extends TestBase {
	File testProjectDir

	def setup() {
		testProjectDir = new File("src/test/dummy-project")
	}

	def runWithTask(String taskName) {
		return GradleRunner.create()
		.withProjectDir(testProjectDir.getAbsoluteFile())
		.withArguments(taskName)
		.withPluginClasspath()
		.build()
	}
	
	def "Test build functionality"() {
		when:
		//Try to build a project using the tasks.
		def result = runWithTask("rustBuildTop")

		then:
		result.task(":rustBuildTop").outcome == TaskOutcome.SUCCESS
	}

	def "Test run functionality"() {
		when:
		def result = runWithTask("rustRunTop")

		then:
		result.output.contains("Rust works!")
		result.task(":rustRunTop").outcome == TaskOutcome.SUCCESS
	}

	//No unit tests are implemented on the dummy...
	def "Test test functionality"() {
		when:
		def result = runWithTask("rustTestTop")

		then:
		result.task(":rustTestTop").outcome == TaskOutcome.SUCCESS
	}

	//RustFormat isn't fully implemented yet.
	/*
	def "Test format functionality"() {
		when:
		def result = runWithTask("rustFormatTop")

		then:
		result.task(":rustFormatTop").outcome == TaskOutcome.SUCCESS
	}
	*/
}