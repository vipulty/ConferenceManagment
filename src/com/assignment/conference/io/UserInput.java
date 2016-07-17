package com.assignment.conference.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.assignment.conference.constants.Constants;

/**
 * 
 * @author vipul
 *
 */
public class UserInput {

	/**
	 * @throws FileNotFoundException
	 * 
	 */
	public String getFilePathFromUser() throws FileNotFoundException {

		final Scanner scanner = new Scanner(System.in);
		System.out.println("Enter File path for Talks details : ");

		final String filePath = scanner.next();

		return filePath;
	}

	/**
	 * 
	 * @param filePath
	 * @throws FileNotFoundException
	 */
	public BufferedReader getBufferedReader(String filePath) throws FileNotFoundException {

		BufferedReader filePathReader = null;

		try {
			filePathReader = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getStackTrace());
			throw ex;
		}
		return filePathReader;
	}

	/**
	 * 
	 */
	public Map<String, List<String>> getFixedEventDetails() {

		final Map<String, List<String>> details = new HashMap<>();

		final List<String> timedetails = new LinkedList<>();

		timedetails.add(Constants.LUNCH_START_TIME);

		timedetails.add(Constants.LUNCH_DURATION);

		details.put(Constants.LUNCH, timedetails);

		return details;

	}

	/**
	 * 
	 * @return
	 */
	public Map<String, List<String>> getOtherEventDetails() {

		final Map<String, List<String>> details = new HashMap<>();

		final List<String> timedetails = new LinkedList<>();

		timedetails.add(Constants.NETWORING_EVENT_MIN_START_TIME);

		timedetails.add(Constants.NETWORING_EVENT_MAX_START_TIME);

		details.put(Constants.NETWORING_EVENT, timedetails);

		return details;
	}
}
