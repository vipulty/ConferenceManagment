package com.assignment.conference.factory;

import com.assignment.conference.time.Track;

public class TrackFactory {

	private static Integer trackNumber = 0;

	public TrackFactory() {	
	}

	/**
	 * 
	 * @return
	 */
	public static Track getTrackInstance() {
		trackNumber++;

		return new Track(trackNumber);
	}

}
