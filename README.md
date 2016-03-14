# selenium-maven-allure-example

### Allure Report GIF
![Allure Report Demo](allure-tools/allure_demo.gif?raw=true "Allure Report Demo")

### Allure Report Detail View Screenshot
![Allure Report Detail](allure-tools/allure_report_details.png?raw=true "Allure Report Detail")

### Code Samples
```java
@Features("Jimmy's feature")
public class ExampleTest {
	@Stories("Jimmy's full example")
	@Test(description = "Combine all examples.")
	public void testFullExample() {
		new CoreWebDiver().addStep("Produce amazing things")
		                  .recordScreenshot("During Test example.")
		                  .recordDataFile("During test data file", "{ More Data }");
	}
}
```
[Full code sample.](src/test/java/com/bdh/automation/ExampleTest.java)

### System Requirements
1. Java 8 
	*This could technically be down graded to Java 7 but would require some adjustments*
2. Maven

### Eclipse
1. Import as an existing Maven project.
2. Install the TestNG Plugin.
3. Optional: If you want to run tests from within Eclipse and want the annotation features to work then you need to add a java agent for AspectJ Weaver to your JVM so that it can watch for the annotations.
	1. Go to Eclipse *Preferences*
	2. Go to *Java*
	3. Go to *Installed JREs*
	4. Click on the version of Java 8 that you are using
	5. Click *Edit*
	6. Add `-javaagent:allure-tools/aspectjweaver-1.8.3.jar` to your Default JVM arguments

### Run Demo Example
From command line: `$ mvn clean test`

From Eclipse: Right click on the test .java file > Run As > TestNG Test

### Library References

| Library       | About |
| ------------- | ------|
| [Selenium](http://www.seleniumhq.org/)     | UI Browser Automation     |
| [Allure](http://allure.qatools.ru/)        | Fancy Test Result Reports |
| [TestNG](http://testng.org/doc/index.html) | Test Suite Management     |

