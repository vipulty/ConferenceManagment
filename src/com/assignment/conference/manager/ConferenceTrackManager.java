/**
 * 
 */
package com.assignment.conference.manager;

import java.util.List;

import com.assignment.conference.event.IEvent;

import com.assignment.conference.schedule.TrackSchedule;
import com.assignment.conference.time.Track;

/**
 * @author vipul
 *
 */
public class ConferenceTrackManager {

	/**
	 * 
	 * @param events
	 */
	public static List<Track> scheduleConference(List<IEvent> events) {

		final List<Track> tracks = TrackSchedule.scheduleTrack(events);

		return tracks;
	}
}
