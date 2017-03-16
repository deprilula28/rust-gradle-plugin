package com.jtitor.plugin.gradle.test

import com.jtitor.plugin.gradle.test.TestBase

/**
Runs cargo test on the given project.
*/
class RustTestTest extends TestBase {
	//TODO
	@Test
	public void runTest() {
		//Test that the default invocation
		//matches "cargo test".
		assertTrue(true)
	}
}