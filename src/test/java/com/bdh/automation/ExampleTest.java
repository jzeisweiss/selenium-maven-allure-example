package com.bdh.automation;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

@Features("Jimmy's feature")
public class ExampleTest {
	private CoreWebDiver driver;

	@BeforeSuite
	public void beforeSuite() {
		driver = new CoreWebDiver();
		AllureCommand.CLEAN.run();
		driver.startDriver();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.restStepCount();
	}

	@AfterSuite
	public void afterSuite() {
		driver.killDriver();
		AllureCommand.GENERATE.run();
		AllureCommand.OPEN.run();
	}

	@Stories("Jimmy's Individual Examples")
	@Test
	public void testStepExample() {
		driver	.addStep("Conquer the world")
				.addStep("Have fun")
				.addStep("Go Crazy");
	}

	@Stories("Jimmy's Individual Examples")
	@Test
	public void testScreenshotExample() {
		driver.recordScreenshot("During Test example.");
	}

	@Stories("Jimmy's Individual Examples")
	@Test
	public void testTextAttachmentExample() {
		driver.recordDataFile("During test data file", "{ Lots of Data }");
	}

	@Stories("Jimmy's Full Examples")
	@Test
	public void testFullExample() {
		driver	.addStep("Produce amazing things")
				.recordScreenshot("During Test example.")
				.recordDataFile("During test data file", "{ More Data }");
	}

}
