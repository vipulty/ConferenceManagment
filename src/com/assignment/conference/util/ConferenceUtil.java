package com.assignment.conference.util;

import com.assignment.conference.duration.Duration;
import com.assignment.conference.enums.TimeMeasureEnum;
import com.assignment.conference.time.Time;

public class ConferenceUtil {

	public ConferenceUtil() {
	
	}

	public static Duration getTimeDifference(Time start, Time end) {

		final Integer startHour = start.getHour();

		final Integer startMin = start.getMinute();

		final Integer endhour = end.getHour();

		final Integer endMin = end.getMinute();

		if (endMin == 00 && startMin == 00) {

			final Integer hourDifference = Math.abs(startHour - endhour);

			final Integer difference = hourDifference * 60;

			return new Duration(difference, TimeMeasureEnum.MIN);
		}

		return null;

	}

	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static Integer getTimeDifference(Integer start, Integer end) {
		return Math.abs(start - end);
	}

	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static Time addTime(Time time, Duration duration) {

		Integer hour = time.getHour();

		Integer min = time.getMinute();

		min = min + duration.getTime();

		if (duration.getTimeMeasureEnum() == TimeMeasureEnum.MIN && min == 60) {
			min = 00;
			hour++;
		} else if (min > 60) {
			int quotient = min / 60;
			int remainder = min % 60;

			hour = hour + quotient;
			min = remainder;
		}

		final Time updatedTime = new Time(hour, min, time.getTimeMeasureEnum());

		return updatedTime;

	}

}
