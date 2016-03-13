package com.bdh.automation;

import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.SystemUtils;

public enum AllureCommand {

	GENERATE("generate"),

	OPEN("report open"),

	CLEAN("report clean ");

	private String command;
	private static final String TOOL_PATH = "/usr/local/bin/allure";
	private static final String RESULTS_DATA_PATH = "target/allure-results";
	private static final String CONSOLE_HORIZONTAL_LINE = "----------------------------------------------------------------------------------";
	private static final String MAKE_DIRECTORY = SystemUtils.IS_OS_MAC ? "mkdir " : "TODO: find pc command";
	private static final String REMOVE_DIRECTORY = SystemUtils.IS_OS_MAC ? "rm -rf  " : "TODO: find pc command";

	AllureCommand(String command) {
		this.command = TOOL_PATH + " " + command + " ";
	}

	public void run() {
		switch (this) {
		case GENERATE:
			executeCommandLine(command + RESULTS_DATA_PATH);
			break;
		case OPEN:
			executeCommandLine(command);
			break;
		case CLEAN:
			executeCommandLine(command);
			executeCommandLine(REMOVE_DIRECTORY + RESULTS_DATA_PATH);
			executeCommandLine(MAKE_DIRECTORY + RESULTS_DATA_PATH);
			break;
		}
	}

	private void executeCommandLine(String command) {
		try (Scanner output = new Scanner(Runtime.getRuntime().exec(command).getInputStream())) {
			output.useDelimiter("\\A");
			System.out.println(CONSOLE_HORIZONTAL_LINE);
			System.out.println("Running Command: $ " + command);
			System.out.println(output.hasNext() ? output.next() : "");
			System.out.println(CONSOLE_HORIZONTAL_LINE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
