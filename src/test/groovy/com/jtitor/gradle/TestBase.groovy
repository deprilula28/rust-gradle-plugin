package com.jtitor.plugin.gradle.test

import spock.lang.Specification

class TestBase extends Specification {
	Project buildDefaultProject()
	{
		Project project = ProjectBuilder.builder().build()
		project.pluginManager.apply 'org.jtitor.rust'
		return project
	}
}