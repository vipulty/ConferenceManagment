package com.assignment.conference.schedule;

import java.util.LinkedList;
import java.util.List;

import com.assignment.conference.event.Event;
import com.assignment.conference.event.IEvent;
import com.assignment.conference.event.Talk;
import com.assignment.conference.factory.TrackFactory;
import com.assignment.conference.time.Session;
import com.assignment.conference.time.Time;
import com.assignment.conference.time.Track;

public class TrackSchedule {

	private static List<Track> tracks = new LinkedList<>();

	public TrackSchedule() {
	}

	public static List<Track> scheduleTrack(List<IEvent> events) {

		while (true) {

			Track track = TrackFactory.getTrackInstance();

			while (track.getSessions().size() < 2) {

				final Session session = SessionSchedule.scheduleSession(events);

				if (session.getNumber() % 2 != 0) {

					for (IEvent event : events) {

						if (event.getCommomBehaviour().isCommon() && event.getDurationBehaviour().isDurationFix()
								&& event.getStartTimeBehaviour().isStartTimeFix()) {

							session.getEvents().add(event);
						}
					}
				} else {
					addFixedEvent(session, events);
				}
				track.getSessions().add(session);

				Boolean isFinished = true;

				for (IEvent event : events) {
					if (event.getTalk().getStartTime() == null && !event.getCommomBehaviour().isCommon()) {
						isFinished = false;
						break;
					}
				}

				if (isFinished) {
					break;
				}
			}

			if (track.getSessions().size() == 1) {
				final Session session = SessionSchedule.scheduleSession(events);

				addFixedEvent(session, events);
				track.getSessions().add(session);
			}

			tracks.add(track);

			Boolean isFinished = true;

			for (IEvent event : events) {
				if (event.getTalk().getStartTime() == null && !event.getCommomBehaviour().isCommon()) {
					isFinished = false;
					break;
				}
			}

			if (isFinished) {
				break;
			}
		}
		return tracks;
	}

	/**
	 * 
	 * @param session
	 * @param events
	 */
	private static void addFixedEvent(Session session, List<IEvent> events) {

		final Integer length = session.getEvents().size();

		IEvent lastEvent = null;

		if (length > 0) {
			lastEvent = session.getEvents().get(length - 1);
		}

		for (IEvent event : events) {
			if (event.getCommomBehaviour().isCommon() && !event.getDurationBehaviour().isDurationFix()
					&& !event.getStartTimeBehaviour().isStartTimeFix()) {

				Time startTime = null;

				if (lastEvent != null) {
					startTime = lastEvent.getTalk().getEndTime();
				} else {
					startTime = event.getStartTimeMinMaxBehaviour().getMinStartTime();
				}

				if (lastEvent != null
						&& startTime.compareTo(event.getStartTimeMinMaxBehaviour().getMinStartTime()) < 0) {

					startTime = event.getStartTimeMinMaxBehaviour().getMinStartTime();
				}
				if (event.getTalk().getStartTime() != null) {
					final IEvent newEvent = new Event(event);
					newEvent.getTalk().setStartTime(startTime);
					session.getEvents().add(newEvent);
				} else {
					event.getTalk().setStartTime(startTime);
					session.getEvents().add(event);
				}

			}
		}
	}

}
