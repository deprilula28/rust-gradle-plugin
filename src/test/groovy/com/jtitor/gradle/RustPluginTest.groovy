class RustPluginTest {
	private Project buildDefaultProject()
	{
		Project project = ProjectBuilder.builder().build()
		project.pluginManager.apply 'org.jtitor.rust'
		return project
	}
	
	/*!
	An example unit test.
	*/
	@Test
	public void exampleTest() {
		assertTrue(true)
	}

	//Test individual task types...
	
	/*!
	Tests the build task type.
	*/
	@Test
	public void testBuild() {
		Project project = buildDefaultProject()
		//Check that parameters exist.
		//Run build task.
		//Check that nonzero error code throws an exception.
		assertTrue(true)
	}

	/*!
	Tests the test task type.
	*/
	@Test
	public void testTest() {
		Project project = buildDefaultProject()
		//Check that parameters exist.
		//Run test task.
		//Check that nonzero error code throws an exception.
		assertTrue(true)
	}

	/*!
	Tests the format task type.
	*/
	@Test
	public void testFormat() {
		Project project = buildDefaultProject()
		//Check that parameters exist.
		//Run format task.
		//Check that nonzero error code throws an exception.
		assertTrue(true)
	}

	/*!
	Tests the run task type.
	*/
	@Test
	public void testRun() {
		Project project = buildDefaultProject()
		//Check that parameters exist.
		//Run run task.
		//Check that nonzero error code throws an exception.
		assertTrue(true)
	}

	//Optional tasks...
}