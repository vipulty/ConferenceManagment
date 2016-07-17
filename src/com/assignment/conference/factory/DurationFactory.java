/**
 * 
 */
package com.assignment.conference.factory;

import com.assignment.conference.duration.Duration;
import com.assignment.conference.enums.TimeMeasureEnum;

/**
 * @author vipul
 *
 */
public class DurationFactory {

	/**
	 * 
	 * @param time
	 * @param timeMeasure
	 * @return
	 */
	public static Duration getDurationInstance(String time, String timeMeasureEnum) {

		final Integer timeInt = Integer.valueOf(time);

		final Duration duration = new Duration(timeInt, TimeMeasureEnum.getTimeMeasureEnum(timeMeasureEnum));

		return duration;
	}

	/**
	 * 
	 * @param time
	 * @param timeMeasure
	 * @return
	 */
	public static Duration getDurationInstance(String time, TimeMeasureEnum timeMeasureEnum) {

		final Integer timeInt = Integer.valueOf(time);

		final Duration duration = new Duration(timeInt, timeMeasureEnum);

		return duration;
	}

	/**
	 * 
	 * @param time
	 * @param timeMeasure
	 * @return
	 */
	public static Duration getDurationInstance(Integer time, TimeMeasureEnum timeMeasureEnum) {

		final Duration duration = new Duration(time, timeMeasureEnum);

		return duration;
	}

	/**
	 * 
	 * @param timeMeasure
	 * @return
	 */
	public static Duration getDurationInstance(String timeMeasure) {

		return TimeMeasureEnum.getTimeMeasureEnumActualValue(timeMeasure);
	}

}
