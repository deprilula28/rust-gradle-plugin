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
		def result = runWithTask("rustBuild")

		then:
		result.task(":rustBuild").outcome == TaskOutcome.SUCCESS
	}

	def "Test run functionality"() {
		when:
		def result = runWithTask("rustRun")

		then:
		result.output.contains("Rust works!")
		result.task(":rustRun").outcome == TaskOutcome.SUCCESS
	}

	//No unit tests are implemented on the dummy...
	def "Test test functionality"() {
		when:
		def result = runWithTask("rustTest")

		then:
		result.task(":rustTest").outcome == TaskOutcome.SUCCESS
	}

	//RustFormat isn't fully implemented yet.
	/*
	def "Test format functionality"() {
		when:
		def result = runWithTask("rustFormat")

		then:
		result.task(":rustFormat").outcome == TaskOutcome.SUCCESS
	}
	*/
}