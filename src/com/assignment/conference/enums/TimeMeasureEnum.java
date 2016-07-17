package com.assignment.conference.enums;

import java.util.HashMap;

import java.util.Map;

import com.assignment.conference.constants.Constants;
import com.assignment.conference.duration.Duration;
import com.assignment.conference.factory.DurationFactory;

public enum TimeMeasureEnum {
	SEC("sec"), MIN("min"), HOUR("hour"), AM("AM"), PM("PM"), LIGHTNING("lightning");

	private String value;

	private static Map<TimeMeasureEnum, Duration> timeMeasureMap = new HashMap<>();

	static {

		timeMeasureMap.put(LIGHTNING, DurationFactory.getDurationInstance(Constants.FIVE, TimeMeasureEnum.MIN));
	}

	/**
	 * 
	 * @param value
	 */
	private TimeMeasureEnum(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static TimeMeasureEnum getTimeMeasureEnum(String value) {

		for (TimeMeasureEnum timeMeasure : TimeMeasureEnum.values()) {

			if (value.equalsIgnoreCase(timeMeasure.value)) {
				return timeMeasure;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param timeMeasure
	 * @return
	 */
	public static Duration getTimeMeasureEnumActualValue(TimeMeasureEnum timeMeasure) {

		return timeMeasureMap.get(timeMeasure);
	}

	/**
	 * 
	 * @param timeMeasure
	 * @return
	 */
	public static Duration getTimeMeasureEnumActualValue(String timeMeasure) {

		return timeMeasureMap.get(getTimeMeasureEnum(timeMeasure));
	}

}
