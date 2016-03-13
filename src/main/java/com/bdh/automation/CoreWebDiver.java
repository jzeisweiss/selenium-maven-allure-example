package com.bdh.automation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.ashot.AShot;

public class CoreWebDiver {

	private WebDriver driver;
	private int stepCount;

	public CoreWebDiver restStepCount() {
		stepCount = 0;
		return this;
	}

	private int increasedStepCount() {
		return ++stepCount;
	}

	/**
	 * Add a step to your test case with the count. The place holders, using the
	 * format {0}, correspond to the method arguments. You can also use @Step
	 * without a value and that will parse the method name and the method
	 * signature parameters & arguments.
	 * 
	 * @param description
	 *            of the step
	 */
	@Step("[#{0}] {1}")
	private CoreWebDiver addStep(int count, String description) {
		// Do nothing. You just need the annotation.
		return this;
	}

	/**
	 * Add a step to your test case with a count.
	 * 
	 * @param description
	 *            of the step
	 */
	public CoreWebDiver addStep(String description) {
		addStep(increasedStepCount(), description);
		return this;
	}

	public CoreWebDiver killDriver() {
		driver.quit();
		return this;
	}

	public CoreWebDiver recordDataFile(String about, String data) {
		recordDataFile(increasedStepCount(), about, data);
		return this;
	}

	@Attachment(value = "Text Attachment", type = "text/plain")
	@Step("[#{0}] Record a data file | About: {1}")
	private String recordDataFile(int stepCount, String about, String data) {
		return data;
	}

	/**
	 * Record a screenshot for the Allure report. This calls the private method
	 * {@link #recordScreenshot(int)} so that it can log it as a step and have
	 * the screenshot nested in the step. If you want to record a screenshot in
	 * a TestNG configuration method you need to override the TestNG listener.
	 * 
	 * @param about
	 *            the screenshot
	 */
	public CoreWebDiver recordScreenshot(String about) {
		recordScreenshot(increasedStepCount(), about);
		return this;
	}

	/**
	 * Record a screenshot for the Allure report. The return byte[] is needed to
	 * work with Allure's attachment listener.
	 * 
	 * @param stepCount
	 *            for report
	 * @param about
	 *            the screenshot
	 * @return the image
	 */

	@Attachment(value = "Page screenshot", type = "image/png")
	@Step("[#{0}] Record a screenshot | About: {1}")
	public byte[] recordScreenshot(int stepCount, String about) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(new AShot().takeScreenshot(driver).getImage(), "png", baos);
			return baos.toByteArray();
		} catch (IOException e) {
			throw new RuntimeException("Failed to record a screenshot");
		}
	}

	public CoreWebDiver startDriver() {
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		return this;
	}
}
