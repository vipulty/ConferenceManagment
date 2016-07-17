package com.assignment.conference.event;

import com.assignment.conference.duration.Duration;

import com.assignment.conference.time.Time;

public class Talk implements Comparable<Talk> {

	private String talkTitle;

	private Duration duration;

	private Time startTime;

	private Time endTime;

	/**
	 * @param talkTitle
	 * @param duration
	 */
	public Talk(String talkTitle, Duration duration) {
		super();
		this.talkTitle = talkTitle;
		this.duration = duration;
	}

	/**
	 * @param talkTitle
	 * @param duration
	 */
	public Talk(String talkTitle, Duration duration, Time startTime, Time endTime) {
		super();
		this.talkTitle = talkTitle;
		this.duration = duration;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
	public Talk(Talk talk){
		super();
		this.talkTitle = talk.talkTitle;
		this.duration = talk.duration;
		this.startTime = new Time(talk.getStartTime().getHour(), talk.getStartTime().getMinute(), talk.getStartTime().getTimeMeasureEnum());
	}

	@Override
	public int compareTo(Talk obj) {

		if (!(obj instanceof Talk)) {
			return 0;
		}

		Talk other = (Talk) obj;

		return this.duration.getTime().compareTo(other.duration.getTime());
	}

	public String getTalkTitle() {
		return talkTitle;
	}

	/**
	 * @return the duration
	 */
	public Duration getDuration() {
		return duration;
	}

	/**
	 * @return the startTime
	 */
	public Time getStartTime() {
		return startTime;
	}

	/**
	 * @param talkTitle
	 *            the talkTitle to set
	 */
	public void setTalkTitle(String talkTitle) {
		this.talkTitle = talkTitle;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Time getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.getTime().hashCode());
		result = prime * result + ((talkTitle == null) ? 0 : talkTitle.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Talk other = (Talk) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.getTime().equals(other.duration.getTime()))
			return false;
		if (talkTitle == null) {
			if (other.talkTitle != null)
				return false;
		} else if (!talkTitle.equals(other.talkTitle))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return duration.toString();
	}

}
