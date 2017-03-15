package com.jtitor.plugin.gradle.rust.tasks

import com.jtitor.plugin.gradle.rust.tasks.TaskBase

/**
Base class for tasks that call out to Cargo.
*/
class CargoTask extends TaskBase {

	/**
	Adds even more verbose output than the verbose flag.
	If true, this will call Cargo with the -vv flag,
	overriding the value given by verbose.
	*/
	@Input
	Boolean veryVerbose = false

	/**
	Requires that Cargo.lock and the cache are up to date.
	If true, this will call Cargo with the --frozen flag.
	*/
	@Input
	Boolean frozen = false

	/**
	Requires that only Cargo.lock is up to date.
	If true, this will call Cargo with the --locked flag.
	*/
	@Input
	Boolean locked = false

	/**
	Generates/cleans release artifacts; these will have optimizations that aren't applied by default.
	If true, this will call Cargo with the --release flag.
	*/
	@Input
	Boolean release = false

	/**
	Specifies what package to operate on.
	If the value is not empty, this will call Cargo with the --package (package) flag.
	*/
	@Input
	String package = ""

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
	Generates the Cargo string corresponding to the given action,
	with flags set to the task's values.
	*/	
	String invocationForCargoAction(String actionName) {
		String result = "cargo " + actionName
		if(veryVerbose) {
			result += " -vv"
		}
		else if (verbose) {
			result += " --verbose"
		}
		if(frozen) {
			result += " --frozen"
		}
		if(locked) {
			result += " --locked"
		}
	}

	void applyManifest() {
		manifest.attributes("Verbose" : verbose)
	}
}