# selenium-maven-allure-example
Basic framework for a selenium-maven-allure combination.

### Project Setup

![Allure Report Overview](allure-tools/allure_report_overview.png?raw=true "Allure Report Overview")
![Allure Report Detail](allure-tools/allure_report_details.png?raw=true "Allure Report Detail")

### Requirements
1. Java 8
2. Maven

#### Eclipse
1. Import as an existing Maven project.
2. Install the TestNG Plugin.
3. Optional: If you want to run tests from within Eclipse and want the annotation features to work then you need to add a java agent for AspectJ Weaver to your JVM so that it can watch for the annotations.
	1. Go to Eclipse *Preferences*
	2. Go to *Java*
	3. Go to *Installed JREs*
	4. Click on the version of Java 8 that you are using
	5. Click *Edit*
	6. Add `-javaagent:allure-tools/aspectjweaver-1.8.3.jar` to your Default JVM arguments

### Run Example
From command line: `$ mvn clean test`

From Eclipse: Right click on the test .java file > Run As > TestNG Test

