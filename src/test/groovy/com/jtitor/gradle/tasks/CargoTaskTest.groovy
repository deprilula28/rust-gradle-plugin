package com.jtitor.plugin.gradle.test

import groovy.util.logging.Slf4j
import com.jtitor.plugin.gradle.test.TestBase
import com.jtitor.plugin.gradle.rust.tasks.CargoTask

/**
Dummy implementation of CargoTask,
for checking flag behaviors.
*/
public class DummyCargoTask extends CargoTask {
	String actionName() { return "DUMMY" }
}

/**
Base class for tasks that call out to Cargo.
*/
@Slf4j
class CargoTaskTest extends TestBase {
	//If all inputs are set to true/an existent value,
	//the invocation string should contain these flags.
	def allSetFlags = [CargoTask.FLAG_VERY_VERBOSE, CargoTask.FLAG_QUIET, CargoTask.FLAG_FROZEN, 
	CargoTask.FLAG_LOCKED, CargoTask.FLAG_RELEASE,
	CargoTask.FLAG_PACKAGE, CargoTask.FLAG_TARGET,
	CargoTask.FLAG_MANIFEST_PATH]

	private void setAllFlagsOnTask(DummyCargoTask task) {
		task.verbose = true
		task.veryVerbose = true
		task.quiet = true
		task.frozen = true
		task.locked = true
		task.release = true
		task.cargoPackage = "DUMMY_PACKAGE"
		task.target = "DUMMY_TARGET"
		task.manifestPath = "DUMMY_MANIFEST_PATH"
	}

	/**
	Test that CargoTask implementations generate invocation 
	strings that match their flags.
	*/
	def "Test CargoTask flag functionality"() {
		setup:
		def taskInstance = dummyProject.task("rustTest", type:DummyCargoTask)

		when:
		def actualDefaultInvocation = taskInstance.invocationForAction()
		
		//Also get it with all flags set.
		setAllFlagsOnTask(taskInstance)
		def actualAllSetInvocation = taskInstance.invocationForAction()

		log.info("Default invocation: " + actualDefaultInvocation)
		log.info("All-set invocation: " + actualAllSetInvocation)

		then:
		//For each flag:
		allSetFlags.each { flag ->
			//The flag should be included in the all-set invocation
			actualAllSetInvocation.contains(flag)
			//and *not* included in the default invocation.
			!actualDefaultInvocation.contains(flag)
		}
	}

	/**
	Test that very verbose takes precedence
	over verbose mode when generating invocations.
	*/
	def "Test verbose flag precedence"() {
		setup:
		def taskInstance = dummyProject.task("rustTest", type:DummyCargoTask)

		when:
		def noneSet = taskInstance.invocationForAction()
		taskInstance.verbose = true
		def verboseSet = taskInstance.invocationForAction()
		taskInstance.veryVerbose = true
		def bothSet = taskInstance.invocationForAction()
		taskInstance.verbose = false
		def veryVerboseSet = taskInstance.invocationForAction()

		then:
		//noneSet should not have either flag.
		!(noneSet.contains(CargoTask.FLAG_VERBOSE) || noneSet.contains(CargoTask.FLAG_VERY_VERBOSE))

		//bothSet and veryVerboseSet should have
		//-vv but not --verbose.
		!bothSet.contains(CargoTask.FLAG_VERBOSE) && bothSet.contains(CargoTask.FLAG_VERY_VERBOSE)
		!veryVerboseSet.contains(CargoTask.FLAG_VERBOSE) && veryVerboseSet.contains(CargoTask.FLAG_VERY_VERBOSE)

		//verboseSet should have --verbose but not -vv.
		verboseSet.contains(CargoTask.FLAG_VERBOSE) && !verboseSet.contains(CargoTask.FLAG_VERY_VERBOSE)
	}
}