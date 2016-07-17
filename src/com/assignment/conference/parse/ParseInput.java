/**
 * 
 */
package com.assignment.conference.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.assignment.conference.constants.Constants;
import com.assignment.conference.enums.TimeMeasureEnum;

/**
 * @author vipul
 *
 */
public class ParseInput {

	public static Map<String, StringBuilder> parseInputDataFile(BufferedReader filePathReader, String inputPattern)
			throws IOException {

		final Pattern pattern = Pattern.compile(inputPattern);

		Map<String, StringBuilder> inputData = new HashMap<>();

		try {
			String line = Constants.EMPTY_STRING;

			while ((line = filePathReader.readLine()) != null) {

				final int lastSpaceindex = line.lastIndexOf(Constants.SPACE);

				final Matcher matcher = pattern.matcher(line.substring(lastSpaceindex + 1));

				final List<String> matcherGroup = new LinkedList<>();

				while (matcher.find()) {
					matcherGroup.add(matcher.group());
				}

				final StringBuilder value = new StringBuilder();

				if (matcherGroup.size() > 0) {
					value.append(matcherGroup.get(0)).append(Constants.SPACE).append(matcherGroup.get(1));

				} else if (line.substring(lastSpaceindex + 1).equalsIgnoreCase(TimeMeasureEnum.LIGHTNING.name())) {
					value.append(line.substring(lastSpaceindex + 1));
				} else {
					value.append(0).append(Constants.SPACE).append(line.substring(lastSpaceindex + 1));
				}
				inputData.put(line.substring(0, lastSpaceindex), value);
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			filePathReader.close();
		}
		return inputData;
	}

	/**
	 * 
	 * @param text
	 * @param inputPattern
	 * @return
	 */
	public static StringBuilder parseInputTimeString(String text, String inputPattern) {

		final Pattern pattern = Pattern.compile(inputPattern);

		final Matcher matcher = pattern.matcher(text);

		final List<String> matcherGroup = new LinkedList<>();

		while (matcher.find()) {
			matcherGroup.add(matcher.group());
		}

		final StringBuilder value = new StringBuilder();

		if (matcherGroup.size() > 0) {
			value.append(matcherGroup.get(0)).append(Constants.SPACE).append(matcherGroup.get(1));
		}
		return value;
	}

}
