/**
 * 
 */
package com.assignment.conference.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.assignment.conference.util.ConferenceUtil;
import com.assignment.conference.constants.Constants;
import com.assignment.conference.duration.Duration;
import com.assignment.conference.enums.TimeMeasureEnum;
import com.assignment.conference.event.Event;
import com.assignment.conference.event.IEvent;
import com.assignment.conference.event.Talk;
import com.assignment.conference.parse.ParseInput;
import com.assignment.conference.behaviour.IStartTimeBehaviour;
import com.assignment.conference.behaviour.IStartTimeMinMaxBehaviour;
import com.assignment.conference.time.Time;

/**
 * @author vipul
 *
 */
public class EventFactory {

	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public static IEvent getEventInstance(String key, String value) {

		final Event event = new Event();

		final String[] values = value.split(Constants.SPACE);

		Duration duration = null;

		if (values.length > 1) {
			duration = DurationFactory.getDurationInstance(values[0], values[1]);
		} else if (values.length == 1) {
			duration = DurationFactory.getDurationInstance(values[0]);
		}

		final Talk talk = new Talk(key, duration);
		event.setTalk(talk);

		event.setDurationBehaviour(DurationBehaviourFactory.getDurationBehaviour(duration));

		final IStartTimeBehaviour startTimeBehaviour = StartTimeBehaviourFactory.getStartTimeBehaviour(null);
		event.setStartTimeBehaviour(startTimeBehaviour);

		final IStartTimeMinMaxBehaviour startTimeMinMaxBehaviour = StartTimeMinMaxBehaviourFactory
				.getStartTimeMinMaxBehaviour(startTimeBehaviour, null, null);
		event.setStartTimeMinMaxBehaviour(startTimeMinMaxBehaviour);

		event.setCommomBehaviour(
				CommomBehaviourFactory.getCommomBehaviour(startTimeBehaviour, startTimeMinMaxBehaviour));

		return event;
	}

	/**
	 * 
	 * @param details
	 * @return
	 */
	public static List<IEvent> getEventInstanceForFixedEvent(Map<String, List<String>> details) {

		final List<IEvent> events = new ArrayList<>();

		for (Entry<String, List<String>> detail : details.entrySet()) {

			final Event event = new Event();

			final StringBuilder durationString = ParseInput.parseInputTimeString(detail.getValue().get(1),
					Constants.DURATION_TIME_PATTERN);

			final String[] values = durationString.toString().split(Constants.SPACE);

			final Duration duration = DurationFactory.getDurationInstance(values[0], values[1]);

			final Talk talk = new Talk(detail.getKey(), duration);

			talk.setStartTime(TimeFactory.getTimeInstance(detail.getValue().get(0)));

			final Time eventEndTime = ConferenceUtil.addTime(talk.getStartTime(), talk.getDuration());

			talk.setEndTime(eventEndTime);

			event.setTalk(talk);

			event.setDurationBehaviour(DurationBehaviourFactory.getDurationBehaviour(duration));

			final IStartTimeBehaviour startTimeBehaviour = StartTimeBehaviourFactory
					.getStartTimeBehaviour(detail.getValue().get(0));

			event.setStartTimeBehaviour(startTimeBehaviour);

			final IStartTimeMinMaxBehaviour startTimeMinMaxBehaviour = StartTimeMinMaxBehaviourFactory
					.getStartTimeMinMaxBehaviour(startTimeBehaviour, null, null);

			event.setStartTimeMinMaxBehaviour(startTimeMinMaxBehaviour);

			event.setCommomBehaviour(
					CommomBehaviourFactory.getCommomBehaviour(startTimeBehaviour, startTimeMinMaxBehaviour));

			events.add(event);
		}
		return events;

	}

	/**
	 * 
	 * @param details
	 * @return
	 */
	public static List<IEvent> getEventInstanceForFlexibleEvent(Map<String, List<String>> details) {

		final List<IEvent> events = new ArrayList<>();

		for (Entry<String, List<String>> detail : details.entrySet()) {

			final Event event = new Event();

			final Duration duration = DurationFactory.getDurationInstance(Integer.MAX_VALUE, TimeMeasureEnum.MIN);

			final Talk talk = new Talk(detail.getKey(), duration);
			event.setTalk(talk);

			event.setDurationBehaviour(DurationBehaviourFactory.getDurationBehaviour(null));

			final IStartTimeBehaviour startTimeBehaviour = StartTimeBehaviourFactory.getStartTimeBehaviour(null);
			event.setStartTimeBehaviour(startTimeBehaviour);

			final IStartTimeMinMaxBehaviour startTimeMinMaxBehaviour = StartTimeMinMaxBehaviourFactory
					.getStartTimeMinMaxBehaviour(startTimeBehaviour, detail.getValue().get(0),
							detail.getValue().get(1));

			event.setStartTimeMinMaxBehaviour(startTimeMinMaxBehaviour);
			event.setCommomBehaviour(
					CommomBehaviourFactory.getCommomBehaviour(startTimeBehaviour, startTimeMinMaxBehaviour));

			events.add(event);
		}
		return events;
	}

}
