package com.jtitor.plugin.gradle.rust.tasks

import org.gradle.api.tasks.TaskAction
import com.jtitor.plugin.gradle.rust.tasks.TaskBase

/**
Base class for tasks that call out to Cargo.
*/
abstract class CargoTask extends TaskBase {

	/**
	Adds even more verbose output than the verbose flag.
	If true, this will call Cargo with the -vv flag,
	overriding the value given by verbose.
	*/
	boolean veryVerbose = false

	/**
	Requires that Cargo.lock and the cache are up to date.
	If true, this will call Cargo with the --frozen flag.
	*/
	boolean frozen = false

	/**
	Requires that only Cargo.lock is up to date.
	If true, this will call Cargo with the --locked flag.
	*/
	boolean locked = false

	/**
	Generates/cleans release artifacts; these will have optimizations that aren't applied by default.
	If true, this will call Cargo with the --release flag.
	*/
	boolean release = false
	
	/**
	Specifies what package to operate on.
	If the value is not empty, this will call Cargo with the --package (package) flag.
	*/
	String cargoPackage = ""

	/**
	Specifies what target to operate on.
	If the value is not empty, this will call Cargo with the --target (target) flag.
	*/
	String target = ""

	/**
	Specifies the location of the target project's manifest.
	If the value is not empty, this will call Cargo with the --manifest-path (manifestPath) flag.
	*/
	String manifestPath = ""

	/**
	Returns the Cargo action this task represents,
	such as build, test, or bench.
	This should be lowercase.
	*/
	abstract String actionName()

	/**
	Generates the Cargo string corresponding to the given action,
	with flags set to the task's values.
	*/	
	String invocationForAction() {
		StringBuilder result = new StringBuilder("cargo ")
		result.append(actionName())
		if(veryVerbose) {
			result.append(" -vv")
		}
		else if (verbose) {
			result.append(" --verbose")
		}
		if (quiet) {
			result.append(" --quiet")
		}
		if(frozen) {
			result.append(" --frozen")
		}
		if(locked) {
			result.append(" --locked")
		}
		if(release) {
			result.append(" --release")
		}
		if(cargoPackage?.trim()) {
			result.append(" --package ")
			result.append(cargoPackage)
		}
		if(target?.trim()) {
			result.append(" --target ")
			result.append(target)
		}
		if(manifestPath?.trim()) {
			result.append(" --manifest-path ")
			result.append(manifestPath)
		}

		return result.toString()
	}

	/**
	Invokes Cargo task.
	*/
	@TaskAction
	void doCargoAction() {
		logTaskStart(actionName())
		//Do a cargo build.
		project.exec {
			commandLine invocationForAction()
		}
	}
}