package com.jtitor.plugin.gradle.rust.tasks

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import com.jtitor.plugin.gradle.rust.tasks.TaskBase

/**
Base class for tasks that call out to Cargo.
*/
abstract class CargoTask extends TaskBase {
	//Define flag constants...
	public static final String FLAG_VERY_VERBOSE = "-vv"
	public static final String FLAG_VERBOSE = "--verbose"
	public static final String FLAG_QUIET = "--quiet"
	public static final String FLAG_FROZEN = "--frozen"
	public static final String FLAG_LOCKED = "--locked"
	public static final String FLAG_RELEASE = "--release"
	public static final String FLAG_PACKAGE = "--package"
	public static final String FLAG_TARGET = "--target"
	public static final String FLAG_MANIFEST_PATH = "--manifest-path"
	public static final String FLAG_NO_DEPS = "--no-deps"

	//Inputs here.
	/**
	Adds even more verbose output than the verbose flag.
	If true, this will call Cargo with the -vv flag,
	overriding the value given by verbose.
	*/
	@Input
	boolean veryVerbose = false

	/**
	Requires that Cargo.lock and the cache are up to date.
	If true, this will call Cargo with the --frozen flag.
	*/
	@Input
	boolean frozen = false

	/**
	Requires that only Cargo.lock is up to date.
	If true, this will call Cargo with the --locked flag.
	*/
	@Input
	boolean locked = false

	/**
	Generates/cleans release artifacts; these will have optimizations that aren't applied by default.
	If true, this will call Cargo with the --release flag.
	*/
	@Input
	boolean release = false
	
	/**
	Specifies what package to operate on.
	If the value is not empty, this will call Cargo with the --package (package) flag.
	*/
	@Input
	String cargoPackage = ""

	/**
	Specifies what target to operate on.
	If the value is not empty, this will call Cargo with the --target (target) flag.
	*/
	@Input
	String target = ""

	/**
	Specifies the location of the target project's manifest.
	If the value is not empty, this will call Cargo with the --manifest-path (manifestPath) flag.
	*/
	@Input
	String manifestPath = ""

	/**
	Decides if dependencies should also be processed.
	If true, this will call Cargo with the --no-deps flag.
	*/
	@Input
	boolean noDeps = false

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
	def invocationForAction() {
		def result = ["cargo"]
		result << actionName()
		if(veryVerbose) {
			result << FLAG_VERY_VERBOSE
		}
		else if (verbose) {
			result << FLAG_VERBOSE
		}
		if (quiet) {
			result << FLAG_QUIET
		}
		if(frozen) {
			result << FLAG_FROZEN
		}
		if(locked) {
			result << FLAG_LOCKED
		}
		if(release) {
			result << FLAG_RELEASE
		}
		if(cargoPackage?.trim()) {
			result << FLAG_PACKAGE
			result << cargoPackage
		}
		if(target?.trim()) {
			result << FLAG_TARGET
			result << target
		}
		if(manifestPath?.trim()) {
			result << FLAG_MANIFEST_PATH
			result << manifestPath
		}
		if(noDeps) {
			result << FLAG_NO_DEPS
		}

		return result
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