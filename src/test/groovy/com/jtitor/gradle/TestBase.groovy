package com.jtitor.plugin.gradle.test

class TestBase {
	Project buildDefaultProject()
	{
		Project project = ProjectBuilder.builder().build()
		project.pluginManager.apply 'org.jtitor.rust'
		return project
	}
}