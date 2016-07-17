package com.assignment.conference.time;

import java.util.LinkedList;
import java.util.List;

import com.assignment.conference.util.ConferenceUtil;
import com.assignment.conference.constants.Constants;
import com.assignment.conference.duration.Duration;

import com.assignment.conference.event.IEvent;

public class Session {

	private Integer number;

	private Time startTime;

	private Time endTime;

	private Duration duration;

	private List<IEvent> events = new LinkedList<>();

	public Session(Integer number, Time startTime, Time endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.number = number;

		this.duration = ConferenceUtil.getTimeDifference(startTime, endTime);
	}

	/**
	 * @return the startTime
	 */
	public Time getStartTime() {
		return startTime;
	}

	/**
	 * @return the endTime
	 */
	public Time getEndTime() {
		return endTime;
	}

	/**
	 * @return the duration
	 */
	public Duration getDuration() {
		return duration;
	}

	/**
	 * @return the events
	 */
	public List<IEvent> getEvents() {
		return events;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	/**
	 * @param events
	 *            the events to set
	 */
	public void setEvents(List<IEvent> events) {
		this.events = events;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		final StringBuilder output = new StringBuilder();

		for (IEvent event : events) {
			output.append(event.toString()).append(Constants.NEWLINE);
		}
		return output.toString();
	}
}
