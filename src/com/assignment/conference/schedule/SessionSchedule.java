/**
 * 
 */
package com.assignment.conference.schedule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import com.assignment.conference.util.ConferenceUtil;
import com.assignment.conference.event.IEvent;
import com.assignment.conference.factory.SessionFactory;
import com.assignment.conference.pojo.EventPojo;
import com.assignment.conference.time.Session;
import com.assignment.conference.time.Time;

/**
 * @author vipul
 *
 */
public class SessionSchedule {

	private final static Map<IEvent, IEvent> alreadyVisited = new HashMap<>();

	final static Stack<EventPojo> stack = new Stack<>();

	private static Integer startIndex = 0;

	private static Integer endIndex;

	/**
	 * 
	 */
	public SessionSchedule() {
	}

	/**
	 * 
	 * @param track
	 * @param events
	 * @return
	 */
	public static Session scheduleSession(List<IEvent> events) {

		final Session session = SessionFactory.getSessionInstance();

		final Integer length = events.size();

		startIndex = 0;

		endIndex = length - 1;

		while (session.getDuration().getTime() > 0) {

			// Search From End
			while (session.getDuration().getTime() > 0) {

				if (processIteration(endIndex, session, events)) {
					break;
				}
				endIndex--;

				if (endIndex < 0) {
					break;
				}
			}

			// Search From Start
			while (session.getDuration().getTime() > 0) {

				if (processIteration(startIndex, session, events)) {
					break;
				}
				startIndex++;

				if (startIndex > (length - 1)) {
					break;
				}
			}

			final Integer sessionRemainingTime = session.getDuration().getTime();

			startIndex++;

			if (startIndex > (length - 1)) {
				stack.clear();
				break;
			}

			final Integer nextEventDuration = events.get(startIndex).getTalk().getDuration().getTime();

			if (sessionRemainingTime == 0 || nextEventDuration > sessionRemainingTime) {
				stack.clear();
				break;
			}
			startIndex--;

		}
		return session;

	}

	/**
	 * 
	 * @param index
	 * @param session
	 * @param events
	 */
	public static Boolean processIteration(Integer index, Session session, List<IEvent> events) {

		boolean success = false;

		IEvent event = events.get(index);

		if (event.getCommomBehaviour().isCommon()) {
			return success;
		}

		if (alreadyVisited.get(event) == null) {
			event = getNextEvent(event, session, events);
		} else {
			return success;
		}

		if (event.getTalk().getStartTime() != null) {

			if (checkIfEventRightChoice(session, event, events)) {
				addEventToSession(session, event);
				alreadyVisited.put(event, event);
				success = true;
			}
		}
		return success;
	}

	/**
	 * 
	 * @param index
	 * @param session
	 * @param events
	 * @return
	 */
	public static IEvent getNextEvent(IEvent event, Session session, List<IEvent> events) {

		final Integer eventDuration = event.getTalk().getDuration().getTime();

		final Integer sessionDuration = session.getDuration().getTime();

		if (eventDuration <= sessionDuration && !event.getCommomBehaviour().isCommon()) {

			Time eventStartTime = null;

			if (session.getEvents().size() == 0) {
				eventStartTime = session.getStartTime();
			} else {
				int size = session.getEvents().size();
				eventStartTime = session.getEvents().get(size - 1).getTalk().getEndTime();
			}
			event.getTalk().setStartTime(eventStartTime);

			Time eventEndTime = ConferenceUtil.addTime(event.getTalk().getStartTime(), event.getTalk().getDuration());

			event.getTalk().setEndTime(eventEndTime);
		}
		return event;
	}

	/**
	 * 
	 * @param index
	 * @param session
	 * @param events
	 * @return
	 */
	public static boolean checkIfEventRightChoice(Session session, IEvent event, List<IEvent> events) {

		boolean isValid = false;

		final Integer sessionRemainingTime = ConferenceUtil.getTimeDifference(session.getDuration().getTime(),
				event.getTalk().getDuration().getTime());

		int originalIndex = 0;
		Integer nextEventDuration = 0;

		for (originalIndex = startIndex; originalIndex < events.size(); originalIndex++) {
			originalIndex++;

			if (!events.get(startIndex).getCommomBehaviour().isCommon()
					&& alreadyVisited.get(events.get(startIndex)) == null) {
				nextEventDuration = events.get(startIndex).getTalk().getDuration().getTime();
			}
		}

		if (sessionRemainingTime > 0 && nextEventDuration > 0 && nextEventDuration > sessionRemainingTime) {

			if (!stack.isEmpty()) {

				final EventPojo eventPojo = stack.pop();

				if (eventPojo.getSessionRemainingTime() >= sessionRemainingTime) {
					isValid = true;
					stack.push(new EventPojo(event, sessionRemainingTime));
				}
			} else {
				stack.push(new EventPojo(event, sessionRemainingTime));
			}
		} else {
			isValid = true;
		}

		return isValid;

	}

	/**
	 * 
	 * @param index
	 * @param session
	 * @param events
	 * @return
	 */
	public static void addEventToSession(Session session, IEvent event) {

		session.getEvents().add(event);

		final Integer sessionRemainingTime = ConferenceUtil.getTimeDifference(session.getDuration().getTime(),
				event.getTalk().getDuration().getTime());

		session.getDuration().setTime(sessionRemainingTime);
	}

}
