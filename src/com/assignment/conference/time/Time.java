package com.assignment.conference.time;

import com.assignment.conference.constants.Constants;
import com.assignment.conference.enums.TimeMeasureEnum;

public class Time implements Comparable<Time> {

	private Integer hour = 00;

	private Integer minute = 00;

	private Integer seconds = 00;

	private TimeMeasureEnum timeMeasureEnum;

	public Time(Integer hour, Integer minute, TimeMeasureEnum timeMeasureEnum) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.seconds = 00;
		this.timeMeasureEnum = timeMeasureEnum;
	}

	public Time(Integer hour, Integer minute, Integer seconds, TimeMeasureEnum timeMeasureEnum) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.seconds = seconds;
		this.timeMeasureEnum = timeMeasureEnum;
	}

	/**
	 * @return the hour
	 */
	public Integer getHour() {
		return hour;
	}

	/**
	 * @return the minute
	 */
	public Integer getMinute() {
		return minute;
	}

	/**
	 * @return the seconds
	 */
	public Integer getSeconds() {
		return seconds;
	}

	/**
	 * @return the timeMeasureEnum
	 */
	public TimeMeasureEnum getTimeMeasureEnum() {
		return timeMeasureEnum;
	}

	/**
	 * @param hour
	 *            the hour to set
	 */
	public void setHour(Integer hour) {
		this.hour = hour;
	}

	/**
	 * @param minute
	 *            the minute to set
	 */
	public void setMinute(Integer minute) {
		this.minute = minute;
	}

	/**
	 * @param seconds
	 *            the seconds to set
	 */
	public void setSeconds(Integer seconds) {
		this.seconds = seconds;
	}

	/**
	 * @param timeMeasureEnum
	 *            the timeMeasureEnum to set
	 */
	public void setTimeMeasureEnum(TimeMeasureEnum timeMeasureEnum) {
		this.timeMeasureEnum = timeMeasureEnum;
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
		result = prime * result + ((hour == null) ? 0 : hour.hashCode());
		result = prime * result + ((minute == null) ? 0 : minute.hashCode());
		result = prime * result + ((seconds == null) ? 0 : seconds.hashCode());
		result = prime * result + ((timeMeasureEnum == null) ? 0 : timeMeasureEnum.hashCode());
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
		Time other = (Time) obj;
		if (hour == null) {
			if (other.hour != null)
				return false;
		} else if (!hour.equals(other.hour))
			return false;
		if (minute == null) {
			if (other.minute != null)
				return false;
		} else if (!minute.equals(other.minute))
			return false;
		if (seconds == null) {
			if (other.seconds != null)
				return false;
		} else if (!seconds.equals(other.seconds))
			return false;
		if (timeMeasureEnum != other.timeMeasureEnum)
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
		return String.format("%02d", hour) + Constants.COLON + String.format("%02d", minute) + timeMeasureEnum;

	}

	@Override
	public int compareTo(Time other) {

		if (hour != null) {
			int i = hour.compareTo(other.hour);
			if (i != 0) {
				return i;
			}
		}

		if (minute != null) {
			int i = minute.compareTo(other.minute);
			if (i != 0) {
				return i;
			}
		}

		if (seconds != null) {
			int i = seconds.compareTo(other.seconds);
			if (i != 0) {
				return i;
			}
		}
		return 0;
	}
}
