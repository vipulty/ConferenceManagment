/**
 * 
 */
package com.assignment.conference.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.assignment.conference.constants.Constants;
import com.assignment.conference.event.IEvent;
import com.assignment.conference.factory.EventFactory;
import com.assignment.conference.io.UserInput;
import com.assignment.conference.manager.ConferenceTrackManager;
import com.assignment.conference.parse.ParseInput;
import com.assignment.conference.time.Track;

/**
 * @author vipul
 *
 */
public class ConferenceTrackMain {

	private static UserInput userInput = new UserInput();

	/**
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException {

		final String filePath = userInput.getFilePathFromUser();

		BufferedReader filePathReader = null;

		if (filePath != null || filePath.equals(Constants.EMPTY_STRING)) {
			filePathReader = getBufferedReader(filePath);
		}

		if (filePathReader != null) {
			scheduleConferenceEvents(filePathReader);
		} else {
			System.out.println("FilePathReader is null. Exiting....");
		}
	}

	/**
	 * 
	 * @param filePath
	 * @return
	 * @throws FileNotFoundException
	 */
	public static BufferedReader getBufferedReader(String filePath) throws FileNotFoundException {

		final BufferedReader filePathReader = userInput.getBufferedReader(filePath);

		return filePathReader;
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public static List<Track> scheduleConferenceEvents(BufferedReader filePathReader) throws IOException {

		try {
			List<Track> tracks = new LinkedList<>();

			if (filePathReader != null) {

				final Map<String, StringBuilder> parseInputData = ParseInput.parseInputDataFile(filePathReader,
						Constants.DURATION_TIME_PATTERN);

				final List<IEvent> events = new ArrayList<>();

				for (Entry<String, StringBuilder> inputData : parseInputData.entrySet()) {

					final IEvent event = EventFactory.getEventInstance(inputData.getKey(),
							inputData.getValue().toString());
					events.add(event);
				}

				events.addAll(EventFactory.getEventInstanceForFixedEvent(userInput.getFixedEventDetails()));

				events.addAll(EventFactory.getEventInstanceForFlexibleEvent(userInput.getOtherEventDetails()));

				Collections.sort(events);

				tracks = ConferenceTrackManager.scheduleConference(events);

				for (Track track : tracks) {
					 System.out.println(track);
				}
				return tracks;
			}
		} catch (IOException e) {
			System.out.println("Error while parsing file");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			throw e;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			throw e;
		}
		return null;
	}

}
