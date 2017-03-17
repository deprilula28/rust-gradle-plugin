package com.jtitor.plugin.gradle.test

import spock.lang.Specification
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder

class TestBase extends Specification {
	Project dummyProject;

	public void setup()
	{
		dummyProject = ProjectBuilder.builder().build()
		dummyProject.pluginManager.apply 'com.jtitor.rust'
	}
}